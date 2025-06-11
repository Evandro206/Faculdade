<!DOCTYPE html>
<html>
<head><title>Página PHP</title></head>
<body>
    <h1>Bem-vindo!</h1>
    <p>A data de hoje é: <?php echo date("d/m/Y"); ?></p>
    <?php
        $produto = "Caneta";
        $preco = 2.50;
        echo "<p>O produto $produto custa R$ " . number_format($preco, 2, ',', '.') . ".</p>";
    ?>
</body>
</html>