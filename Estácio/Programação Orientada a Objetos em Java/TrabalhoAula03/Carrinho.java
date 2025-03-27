package TrabalhoAula03;

import java.util.ArrayList;

public class Carrinho {
    // Atributos
    public ArrayList<Informacao> itensCarrinho = new ArrayList<>();
    public int quantidadeItens = 0;
    public float valorTotal = 0;
    int indice = -1;

    // Método para exibir o carrinho
    public void exibirCarrinho() {
        System.out.println("====== Carrinho ======");
        for (Informacao info : itensCarrinho) {
            info.item.exibirItem();
            System.out.println("Quantidade: " + info.quantidade);
        }
        System.out.println("Quantidade de itens: " + quantidadeItens);
        System.out.println("Valor total: " + valorTotal);
    }

    // Método para adicionar um item ao carrinho
    public void adicionarItem(Item item, int quantidade) {
        this.itensCarrinho.add(new Informacao(item, quantidade));
        valorTotal += (item.getPrecoItem() * quantidade);
        quantidadeItens += quantidade;
    }

    // Método para remover um item do carrinho
    public void removerItem(Item item, int quantidade) {
        for (Informacao info : itensCarrinho) {
            if (info.item == item) {
                indice = itensCarrinho.indexOf(info);
                break;
            }
        }
        if (indice != -1) {
            if (itensCarrinho.get(indice).quantidade > quantidade) {
                itensCarrinho.get(indice).quantidade -= quantidade;
                valorTotal -= (item.getPrecoItem() * quantidade);
            } else {
                valorTotal -= (item.getPrecoItem() * itensCarrinho.get(indice).quantidade);
                itensCarrinho.remove(indice);
            }
        }
        quantidadeItens -= quantidade;
    }

    // Método para limpar o carrinho
    public void limparCarrinho() {
        this.itensCarrinho.clear();
        this.quantidadeItens = 0;
        this.valorTotal = 0;
    }

    // Método get para itensCarrinho
    public ArrayList<Informacao> getItensCarrinho() {
        return itensCarrinho;
    }

    // Método get para valorTotal
    public float getValorTotal() {
        return valorTotal;
    }

    // Método para saber se carrinho esta vazio
    public boolean estaVazio() {
        return itensCarrinho.isEmpty();
    }
}