<?php
require_once "config.php";

$mensagem = "";
$classeMensagem = "";

// CREATE
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['acao']) && $_POST['acao'] == 'inserir') {
    $nome = trim($_POST["nome_produto"]);
    $preco = trim($_POST["preco_produto"]);
    $quantidade = trim($_POST["quantidade_produto"]);

    if (empty($nome) || !is_numeric($preco) || $preco < 0 || !is_numeric($quantidade) || $quantidade < 0) {
        $mensagem = "Por favor, preencha todos os campos corretamente para inserir.";
        $classeMensagem = "erro";
    } else {
        $sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES ('$nome','$preco','$quantidade')";
        $resultado = mysqli_query($MySQLi, $sql);
        $linhas = mysqli_affected_rows($MySQLi);

        if ($resultado && $linhas == 1) {
            $mensagem = "Produto inserido com sucesso!";
            $classeMensagem = "sucesso";
        } else {
            $mensagem = "Erro ao inserir produto id: " . $MySQLi->error;
            $classeMensagem = "erro";
        }
    }
}

// DELETE
if (isset($_GET['acao']) && $_GET['acao'] == 'excluir' && isset($_GET['id'])) {
    $id_para_excluir = $_GET['id'];
    $sql = "DELETE FROM produtos WHERE id = $id_para_excluir";
    $resultado = mysqli_query($MySQLi, $sql);
    $linhas = mysqli_affected_rows($MySQLi);

    if ($resultado && $linhas == 1) {
        $mensagem = "Produto excluído com sucesso!";
        $classeMensagem = "sucesso";
    } else {
        $mensagem = "Erro ao excluir produto id: " . $id_para_excluir;
        $classeMensagem = "erro";
    }
}

// EDITAR
$produto_para_editar = null;
if (isset($_GET['acao']) && $_GET['acao'] == 'editar' && isset($_GET['id'])) {
    $id_para_editar = $_GET['id'];
    $sql = "SELECT id, nome, preco, quantidade FROM produtos WHERE id = $id_para_editar";
    $resultado = mysqli_query($MySQLi, $sql);
    $linhas = mysqli_affected_rows($MySQLi);

    if ($resultado && $linhas == 1) {
        $produto_para_editar = mysqli_fetch_all($resultado, MYSQLI_ASSOC);
        //var_dump($produto_para_editar);
        $produto_para_editar = $produto_para_editar[0];
    } else {
        $mensagem = "Erro ao buscar produto para edição: " . $id_para_editar;
        $classeMensagem = "erro";
    }
}

// UPDATE
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['acao']) && $_POST['acao'] == 'atualizar') {
    $id = trim($_POST["id_produto"]);
    $nome = trim($_POST["nome_produto"]);
    $preco = trim($_POST["preco_produto"]);
    $quantidade = trim($_POST["quantidade_produto"]);

    if (empty($nome) || !is_numeric($preco) || $preco < 0 || !is_numeric($quantidade) || $quantidade < 0 || empty($id)) {
        $mensagem = "Por favor, preencha todos os campos e o ID corretamente para atualizar.";
        $classeMensagem = "erro";
    } else {
        $sql = "UPDATE produtos SET nome = '$nome', preco = '$preco', quantidade = '$quantidade' WHERE id = '$id'";
        $resultado = mysqli_query($MySQLi, $sql);
        $linhas = mysqli_affected_rows($MySQLi);

            if ($resultado && $linhas == 1) {
                $mensagem = "Produto atualizado com sucesso!";
                $classeMensagem = "sucesso";
            } else {
                $mensagem = "Erro ao atualizar produto id: " . $id;
                $classeMensagem = "erro";
            }
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produtos (CRUD)</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <h1>Gerenciador de Produtos</h1>

        <?php if (!empty($mensagem)): ?>
            <div class="mensagem <?php echo $classeMensagem; ?>">
                <?php echo $mensagem; ?>
            </div>
        <?php endif; ?>

        <h2><?php echo ($produto_para_editar ? 'Editar' : 'Adicionar'); ?> Produto</h2>
        <form action="index.php" method="POST">
            <?php if ($produto_para_editar): ?>
                <input type="hidden" name="acao" value="atualizar">
                <input type="hidden" name="id_produto" value="<?php echo $produto_para_editar['id']; ?>">
            <?php else: ?>
                <input type="hidden" name="acao" value="inserir">
            <?php endif; ?>

            <div class="form-group">
                <label for="nome_produto">Nome do Produto:</label>
                <input type="text" id="nome_produto" name="nome_produto"
                    value="<?php echo htmlspecialchars($produto_para_editar['nome'] ?? ''); ?>">
            </div>

            <div class="form-group">
                <label for="preco_produto">Preço:</label>
                <input type="number" id="preco_produto" name="preco_produto" step="0.01" min="0"
                    value="<?php echo htmlspecialchars($produto_para_editar['preco'] ?? ''); ?>">
            </div>

            <div class="form-group">
                <label for="quantidade_produto">Quantidade:</label>
                <input type="number" id="quantidade_produto" name="quantidade_produto" min="0"
                    value="<?php echo htmlspecialchars($produto_para_editar['quantidade'] ?? ''); ?>">
            </div>

            <button type="submit"><?php echo ($produto_para_editar ? 'Atualizar' : 'Adicionar'); ?> Produto</button>
        </form>

        <h2>Produtos Cadastrados</h2>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Preço</th>
                        <th>Quantidade</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    // Query para selecionar todos os produtos
                    $sql_select = "SELECT * FROM produtos ORDER BY id DESC";
                    $result_select = $MySQLi->query($sql_select) or trigger_error($MySQLi->error, E_USER_ERROR); // Executa a query

                    // mysqli_fetch_all() retorna um array vazio se não houver resultadoS
                    $produtos = mysqli_fetch_all($result_select, MYSQLI_ASSOC);

                    // Verifica se há produtos e itera sobre eles com foreach
                    if (!empty($produtos)) {
                        foreach ($produtos as $row) { // $row agora é um array associativo para cada produto
                            echo "<tr>";
                            echo "<td>" . $row['id'] . "</td>";
                            echo "<td>" . htmlspecialchars($row['nome']) . "</td>";
                            echo "<td>R$ " . number_format($row['preco'], 2, ',', '.') . "</td>";
                            echo "<td>" . htmlspecialchars($row['quantidade']) . "</td>";
                            echo "<td class='actions'>";
                            echo "<a href='index.php?acao=editar&id=" . htmlspecialchars($row['id']) . "' class='btn-editar'>Editar</a>";
                            echo "<a href='index.php?acao=excluir&id=" . htmlspecialchars($row['id']) . "' class='btn-excluir'>Excluir</a>";
                            echo "</td>";
                            echo "</tr>";
                        }
                    } else {
                        echo "<tr><td colspan='5'>Nenhum produto cadastrado ainda.</td></tr>";
                    }
                    ?>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>