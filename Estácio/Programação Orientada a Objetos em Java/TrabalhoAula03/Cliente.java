package TrabalhoAula03;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    // Atributos
    public String nomeCliente;
    public String dataCadastroCliente;
    private String cpfCnpjCliente;
    public Carrinho carrinho;

    // Contador de clientes
    public static int codigoCliente = 0;

    // Método criador
    public Cliente(String nomeCliente, String dataCadastroCliente, String cpfCnpjCliente) {
        this.nomeCliente = nomeCliente;
        this.dataCadastroCliente = dataCadastroCliente;
        this.cpfCnpjCliente = cpfCnpjCliente;
        codigoCliente++;
    }

    // Método para realizar cadastro de um cliente
    public static Cliente cadastrarCliente(Scanner scanner) {
    System.out.println("====== Cadastro de Cliente ======");
    System.out.println("Digite o nome do cliente:");
    String nomeCliente = scanner.nextLine();
    System.out.println("Digite o CPF ou CNPJ do cliente:");
    String cpfCnpjCliente = scanner.nextLine();
    while (!ValidaDocumento.cpfCnpj(cpfCnpjCliente)) {
        System.out.println("CPF/CNPJ inválido! Digite novamente:");
        cpfCnpjCliente = scanner.nextLine();
    }
    String dataCadastroCliente = Caixa.dataAtual();

    // Cria o cliente
    Cliente novoCliente = new Cliente(nomeCliente, dataCadastroCliente, cpfCnpjCliente);
    System.out.println("Cliente cadastrado com sucesso!");
    return novoCliente;
}

    // Método para exibir informações sobre o cliente
    public void exibirCliente() {
        System.out.println("====== Informações Cliente ======");
        System.out.println(String.format("Nome: " + nomeCliente));
        System.out.println(String.format("CPF/CNPJ: " + cpfCnpjCliente));
        System.out.println(String.format("Data do Cadastro: " + dataCadastroCliente));
    }

    // Método para o cliente realizar uma consulta de um item
    public void consultaItem(String itemVerificado, ArrayList<Item> itens) {
        for (Item item : itens){
            if (item.getNomeProduto().equals(itemVerificado)){
                item.exibirItem();
                return;
            }
        }
    }

    // Método para o cliente criar um carrinho
    public void criarCarrinho() {
        carrinho = new Carrinho();
    }

    // Método para o cliente adicionar um item ao carrinho
    public void adicionarItemCarrinho(String nomeitemadicionar, int quantidade) {
        for (Item item : Caixa.getItens()) {
            if (item.getNomeProduto().equals(nomeitemadicionar)) {
                carrinho.adicionarItem(item, quantidade);
            }
        }
    }

    // Método para o cliente exibir o carrinho
    public void exibirCarrinho() {
        carrinho.exibirCarrinho();
    }

    // Método para o cliente remover um item do carrinho
    public void removerItemCarrinho(String nomeitemadicionar, int quantidade) {
        for (Item item : Caixa.getItens()) {
            if (item.getNomeProduto().equals(nomeitemadicionar)) {
                carrinho.removerItem(item, quantidade);
            }
        }
    }

    // Método para o cliente limpar o carrinho
    public void limparCarrinho() {
        carrinho.limparCarrinho();
    }

    // Método get para carrinho
    public Carrinho getCarrinho() {
        return carrinho;
    }

    // Método para obter o CPF/CNPJ do Cliente
    public String getCpfCliente() {
        return cpfCnpjCliente;
    }

    // Método para obter o nome do Cliente
    public String getNomeCliente() {
        return nomeCliente;
    }

    // Método para verificar se o cliente tem um carrinho
    public boolean possuiCarrinho() {
        return carrinho != null;
    }

    // Método para calcular o valor total do carrinho
    public float calcularValorCarrinho() {
        if (carrinho != null) {
            return carrinho.getValorTotal();
        } else {
            System.out.println("O cliente ainda não possui um carrinho.");
            return 0.0f;
        }
    }

    // Método para finalizar a compra
    public void finalizarCompra(Loja loja) {
        if (carrinho != null && !carrinho.estaVazio()) {
            loja.realizarVenda(this);
            limparCarrinho(); // Limpa o carrinho após a compra
            System.out.println("Compra finalizada com sucesso!");
        } else {
            System.out.println("Não há itens no carrinho para finalizar a compra.");
        }
    }
}