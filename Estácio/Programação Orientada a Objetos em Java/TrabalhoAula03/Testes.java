package TrabalhoAula03;

import java.util.ArrayList;

// Classe usada apenas para testes
public class Testes {
    public static ArrayList<Loja> lojasTeste;
    public static ArrayList<Cliente> clientesTeste;
    public static ArrayList<Item> itensTeste;

    public static ArrayList<Loja> LojasTeste(String[] args) {

        lojasTeste = new ArrayList<>();

        Loja loja1 = new Loja("Loja Teste 1", "04.252.011/0001-10", "Razão Social 1", "Endereço 1");
        Loja loja2 = new Loja("Loja Teste 2", "12.345.678/0001-95", "Razão Social 2", "Endereço 2");
        lojasTeste.add(loja1);
        lojasTeste.add(loja2);
        return lojasTeste;
    }

    public static ArrayList<Cliente> ClientesTeste(String[] args) {

        clientesTeste = new ArrayList<>();

        Cliente cliente1 = new Cliente("Cliente1", "01/01/2001", "111.111.111-11");
        cliente1.criarCarrinho();
        Cliente cliente2 = new Cliente("Cliente2", "02/02/2002", "06.990.590/0001-23");
        cliente2.criarCarrinho();
        clientesTeste.add(cliente1);
        clientesTeste.add(cliente2);
        return clientesTeste;
    }

    public static ArrayList<Item> ItensTeste(String[] args) {

        itensTeste = new ArrayList<>();

        Item item1 = new Item("Item1", 1, 10.00f);
        Item item2 = new Item("Item2", 2, 20.00f);
        itensTeste.add(item1);
        itensTeste.add(item2);
        return itensTeste;
    }
}