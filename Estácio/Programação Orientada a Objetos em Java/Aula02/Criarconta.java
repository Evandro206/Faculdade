package Aula02;

public class Criarconta {
    public static void main(String[] args) {
        Cliente anderson = new Cliente("Anderson", "123.456.789-10", "Programador");
        Cliente maria = new Cliente("Maria", "987.654.321-00", "Analista de Sistemas");
        Conta c1 = new Conta( 1234, 5678, anderson);
        Contapoupanca c2 = new Contapoupanca( 1234, 5679, maria); 

        
        c1.sacar(200);
        c1.deposita(1000);
        c1.transfere(500, c2);
        
        
        System.out.println("Saldo da conta 1: " + c1.getSaldo());
        System.out.println("Saldo da conta 2: " + c2.getSaldo());
        System.out.println("Total de contas: " + Conta.totalContas);
        System.out.println("Nome do titular da conta 1: " + c1.getTitular());
        System.out.println("Nome do titular da conta 2: " + c1.titular.getNome());
        System.out.println("CPF do titular da conta 1: " + c1.titular.getCpf());
        System.out.println("Profissão do titular da conta 1: " + c1.titular.getProfissao());
        c1.titular.setProfissao("Desenvolvedor");
        System.out.println("Profissão do titular da conta 1: " + c1.titular.getProfissao());
        
    }
}