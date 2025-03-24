package TrabalhoAula03;

public class Item {
    
    // Atributos
	private String nomeProduto;
	private int quantidadeProduto;
	private float valorProduto;

    // Contador de produtos
    public static int codigoProduto = 1;
    
    // Método criador
    public Item(String nomeProduto, int quantidadeProduto, float valorProduto) {
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
        codigoProduto++;
    }

    public void exibirItem() {
        System.out.println("Nome do produto: " + nomeProduto);
        System.out.println("Código do produto: " + codigoProduto);
        System.out.println("Quantidade do produto: " + quantidadeProduto);
        System.out.println("Valor do produto: " + valorProduto);
    }

    public void entraProduto(int quantidadeProduto) {
        this.quantidadeProduto += quantidadeProduto;
    } 

    public void saidaProduto(int quantidadeProduto) {
        this.quantidadeProduto -= quantidadeProduto;
    }

    public void setquatiProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
}
