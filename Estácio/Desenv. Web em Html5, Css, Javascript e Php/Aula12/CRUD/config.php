<?php
$MySQL = array(
	'servidor' => '127.0.0.1',	    // Endereço do servidor
	'usuario' => 'root',		    // Usuario
	'senha' => '',				    // Senha
	'banco' => 'crud_produtos'		// Nome do banco de dados
);

$MySQLi = new MySQLi($MySQL['servidor'], $MySQL['usuario'], $MySQL['senha'], $MySQL['banco']);

if (mysqli_connect_errno())
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
?>