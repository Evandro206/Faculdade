package Aula02;

public class Testacliente {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Fulano", "123.456.789-00", "Programador");
        Cliente c2 = new Cliente("Ciclano", "987.654.321-00", "Analista de Sistemas");

        System.out.println("Nome do cliente 1: " + c1.getNome());
        System.out.println("CPF do cliente 1: " + c1.getCpf());
        System.out.println("Profissão do cliente 1: " + c1.getProfissao());
        System.out.println("Nome do cliente 2: " + c2.getNome());
        System.out.println("CPF do cliente 2: " + c2.getCpf());
        System.out.println("Profissão do cliente 2: " + c2.getProfissao());
        c1.setProfissao("Desenvolvedor");
        System.out.println("Profissão do cliente 1: " + c1.getProfissao());
    }
}
