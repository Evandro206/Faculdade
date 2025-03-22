package Aula02;

public class Testafuncionario {
    public static void main(String[] args) {
        Funcionario anderson = new Funcionario();
        System.out.println(anderson.getNome());
        System.out.println(anderson.getCpf());
        System.out.println(anderson.getSalario());
        anderson.setNome("Anderson");
        anderson.setCpf("123.456.789-10");
        anderson.setSalario(1000.0);
        System.out.println(anderson.getNome());
        System.out.println(anderson.getCpf());
        System.out.println(anderson.getSalario());
    }
}
