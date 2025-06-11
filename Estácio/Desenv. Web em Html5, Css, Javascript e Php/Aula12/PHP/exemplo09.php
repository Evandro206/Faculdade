<?php
 
// 1. Criar um array associativo para um produto
$produto = [
    'nome'    => 'Smart TV LED 50"',
    'preco'   => 2999.99,
    'estoque' => 15
];
 
echo "<h2>Detalhes do Produto:</h2>";
 
// Opcional: Para ver a estrutura completa do array (ótimo para debug)
echo "<pre>";
print_r($produto);
echo "</pre>";
 
// 2. Exibir o preço do produto
echo "<h3>Preço do Produto:</h3>";
echo "<p>O preço da " . $produto['nome'] . " é: <strong>R$ " . number_format($produto['preco'], 2, ',', '.') . "</strong></p>";
 
// Você também pode exibir outras informações se quiser:
echo "<p>Estoque disponível: " . $produto['estoque'] . " unidades</p>";
 
?>