package TrabalhoAula06;

import java.util.Scanner;

public class Paciente {
    public String nome;
    public String cpf;
    public String sexo;


    public Paciente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        this.nome = sc.nextLine();
        System.out.println("Digite o cpf: ");
        this.cpf  = sc.nextLine();
        System.out.println("Digite o sexo: ");
        this.sexo = sc.nextLine();
    }
}
