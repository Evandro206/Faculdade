package TrabalhoAula03;

public class Informacao {
    Item item;
    int quantidade;

    // Método que armazena um objeto da classse Item e relaciona com uma quantidade para aquele item
    public Informacao(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }
}