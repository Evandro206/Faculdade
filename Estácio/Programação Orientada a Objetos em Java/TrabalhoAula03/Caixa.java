package TrabalhoAula03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Caixa{

    // Declaração do Scanner como variável de instância
    private static final Scanner scanner = new Scanner(System.in); // Scanner para leitura de dados
    private static ArrayList<Loja> lojas = new ArrayList<>(); // Lista de lojas
    private static ArrayList<Cliente> clientes = new ArrayList<>(); // Lista de Clientes
    private static ArrayList<Item> itens = new ArrayList<>(); // Lista de itens
    private static boolean continuar1 = true; // Variável para controlar o loop
    private static boolean continuar2 = true; // Variável para controlar o loop
    private static boolean continuar3 = true; // Variável para controlar o loop
    private static boolean continuar4 = true; // Variável para controlar o loop
    private static boolean continuar5 = true; // Variável para controlar o loop
    private static boolean continuar6 = true; // Variável para controlar o loop

    public static void main(String[] args) {
        lojas.addAll(Testes.LojasTeste(new String[0]));
        clientes.addAll(Testes.ClientesTeste(new String[0]));
        itens.addAll(Testes.ItensTeste(new String[0]));
        String oqueFazer1, oqueFazer2, oqueFazer3, oqueFazer4, oqueFazer5, oqueFazer6;
        // Menu Loja
        while (continuar1) {
            oqueFazer1 = exibirMenuLoja();
            switch (oqueFazer1) {
                case "1":
                    lojas.add(Loja.cadastrarLoja(scanner));
                    continuar1 = perguntarContinuar();
                    break;
                case "2":
                    System.out.println("====== Lista de Lojas ======");
                    for (Loja loja : lojas) {
                        loja.exibirLoja();
                    }
                    continuar1 = perguntarContinuar();
                    break;
                case "3":
                    System.out.println("Você deseja selecionar a loja pelo Índice ou pelo CNPJ?");
                    System.out.println("Digite '1' para Índice ou '2' para CNPJ:");
                    String escolha = scanner.nextLine();

                    Loja lojaSelecionada = null;
                    if (escolha.equals("1")) {
                        lojaSelecionada = selecionarLoja();
                    } else if (escolha.equals("2")) {
                        lojaSelecionada = selecionarLojaPorCNPJ();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    if (lojaSelecionada != null) {
                        System.out.println("=== Bem vindo ao caixa da loja " + lojaSelecionada.getNomeLoja() + " ===");
                        lojaSelecionada.adicionarClientes(clientes);
                        continuar2 = true;
                        // Interface Loja
                        while (continuar2) {
                            oqueFazer2 = interfaceLoja();
                            switch (oqueFazer2) {
                                case "1":
                                    // Menu Cliente
                                    continuar3 = true;
                                    while (continuar3) {
                                        oqueFazer3 = exibirMenuCliente();
                                        switch (oqueFazer3) {
                                            case "1":
                                                Cliente novoCliente = Cliente.cadastrarCliente(scanner);
                                                if (novoCliente != null) {
                                                    lojaSelecionada.adicionarCliente(novoCliente);
                                                    novoCliente.criarCarrinho();
                                                } else {
                                                    System.out.println("Falha ao cadastrar cliente.");
                                                }
                                                continuar3= perguntarContinuar();
                                                break;
                                            case "2":
                                                System.out.println("====== Lista de Clientes ======");
                                                if (lojaSelecionada.getClientes().isEmpty()) {
                                                    System.out.println("Nenhum cliente cadastrado na loja!");
                                                } else {
                                                    for (Cliente cliente : lojaSelecionada.getClientes()) {
                                                        cliente.exibirCliente();
                                                    }
                                                }
                                                continuar3 = perguntarContinuar();
                                                break;
                                            case "3":
                                                System.out.println("Digite o CPF/CNPJ do cliente que deseja selecionar:");
                                                String cpfPesquisa = scanner.nextLine().trim();
                                                if (cpfPesquisa.isEmpty()) {
                                                    System.out.println("CPF/CNPJ inválido. Por favor, insira um CPF/CNPJ válido.");
                                                } else {
                                                    Cliente clienteEncontrado = lojaSelecionada.buscarClientePorCPF(cpfPesquisa);
                                                    if (clienteEncontrado != null) {
                                                        System.out.println("Cliente selecionado: " + clienteEncontrado.getNomeCliente());
                                                        // Interface Cliente
                                                        while (continuar4) {
                                                            oqueFazer4 = interfaceDoCliente();
                                                            switch (oqueFazer4) {
                                                                case "1":
                                                                    System.out.println("====== Lista de Itens ======");
                                                                    for (Item item : itens) {
                                                                        System.out.println(item.getNomeItem());
                                                                    }
                                                                    System.out.println("Qual item vc deseja consultar: ");
                                                                    String itemconsultar = scanner.nextLine();
                                                                    clienteEncontrado.consultaItem(itemconsultar, itens);
                                                                    continuar4 = perguntarContinuar();
                                                                    break;
                                                                case "2":
                                                                    System.out.println("Qual item vc deseja adicionar: ");
                                                                    String itemadicionar = scanner.nextLine();
                                                                    System.out.println("Quantidade: ");
                                                                    int quantidade = scanner.nextInt();
                                                                    clienteEncontrado.adicionarItemCarrinho(itemadicionar, quantidade);
                                                                    continuar4 = perguntarContinuar();
                                                                    break;
                                                                case "3":
                                                                    System.out.println("Qual item vc deseja remover: ");
                                                                    String itemremover = scanner.nextLine();
                                                                    System.out.println("Quantidade: ");
                                                                    int quantidade2 = scanner.nextInt();
                                                                    clienteEncontrado.removerItemCarrinho(itemremover, quantidade2);
                                                                    continuar4 = perguntarContinuar();
                                                                    break;
                                                                case "4":
                                                                    clienteEncontrado.limparCarrinho();
                                                                    continuar4 = perguntarContinuar();
                                                                    break;
                                                                case "5":
                                                                    clienteEncontrado.exibirCarrinho();
                                                                    continuar4 = perguntarContinuar();
                                                                    break;
                                                                case "6":
                                                                    clienteEncontrado.finalizarCompra(lojaSelecionada);
                                                                    continuar4 = perguntarContinuar();
                                                                    break;
                                                                case "7":
                                                                    System.out.println("Voltando ao menu anterior...");
                                                                    continuar4 = false;
                                                                    break;
                                                                case "8":
                                                                    System.out.println("Saindo...");
                                                                    scanner.close();
                                                                    System.exit(0);
                                                                default:
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Nenhum cliente encontrado com o CPF informado.");
                                                    }
                                                }
                                                break;
                                            case "4":
                                                System.out.println("Voltando ao menu anterior...");
                                                continuar3 = false;
                                                break;
                                            case "5":
                                                System.out.println("Saindo...");
                                                scanner.close();
                                                System.exit(0);
                                                break;
                                            default:
                                                System.out.println("Opção inválida!");
                                                break;
                                        }
                                    }
                                    break;
                                case "2":
                                    continuar5 = true;
                                    // Menu Item
                                    while (continuar5) {
                                        oqueFazer5 = exibirMenuItem();
                                        switch (oqueFazer5) {
                                            case "1":
                                                itens.add(Item.cadastrarItem(scanner));
                                                continuar5 = perguntarContinuar();
                                                break;
                                            case "2":
                                                for (Item item : itens) {
                                                    System.out.println(item.getNomeItem());
                                                }
                                                continuar5 = perguntarContinuar();
                                                break;
                                            case "3":
                                                System.out.println("Qual item deseja selecionar: ");
                                                String itemadicionar = scanner.nextLine();
                                                for (Item item : itens) {
                                                    if (item.getNomeItem().equals(itemadicionar)) {
                                                        System.out.println("Item selecionado: " + itemadicionar);
                                                        // Interface Item
                                                        while (continuar6) {
                                                            oqueFazer6 = interfaceDoItem();
                                                            switch (oqueFazer6) {
                                                                case "1":
                                                                    item.exibirItem();
                                                                    continuar6 = perguntarContinuar();
                                                                    break;
                                                                case "2":
                                                                    System.out.println("Digite qual a quantidade que deseja adicionar: ");
                                                                    int quantidadeAdicionar = scanner.nextInt();
                                                                    item.entraProduto(quantidadeAdicionar);
                                                                    continuar6 = perguntarContinuar();
                                                                    break;
                                                                case "3":
                                                                    System.out.println("Digite qual a quantidade que deseja remover: ");
                                                                    int quantidadeRemover = scanner.nextInt();
                                                                    item.saidaProduto(quantidadeRemover);
                                                                    continuar6 = perguntarContinuar();
                                                                    break;
                                                                case "4":
                                                                    System.out.println("Digite qual a quantidade que deseja definir: ");
                                                                    int quantidadeDefinir = scanner.nextInt();
                                                                    item.setquatidadeProduto(quantidadeDefinir);
                                                                    continuar6 = perguntarContinuar();
                                                                    break;
                                                                case "5":
                                                                    System.out.println("Digite qual o valor que deseja definir: ");
                                                                    float valorDefinir = scanner.nextFloat();
                                                                    item.setPrecoItem(valorDefinir);
                                                                    continuar6 = perguntarContinuar();
                                                                    break;
                                                                case "6":
                                                                    System.out.println("Voltando ao menu anterior...");
                                                                    continuar6 = false;
                                                                    break;
                                                                case "7":
                                                                    System.out.println("Saindo...");
                                                                    scanner.close();
                                                                    System.exit(0);
                                                                    break;
                                                                default:
                                                                    break;
                                                            }

                                                        }
                                                    }
                                                }
                                                break;
                                            case "4":
                                                System.out.println("Voltando ao menu anterior...");
                                                continuar5 = false;
                                                break;
                                            case "5":
                                                System.out.println("Saindo...");
                                                scanner.close();
                                                System.exit(0);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    break;
                                case "3":
                                    System.out.println("Voltando ao menu anterior...");
                                    continuar2 = false;
                                    break;
                                case "4":
                                    System.out.println("Saindo...");
                                    scanner.close();
                                    return;
                                default:
                                    break;
                            }
                        }
                    }
                    continuar1 = perguntarContinuar();
                    break;
                case "4":
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

    }

    // Método para obter data
    public static String dataAtual() {
        LocalDateTime agora = LocalDateTime.now(); // Obtém a data e hora atuais
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato desejado
        return agora.format(formatter); // Retorna a data formatada
    }

    // Método para gerar continuidade do código
    public static boolean perguntarContinuar() {
        while (true) {
            try {
                System.out.println("Deseja continuar? (S/N)");
                String simNao = scanner.nextLine().trim().toUpperCase(); 
                if (simNao.equals("N")) {
                    return false;
                } else if (simNao.equals("S")) {
                    return true;
                } else {
                    System.out.println("Opção inválida! Digite 'S' ou 'N'.");
                }
            } catch (Exception e) { 
                System.out.println("Erro inesperado: " + e.getMessage());
                return false;
            }
        }
    }

    // Método para retornar a lista de itens cadastrados no sistema
    public static ArrayList<Item> getItens() {
        return itens;
    }

    // Método para exibir menu de Loja
    public static String exibirMenuLoja() {
        System.out.println("====== Sistema Unificado de Caixa ======");
        System.out.println("============== Bem Vindo! ==============");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Loja");
        System.out.println("2 - Listar Lojas");
        System.out.println("3 - Selecionar Loja");
        System.out.println("4 - Sair");
        return scanner.nextLine();
    }

    // Método para exibir a interface da Loja
    public static String interfaceLoja() {
        System.out.println("=== Bem vindo a interface da Loja ===");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Ir para menu de clientes");
        System.out.println("2 - Ir para menu de itens");
        System.out.println("3 - Voltar ao menu anterior");
        System.out.println("4 - Sair");
        return scanner.nextLine();
    }

    // Método para exibir o menu do Cliente
    public static String exibirMenuCliente() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Selecionar Cliente");
        System.out.println("4 - Voltar ao Menu Anterior");
        System.out.println("5 - Sair");
        return scanner.nextLine();
    }

    // Método para exibir a Interface do Cliente
    public static String interfaceDoCliente() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Consultar item");
        System.out.println("2 - Adicionar item ao carrinho");
        System.out.println("3 - Remover item do carrinho");
        System.out.println("4 - Limpar carrinho");
        System.out.println("5 - exibir carrinho");
        System.out.println("6 - Finalizar compra");
        System.out.println("7 - Voltar ao Menu Anterior");
        System.out.println("8 - Sair");
        return scanner.nextLine();
    }

    // Método para exibir o Menu do Item
    public static String exibirMenuItem() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Item");
        System.out.println("2 - Listar Itens");
        System.out.println("3 - Selecionar Item");
        System.out.println("4 - Voltar ao Menu Anterior");
        System.out.println("5 - Sair");
        return scanner.nextLine();
    }

    // Método para exibir a Interface do Item
    public static String interfaceDoItem() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Exibir item");
        System.out.println("2 - Adicionar quantidade do item");
        System.out.println("3 - Remover quantidade do item");
        System.out.println("4 - Editar quantidade do item");
        System.out.println("5 - Editar valor do item");
        System.out.println("6 - Voltar ao Menu Anterior");
        System.out.println("7 - Sair");
        return scanner.nextLine();
    }

    // Método para buscar loja
    public static Loja selecionarLoja() {
        if (lojas.isEmpty()) {
            System.out.println("Nenhuma loja cadastrada!");
            return null;
        }
        System.out.println("Escolha uma loja pelo índice:");
        for (int i = 0; i < lojas.size(); i++) {
            System.out.println(i + " - " + lojas.get(i).getNomeLoja());
        }
        Loja lojaSelecionada = null;
        try {
            int indice = Integer.parseInt(scanner.nextLine().trim());
            if (indice < 0 || indice >= lojas.size()) {
                System.out.println("Índice inválido.");
            } else {
                lojaSelecionada = lojas.get(indice);
                System.out.println("Loja selecionada: " + lojaSelecionada.getNomeLoja());
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Por favor, insira um número.");
        }
        return lojaSelecionada;
    }

    // Método auxiliar que busca a loja pelo CNPJ
    public static Loja buscarLojaPorCNPJ(String cnpjPesquisa) {
        for (Loja loja : lojas) {
            if (loja.getCnpjLoja().equals(cnpjPesquisa)) {
                return loja;
            }
        }
        return null;
    }

    // Método que interage com o usuário para selecionar a loja pelo CNPJ
    public static Loja selecionarLojaPorCNPJ() {
        if (lojas.isEmpty()) {
            System.out.println("Nenhuma loja cadastrada!");
            return null;
        }
        System.out.println("Digite o CNPJ da loja que deseja selecionar:");
        String cnpjPesquisa = scanner.nextLine().trim();
        if (cnpjPesquisa.isEmpty()) {
            System.out.println("Entrada vazia! Por favor, insira um CNPJ válido.");
            return null;
        }
        Loja lojaEncontrada = buscarLojaPorCNPJ(cnpjPesquisa);
        if (lojaEncontrada != null) {
            System.out.println("Bem-vindo à Loja: " + lojaEncontrada.getNomeLoja() + "!");
        } else {
            System.out.println("Nenhuma loja encontrada com o CNPJ informado.");
        }
        return lojaEncontrada;
    }
}