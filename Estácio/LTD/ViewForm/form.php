<?php
header("Access-Control-Allow-Origin: *"); // Permite acesso de qualquer domínio
header("Access-Control-Allow-Methods: GET, POST, OPTIONS"); // Permite os métodos listados
header("Access-Control-Allow-Headers: Content-Type"); // Permite o cabeçalho Content-Type
header('Content-Type: application/json');

// Seu código PHP
$days = isset($_GET['days']) ? intval($_GET['days']) : 0;
$dsn = 'mysql:host=localhost;dbname=transporte';
$username = 'root';
$password = '';

try {
  $pdo = new PDO($dsn, $username, $password);
  $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

  if ($days > 0) {
    $query = 'SELECT * FROM tb_viagem WHERE DATA_SAIDA BETWEEN DATE_SUB(CURDATE(), INTERVAL :days DAY) AND CURDATE()';
    $stmt  = $pdo->prepare($query);
    $stmt->bindParam(':days', $days, PDO::PARAM_INT);
  } else {
    $query = 'SELECT * FROM tb_viagem';
    $stmt  = $pdo->prepare($query);
  }
  
  $stmt->execute();
  $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

  echo json_encode($result);
} catch (PDOException $e) {
  echo json_encode(['error' => 'Falha na conexão: ' . $e->getMessage()]);
}
?>
