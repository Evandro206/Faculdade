

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado da Avaliação</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">

        <h1>Resultado da Avaliação</h1>
        <div class="results-section">
            <?php
                    /* 
                    Paulo Otavio Duarte Rocha - 202402265385
                    Evandro Machado - 202405306147 
                    */
                $nomeAluno = trim($_GET['alunoNome']);
                $nota1 = trim($_GET['nota1']);
                $nota2 = trim($_GET['nota2']);
                $nota3 = trim($_GET['nota3']);
                if(empty($nomeAluno) || !is_numeric($nota1) || !is_numeric($nota2) || !is_numeric($nota3)){
                    echo "<p><a class=reprovado>ERRO, Preencha corretamente o formulario</a></p>";
                } else {
                    if($nota1 < 0 || $nota1 > 10){
                        echo "<p><a class=reprovado>ERRO, Alguma das notas é invalida</a></p>";
                    } else if($nota1 < 0 || $nota1 > 10){
                        echo "<p><a class=reprovado>ERRO, Alguma das notas é invalida</a></p>";
                    } else if($nota2 < 0 || $nota2 > 10){
                        echo "<p><a class=reprovado>ERRO, Alguma das notas é invalida</a></p>";
                    } else if($nota3 < 0 || $nota3 > 10){
                        echo "<p><a class=reprovado>ERRO, Alguma das notas é invalida</a></p>";
                    } else{
                        $media = ($nota1 + $nota2 + $nota3) / 3;
                        echo "<p><b>Resultados para: " . $nomeAluno . "</b></p>";
                        echo "<p><b>Notas Inseridas:</b><br>"
                        . "Nota1: " . $nota1 . "<br>"
                        . "Nota2: " . $nota2 . "<br>"
                        . "Nota3: " . $nota3 . "<br>" . "</p>";
                        echo "<p>Media Final: " . "<strong>" . number_format($media, 1 , ",") . "</strong></p>";
                        echo "<p>Situação: ";
                        if ($media >= 6){
                            echo "<a class=aprovado>Aprovado</a>";
                        } else {
                            echo "<a class=reprovado>Reprovado</a>";
                        }
                        echo "</p>";
                    }
                }
            ?>
            <a href="index.html" class="back-button">Voltar ao Formulário</a>
        </div>
    </div>
</body>

</html>