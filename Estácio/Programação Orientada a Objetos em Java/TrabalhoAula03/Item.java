package TrabalhoAula03;

import java.util.Scanner;

public class Item {
    
    // Atributos
	private String nomeProduto;
	private int quantidadeProduto;
	private float valorProduto;

    // Contador de produtos
    public static int codigoProduto = 0;
    
    // Método criador
    public Item(String nomeProduto, int quantidadeProduto, float valorProduto) {
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
        codigoProduto++;
    }

    // Método para cadastrar um item
    public static Item cadastrarItem(Scanner scanner) {
        String nomeItem;
        int quantidadeItem;
        float precoItem;
        System.out.print("Digite o nome do produto: ");
        nomeItem = scanner.nextLine();
        System.out.print("Digite a quantidade do produto: ");
        quantidadeItem = scanner.nextInt();
        System.out.print("Digite o preco do produto: ");
        precoItem = scanner.nextFloat();
        return new Item(nomeItem,quantidadeItem, precoItem);
    }

    // Método get para preco
    public float getPrecoItem() {
        return valorProduto;
    }

    // Método get para nome
    public String getNomeItem() {
        return nomeProduto;
    }

    // Método para exibir o item
    public void exibirItem() {
        System.out.println("------ Informações Produto ------");
        System.out.println("Nome do produto: " + nomeProduto);
        System.out.println("Código do produto: " + codigoProduto);
        System.out.println("Quantidade do produto: " + quantidadeProduto);
        System.out.println("Valor do produto: " + valorProduto);
    }

    // Método de aumento da quantidade de produtos
    public void entraProduto(int quantidadeProduto) {
        this.quantidadeProduto += quantidadeProduto;
    } 

    // Método de diminuição da quantidade de produtos
    public void saidaProduto(int quantidadeProduto) {
        this.quantidadeProduto -= quantidadeProduto;
    }

    // Método set para quantidade de produtos
    public void setquatidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    // Método set para preco do produto
    public void setPrecoItem(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    // Método get para quantidade de produtos
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    // Método get para nome do produto
    public String getNomeProduto() {
        return nomeProduto;
    }

    // Método get para valor do produto
    public float getValorProduto() {
        return valorProduto;
    }
}