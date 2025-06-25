<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado Juros Simples</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">

        <div class="results-section">
            <?php
                    /* 
                    Paulo Otavio Duarte Rocha - 202402265385
                    Evandro Machado - 202405306147 
                    */
                $valorinicial = trim($_POST['capital']);
                $jurosporc = trim($_POST['taxa']);
                $tempo = trim($_POST['periodo']);
                if(!is_numeric($valorinicial) || !is_numeric($jurosporc) || !is_numeric($tempo)){
                    echo "<p class=error-message>Erro: Por favor, preencha todos os campos com valores numéricos validos maiores que zero</p>";
                } else {

                    $juroscalculado = ($valorinicial*$jurosporc/100)*$tempo;
                    $valorfinal = $juroscalculado + $valorinicial;
                    echo "<h2>Resultado do Cálculo de Juros Simples</h2>";
                    echo "<p>Capital Inicial: <strong> R$" . number_format($valorinicial, 2 , ",",".") . "</strong></p>";
                    echo "<p>Taxa de Juros: <strong>" . number_format($jurosporc, 2 , ",") . "% ao mês</strong></p>";
                    echo "<p>Período: <strong>" . $tempo  . " meses</strong></p>";
                    echo "<p>Juros Calculados: <strong> R$" . number_format($juroscalculado, 2 , ",",".") . "</strong></p>";
                    echo "<p>Montante Final: <strong> R$" . number_format($valorfinal, 2 , ",",".") . "</strong></p>";
                }
            ?>
            <a href="index.html" class="back-button">Calcular Novamente</a>
        </div>
    </div>
</body>

</html>