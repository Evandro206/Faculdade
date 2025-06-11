<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado do Dia da Semana</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 80vh;
            background-color: #f4f4f4;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .resultado {
            margin-top: 20px;
            padding: 15px;
            border: 1px solid #e0e0e0;
            border-radius: 4px;
            background-color: #d4edda; /* Fundo verde claro para sucesso */
            color: #155724; /* Texto verde escuro */
            font-size: 1.2em;
            font-weight: bold;
        }
        .erro {
            background-color: #f8d7da; /* Fundo vermelho claro para erro */
            color: #721c24; /* Texto vermelho escuro */
        }
        .back-link {
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
 
    <div class="container">
        <h1>Resultado da Consulta</h1>
        <div class="resultado">
            <?php
            // Verifica se o parâmetro 'dia' foi enviado via GET
            if (isset($_GET['dia'])) {
                $numeroDia = (int)$_GET['dia']; // Converte o valor para inteiro
                $nomeDia = ''; // Variável para armazenar o nome do dia
 
                // Usa a estrutura switch para determinar o nome do dia
                switch ($numeroDia) {
                    case 1:
                        $nomeDia = 'Domingo';
                        break;
                    case 2:
                        $nomeDia = 'Segunda-feira';
                        break;
                    case 3:
                        $nomeDia = 'Terça-feira';
                        break;
                    case 4:
                        $nomeDia = 'Quarta-feira';
                        break;
                    case 5:
                        $nomeDia = 'Quinta-feira';
                        break;
                    case 6:
                        $nomeDia = 'Sexta-feira';
                        break;
                    case 7:
                        $nomeDia = 'Sábado';
                        break;
                    default:
                        $nomeDia = 'Número de dia inválido. Por favor, insira um número entre 1 e 7.';
                        break;
                }
               
                // Exibe o resultado ou a mensagem de erro
                echo "O dia " . $numeroDia . " é: <strong>" . $nomeDia . "</strong>";
 
            } else {
                // Mensagem exibida se o parâmetro não for encontrado (ex: acesso direto à página)
                echo "Nenhum dia foi fornecido. Use o formulário na página anterior.";
            }
            ?>
        </div>
        <a href="exemplo06.html" class="back-link">Voltar ao Formulário</a>
    </div>
 
</body>
</html>