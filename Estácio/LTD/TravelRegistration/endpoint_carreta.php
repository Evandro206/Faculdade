<?php
// endpoint_carreta.php
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

    $stmt = $pdo->query("SELECT id_carreta AS id, DESC_CARRETA AS descricao FROM TB_CARRETA");
    $carretas = $stmt->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($carretas);
} catch (Exception $e) {
    http_response_code(500);
    echo json_encode(['mensagem' => "Erro ao carregar carretas: " . $e->getMessage()]);
}
?>