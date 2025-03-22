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
}
