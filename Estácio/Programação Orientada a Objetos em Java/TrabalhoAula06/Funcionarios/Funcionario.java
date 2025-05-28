package TrabalhoAula06.Funcionarios;

import TrabalhoAula06.Funcionarios.Responsaveis.ResponsavelTecnico;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public abstract class Funcionario {

    // Atributos
    public String nomeFuncionario;
    public String cpf;
    public float salario;

    // ID Funcionário
    public int idFuncionario = 0;

    // Metodo criador
    public  Funcionario() {
        Scanner scanner = new Scanner(System.in);
        idFuncionario++;
        System.out.println("Digite o nome do funcionário");
        this.nomeFuncionario = scanner.nextLine();
        System.out.println("Digite o CPF ou CNPJ do funcionário:");
        this.cpf = scanner.nextLine();
        System.out.println("Digite o salário do funcionário:");
        this.salario = scanner.nextFloat();
    }

    // Metodo para exibir Funcionário
    public void exibirFuncionario() {
        System.out.println("Nome: " + this.nomeFuncionario);
        System.out.println("ID: " + idFuncionario);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Salário: " + this.salario);
    }

    public static ResponsavelTecnico BuscaTecnico(ArrayList<Funcionario> arrayList) {
        System.out.println("Digite o cpf: ");
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.nextLine();
        Optional<Funcionario> resp= arrayList.stream().filter(f -> f.cpf.equals(cpf)).findFirst();
        return resp.isPresent() ? (ResponsavelTecnico) resp.get() : null;
    }

}