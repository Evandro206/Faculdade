<?php
 
// 1. Criar um array multidimensional para representar 3 carros
$carros = [
    [
        'marca'  => 'Toyota',
        'modelo' => 'Corolla',
        'ano'    => 2023
    ],
    [
        'marca'  => 'Honda',
        'modelo' => 'Civic',
        'ano'    => 2022
    ],
    [
        'marca'  => 'Volkswagen',
        'modelo' => 'Golf',
        'ano'    => 2024
    ]
];
 
echo "<h2>Informações dos Carros:</h2>";
 
echo "<pre>";
print_r($carros);
echo "</pre>";
 
// 2. Iterar sobre o array e exibir as informações de cada carro
//echo "<h3>Lista Detalhada de Carros:</h3>";
$cont = 1;
 
// Cada elemento do $carros é um array associativo de um carro individual
foreach ($carros as $carro) {
    //echo "<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 15px; border-radius: 5px; background-color: #f9f9f9;'>";
    echo "<h4>Carro #" . ($cont++) . "</h4>"; // Exibe o número do carro (começando do 1)
    echo "<p><strong>Marca:</strong> " . $carro['marca'] . "</p>";
    echo "<p><strong>Modelo:</strong> " . $carro['modelo'] . "</p>";
    echo "<p><strong>Ano:</strong> " . $carro['ano'] . "</p>";
    //echo "</div>";
}
 
?>