<?php
error_reporting(E_ALL);
ini_set('display_errors', 0); // Em produção, evite exibir erros detalhados

header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Headers: Content-Type");

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

if (!isset($data['registro'])) {
    http_response_code(400);
    echo json_encode(['mensagem' => 'Tipo de registro não informado.']);
    exit;
}

$registro = $data['registro'];

// Configurações do banco de dados
$host   = 'localhost';
$dbname = 'transporte';
$user   = 'root';
$pass   = '';

try {
    $pdo = new PDO("mysql:host={$host};dbname={$dbname};charset=utf8", $user, $pass);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    switch($registro) {
        case "cidade":
            if (empty(trim($data['descricao']))) {
                throw new Exception("Descrição obrigatória para cidade.");
            }
            $stmt = $pdo->prepare("INSERT INTO TB_CIDADE (DESC_CIDADE) VALUES (?)");
            $stmt->execute([trim($data['descricao'])]);
            break;

        case "setor":
            if (empty(trim($data['descricao']))) {
                throw new Exception("Descrição obrigatória para setor.");
            }
            $stmt = $pdo->prepare("INSERT INTO TB_SETOR (DESC_SETOR) VALUES (?)");
            $stmt->execute([trim($data['descricao'])]);
            break;

        case "carreta":
            if (empty(trim($data['descricao'])) || empty(trim($data['placa']))) {
                throw new Exception("Descrição e placa obrigatórias para carreta.");
            }
            $stmt = $pdo->prepare("INSERT INTO TB_CARRETA (DESC_CARRETA, PLACA_CARRETA) VALUES (?, ?)");
            $stmt->execute([trim($data['descricao']), trim($data['placa'])]);
            break;

        case "motorista":
            if (empty(trim($data['descricao'])) || empty(trim($data['id_setor'])) || empty(trim($data['id_cidade']))) {
                throw new Exception("Descrição, ID do setor e ID da cidade são obrigatórios para motorista.");
            }
            $stmt = $pdo->prepare("INSERT INTO TB_MOTORISTA (DESC_MOTORISTA, ID_SETOR, ID_CIDADE) VALUES (?, ?, ?)");
            $stmt->execute([trim($data['descricao']), trim($data['id_setor']), trim($data['id_cidade'])]);
            break;

        case "cavalo":
            if (empty(trim($data['tipo'])) || empty(trim($data['descricao'])) || empty(trim($data['placa']))) {
                throw new Exception("Tipo, descrição e placa obrigatórios para cavalo.");
            }
            $stmt = $pdo->prepare("INSERT INTO tb_cavalo (TIPO_CAVALO, desc_cavalo, placa_cavalo) VALUES (?, ?, ?)");
            $stmt->execute([trim($data['tipo']), trim($data['descricao']), trim($data['placa'])]);
            break;

        case "deposito":
            if (empty(trim($data['descricao']))) {
                throw new Exception("Descrição obrigatória para depósito.");
            }
            $stmt = $pdo->prepare("INSERT INTO TB_DEPOSITO (DESC_DEPOSITO) VALUES (?)");
            $stmt->execute([trim($data['descricao'])]);
            break;

        case "fabrica":
            if (empty(trim($data['descricao']))) {
                throw new Exception("Descrição obrigatória para fábrica.");
            }
            $stmt = $pdo->prepare("INSERT INTO TB_FABRICA (DESC_FABRICA) VALUES (?)");
            $stmt->execute([trim($data['descricao'])]);
            break;

        default:
            http_response_code(400);
            echo json_encode(['mensagem' => 'Tipo de registro inválido.']);
            exit;
    }

    echo json_encode(['mensagem' => ucfirst($registro) . ' cadastrado com sucesso!']);
} catch (Exception $e) {
    http_response_code(500);
    // Em produção, recomenda-se não exibir erros detalhados ao usuário
    echo json_encode(['mensagem' => 'Erro ao cadastrar ' . $registro . ': ' . $e->getMessage()]);
}
?>
