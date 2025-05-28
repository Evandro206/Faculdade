<?php
// endpoint_proximo_id.php
error_reporting(E_ALL);
ini_set('display_errors', 0);
header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");

$host   = 'localhost';
$dbname = 'transporte';
$user   = 'root';
$pass   = '';

try {
    $pdo = new PDO("mysql:host={$host};dbname={$dbname};charset=utf8", $user, $pass);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $stmt = $pdo->query("SELECT MAX(id_viagem) AS ultimo_id FROM TB_VIAGEM");
    $resultado = $stmt->fetch(PDO::FETCH_ASSOC);
    $proximo_id = $resultado['ultimo_id'] + 1;

    echo json_encode(['proximo_id' => $proximo_id]);
} catch (Exception $e) {
    http_response_code(500);
    echo json_encode(['mensagem' => "Erro ao obter próximo ID: " . $e->getMessage()]);
}
?>