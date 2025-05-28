<?php
// endpoint_cavalo.php
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

    $stmt = $pdo->query("SELECT id_cavalo AS id, DESC_CAVALO AS descricao FROM TB_CAVALO");
    $cavalos = $stmt->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($cavalos);
} catch (Exception $e) {
    http_response_code(500);
    echo json_encode(['mensagem' => "Erro ao carregar cavalos: " . $e->getMessage()]);
}
?>