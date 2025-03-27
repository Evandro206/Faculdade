package TrabalhoAula03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {

    // Atributos
    public String nomeLoja;
    public String cnpjLoja;
    public String razaoSocialLoja;
    public String enderecoLoja;
    private List<Cliente> clientes;

    // Contador de lojas
    public static int codigoLoja = 0;
    public static float saldoLoja = 0;

    // Método criador
    public Loja(String nomeLoja, String cnpjLoja, String razaoSocialLoja, String enderecoLoja) {
        this.nomeLoja = nomeLoja;
        this.cnpjLoja = cnpjLoja;
        this.razaoSocialLoja = razaoSocialLoja;
        this.enderecoLoja = enderecoLoja;
        this.clientes = new ArrayList<>();
        codigoLoja++;
    }

    // Método para cadastrar uma loja
    public static Loja cadastrarLoja(Scanner scanner) {
        System.out.println("====== Cadastro de Loja ======");

        System.out.println("Digite o nome da loja:");
        String nomeLoja = scanner.nextLine();

        System.out.println("Digite o CNPJ da loja:");
        String cnpjLoja = scanner.nextLine();
        while (!ValidaDocumento.cnpjValido(cnpjLoja)) {
            System.out.println("CNPJ inválido! Digite um CNPJ válido:");
            cnpjLoja = scanner.nextLine();
        }

        System.out.println("Digite a razão social da loja:");
        String razaoSocialLoja = scanner.nextLine();

        System.out.println("Digite o endereço da loja:");
        String enderecoLoja = scanner.nextLine();

        Loja loja = new Loja(nomeLoja, cnpjLoja, razaoSocialLoja, enderecoLoja);
        System.out.println("Loja cadastrada com sucesso!");
        return loja;
    }

    // método get para o nome da loja
    public String getNomeLoja() {
        return nomeLoja;
    }

    // método get para o CNPJ da loja
    public String getCnpjLoja() {
        return cnpjLoja;
    }

    // Método para exibir informações sobre a loja
    public void exibirLoja() {
        System.out.println("====== Informações Loja ======");
        System.out.println(String.format("Nome: " + nomeLoja));
        System.out.println(String.format("Código: " + codigoLoja));
        System.out.println(String.format("CNPJ: " + cnpjLoja));
        System.out.println(String.format("Razão Social: " + razaoSocialLoja));
        System.out.println(String.format("Endereço: " + enderecoLoja));
    }

    // Método para a Loja realizar uma consulta de um item 
    public void consultaItem(Item itemVerificado) {
        itemVerificado.exibirItem();
    }

    // Método para a Loja realizar um aumento de estoque 
    public void entradaItem(Item itemVerificado, int quantidade) {
        itemVerificado.entraProduto(quantidade);
    }

    // Método para a Loja realizar uma diminuição de estoque
    public void saidaItem(Item itemVerificado, int quantidade) {
        itemVerificado.saidaProduto(quantidade);
    }

    // Método para a Loja realizar uma alteração de quantidade de estoque
    public void setquatiItem(Item itemVerificado, int quantidade) {
        itemVerificado.setquatidadeProduto(quantidade);
    }

    // Método para loja realizar uma venda
    public void realizarVenda(Cliente cliente) {
        String dataVenda = Caixa.dataAtual();
        CupomVenda cupomVenda = new CupomVenda(dataVenda, cliente, this, cliente.getCarrinho());
        saldoLoja += cliente.carrinho.getValorTotal();
        cupomVenda.exibirCupomVenda();
    }

    // Método para a Loja realizar um cadastro de venda
    public CupomVenda cadastroVenda(Cliente cliente, Loja loja, Carrinho carrinho) {
        String dataVenda = Caixa.dataAtual();
        CupomVenda cupomVenda = new CupomVenda(dataVenda, cliente, loja, carrinho);
        cupomVenda.exibirCupomVenda();
        return cupomVenda;
    }

    // Método para a Loja exibir uma venda
    public void exibeVenda(CupomVenda cupomVenda) {
        cupomVenda.exibirCupomVenda();
    }

    // Método para adicionar um cliente a loja
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para adicionar varios clientes a loja
    public void adicionarClientes(ArrayList<Cliente> clientesrecebidos) {
        ArrayList<Cliente> copy = new ArrayList<>(clientesrecebidos);
        for (Cliente cliente : copy) {
            clientes.add(cliente);
        }
    }

    // Método get para lista de clientes da loja
    public List<Cliente> getClientes() {
        return clientes;
    }

    // Método para localizar cliente por cpf
    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpfCliente().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}