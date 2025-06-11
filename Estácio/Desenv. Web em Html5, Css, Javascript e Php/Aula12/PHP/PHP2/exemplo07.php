<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Números de 1 a 20</title>    
</head>
<body>
 
    <div class="container">
        <h1>Números de 1 a 20</h1>
 
        <?php
        // Loop for para iterar de 1 a 20
        for ($i = 1; $i <= 20; $i++) {
            $saida = $i . " - "; // Começa com o número
 
            // Verifica se é múltiplo de 5
            if ($i % 5 == 0) {
                $saida .= "<span class='multiplo'>Múltiplo de 5 e </span>";
            }
 
            // Verifica se é par ou ímpar
            if ($i % 2 == 0) {
                $saida .=  "<span class='par'>Par</span>";
            } else {
                $saida .=  "<span class='impar'>Ímpar</span>";
            }
 
            // Exibe o resultado para o número atual
            echo "<div class='item'>" . $saida . "</div>";
        }
        ?>
 
    </div>
 
</body>
</html>