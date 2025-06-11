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
 
        echo $nomeDia; // Exibe o nome do dia ou a mensagem de erro
    } else {
        echo "Parâmetro 'dia' não recebido.";
    }
?>