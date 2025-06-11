<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Variáveis</title>
</head>
<body>
    <h1>Operações usando X e Y</h1>
    <p>Quando x = 5 e y = 7</p>
    <?php
        $x = 5;
        $y = 7;
        echo "<p>Soma = " . $x + $y . "<br>";
        echo "<p>Subtração = " . $x - $y . "<br>";
        echo "<p>Multiplicação = " . $x * $y . "<br>";
        echo "<p>Divisão = " . number_format($x / $y, 2) . "<br>";
    ?>
</body>
</html>