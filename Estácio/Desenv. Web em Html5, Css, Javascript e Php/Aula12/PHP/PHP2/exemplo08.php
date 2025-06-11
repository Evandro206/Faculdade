<?php
 
// 1. Criar um array com 5 nomes de cidades
$cidades = ['Rio de Janeiro', 'São Paulo', 'Belo Horizonte', 'Salvador', 'Curitiba'];
 
echo "<h2>Cidades no Array:</h2>";
//echo "<pre>";
var_dump($cidades);
//echo "</pre>";
 
// 2. Exibir o 3º nome
echo "<h3>3º Nome no Array:</h3>";
echo "<p>O 3º nome na lista é: <strong>" . $cidades[2] . "</strong></p>";
 
// 3. Adicionar um novo nome
$cidades[] = 'Fortaleza';
 
echo "<h3>Array com o novo nome:</h3>";
echo "<pre>";
print_r($cidades);
echo "</pre>";
 
// 4. Exibir o total de cidades
echo "<h3>Total de Cidades:</h3>";
echo "<p>O total de cidades no array é: <strong>" . count($cidades) . "</strong></p>";
 
?>