<?php
error_reporting(E_ALL);
ini_set('display_errors', 0); // Em produção, não exibir detalhes dos erros

header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Headers: Content-Type");

// Recebe o JSON enviado no corpo da requisição
$json = file_get_contents('php://input');
if (empty($json)) {
    echo json_encode(['mensagem' => 'Nenhum dado recebido.']);
    exit;
}

$data = json_decode($json, true);
if (!$data) {
    echo json_encode(['mensagem' => 'Erro ao decodificar JSON.']);
    exit;
}

// Validação básica dos dados essenciais
if (!isset($data['data_viagem'], $data['inicio'], $data['motorista'])) {
    http_response_code(400);
    echo json_encode(['mensagem' => 'Dados essenciais ausentes.']);
    exit;
}

// Configuração do banco de dados – ajuste conforme o seu ambiente
$host   = 'localhost';
$dbname = 'transporte';
$user   = 'root';
$pass   = '';

try {
    $pdo = new PDO("mysql:host={$host};dbname={$dbname};charset=utf8", $user, $pass);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Inicia uma transação para manter inserções atômicas
    $pdo->beginTransaction();

    // INSERÇÃO NA TABELA TB_VIAGEM
    // Mapeamento:
    // data_saida        <- data_viagem
    // hora_saida        <- inicio
    // id_motorista      <- motorista
    // id_deposito       <- deposito
    // id_fabrica        <- fabrica
    // id_cavalo         <- cavalo
    // id_carreta        <- carreta
    // data_chegada      <- chegada.data
    // hora_chegada      <- chegada.hora
    $stmt = $pdo->prepare("INSERT INTO TB_VIAGEM 
      (data_saida, hora_saida, id_motorista, id_deposito, id_fabrica, id_cavalo, id_carreta, data_chegada, hora_chegada)
      VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
      
    $stmt->execute([
        $data['data_viagem'],
        $data['inicio'],
        $data['motorista'],
        $data['deposito'] ?? null,
        $data['fabrica']  ?? null,
        $data['cavalo']   ?? null,
        $data['carreta']  ?? null,
        isset($data['chegada']['data']) ? trim($data['chegada']['data']) : null,
        isset($data['chegada']['hora']) ? trim($data['chegada']['hora']) : null
    ]);
    $viagem_id = $pdo->lastInsertId();

    // Arrays para armazenar os IDs das paradas e trechos inseridos
    $paradas_ids = array("ida" => array(), "volta" => array());
    $trechos_ids = array("ida" => array(), "volta" => array());

    // INSERÇÃO DAS PARADAS E TRECHOS DA IDA
    if (isset($data['ida']['paradas']) && is_array($data['ida']['paradas'])) {
        $stmtParadaIda = $pdo->prepare("INSERT INTO TB_PARADA (tipo, hora_inicio, hora_fim) VALUES (?, ?, ?)");
        foreach ($data['ida']['paradas'] as $parada) {
            // Valida os dados obrigatórios
            if (empty(trim($parada['tipo'])) || empty(trim($parada['inicio'])) || empty(trim($parada['fim']))) {
                throw new Exception("Dados incompletos para uma parada da ida.");
            }
            $stmtParadaIda->execute([
                trim($parada['tipo']),
                trim($parada['inicio']),
                trim($parada['fim'])
            ]);
            // Armazena o id gerado
            $paradas_ids["ida"][] = $pdo->lastInsertId();
        }
    }
    if (isset($data['ida']['trechos']) && is_array($data['ida']['trechos'])) {
        $stmtTrechoIda = $pdo->prepare("INSERT INTO TB_TRECHO (hora_inicio, hora_fim) VALUES (?, ?)");
        foreach ($data['ida']['trechos'] as $trecho) {
            if (empty(trim($trecho['inicio'])) || empty(trim($trecho['fim']))) {
                throw new Exception("Dados incompletos para um trecho da ida.");
            }
            $stmtTrechoIda->execute([
                trim($trecho['inicio']),
                trim($trecho['fim'])
            ]);
            $trechos_ids["ida"][] = $pdo->lastInsertId();
        }
    }

    // INSERÇÃO DAS PARADAS E TRECHOS DA VOLTA
    if (isset($data['volta']['paradas']) && is_array($data['volta']['paradas'])) {
        $stmtParadaVolta = $pdo->prepare("INSERT INTO TB_PARADA (tipo, hora_inicio, hora_fim) VALUES (?, ?, ?)");
        foreach ($data['volta']['paradas'] as $parada) {
            if (empty(trim($parada['tipo'])) || empty(trim($parada['inicio'])) || empty(trim($parada['fim']))) {
                throw new Exception("Dados incompletos para uma parada da volta.");
            }
            $stmtParadaVolta->execute([
                trim($parada['tipo']),
                trim($parada['inicio']),
                trim($parada['fim'])
            ]);
            $paradas_ids["volta"][] = $pdo->lastInsertId();
        }
    }
    if (isset($data['volta']['trechos']) && is_array($data['volta']['trechos'])) {
        $stmtTrechoVolta = $pdo->prepare("INSERT INTO TB_TRECHO (hora_inicio, hora_fim) VALUES (?, ?)");
        foreach ($data['volta']['trechos'] as $trecho) {
            if (empty(trim($trecho['inicio'])) || empty(trim($trecho['fim']))) {
                throw new Exception("Dados incompletos para um trecho da volta.");
            }
            $stmtTrechoVolta->execute([
                trim($trecho['inicio']),
                trim($trecho['fim'])
            ]);
            $trechos_ids["volta"][] = $pdo->lastInsertId();
        }
    }

    // INSERÇÃO DAS PARADAS DE CHEGADA (REFEIÇÃO E TEMPO DE ESPERA)
    // Esses registros serão cadastrados como paradas da volta
    if (isset($data['chegada'])) {
        // Inserção da parada de Refeição
        if (isset($data['chegada']['refeicao']) && 
            !empty(trim($data['chegada']['refeicao']['inicio'])) && 
            !empty(trim($data['chegada']['refeicao']['fim']))) {
            $stmtRefeicao = $pdo->prepare("INSERT INTO TB_PARADA (tipo, hora_inicio, hora_fim) VALUES (?, ?, ?)");
            // Se preferir, substitua trim($data['chegada']['refeicao']['id']) por um valor fixo, ex.: "refeicao"
            $stmtRefeicao->execute([
                trim($data['chegada']['refeicao']['id']),
                trim($data['chegada']['refeicao']['inicio']),
                trim($data['chegada']['refeicao']['fim'])
            ]);
            $paradas_ids["volta"][] = $pdo->lastInsertId();
        }

        // Inserção da parada de Tempo de Espera
        if (isset($data['chegada']['tempo_espera']) &&
            !empty(trim($data['chegada']['tempo_espera']['inicio'])) &&
            !empty(trim($data['chegada']['tempo_espera']['fim']))) {
            $stmtTempoEspera = $pdo->prepare("INSERT INTO TB_PARADA (tipo, hora_inicio, hora_fim) VALUES (?, ?, ?)");
            // Se preferir, utilize um valor fixo como "tempo_espera" no lugar de trim($data['chegada']['tempo_espera']['id'])
            $stmtTempoEspera->execute([
                trim($data['chegada']['tempo_espera']['id']),
                trim($data['chegada']['tempo_espera']['inicio']),
                trim($data['chegada']['tempo_espera']['fim'])
            ]);
            $paradas_ids["volta"][] = $pdo->lastInsertId();
        }
    }

    // Atualiza a tabela TB_VIAGEM com os IDs das paradas e trechos
    // Armazena os arrays como strings JSON nas colunas "paradas" e "trechos"
    $stmtUpdate = $pdo->prepare("UPDATE TB_VIAGEM SET paradas = ?, trechos = ? WHERE ID_VIAGEM = ?");
    $stmtUpdate->execute([
        json_encode($paradas_ids),
        json_encode($trechos_ids),
        $viagem_id
    ]);

    // Confirma a transação
    $pdo->commit();

    echo json_encode([
        'mensagem' => 'Viagem cadastrada com sucesso!',
        'id_viagem' => $viagem_id
    ]);
} catch (Exception $e) {
    if ($pdo->inTransaction()) {
        $pdo->rollBack();
    }
    http_response_code(500);
    echo json_encode(['mensagem' => 'Erro ao cadastrar a viagem: ' . $e->getMessage()]);
}
?>
