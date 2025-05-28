<?php
// endpoint_motorista.php
error_reporting(E_ALL);
ini_set('display_errors', 0);
header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");

// Configurações do DB
$host   = 'localhost';
$dbname = 'transporte';
$user   = 'root';
$pass   = '';

try {
    $pdo = new PDO("mysql:host={$host};dbname={$dbname};charset=utf8", $user, $pass);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Supondo que a tabela de motoristas seja TB_MOTORISTA, com colunas id_motorista e DESC_MOTORISTA
    $stmt = $pdo->query("SELECT id_motorista AS id, DESC_MOTORISTA AS descricao FROM TB_MOTORISTA");
    $motoristas = $stmt->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($motoristas);
} catch (Exception $e) {
    http_response_code(500);
    echo json_encode(['mensagem' => "Erro ao carregar motoristas: " . $e->getMessage()]);
}
?>
