package TrabalhoAula06.Agendados;

import TrabalhoAula06.Funcionarios.Anestesista;
import TrabalhoAula06.Funcionarios.Funcionario;
import TrabalhoAula06.Funcionarios.Responsaveis.Medico;
import TrabalhoAula06.Paciente;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Consulta {
    public Medico medico;
    public Anestesista anestesista;
    public Paciente paciente;
    private boolean liberado;

    public Consulta(Medico m, Paciente p) {

        medico = m;
        paciente = p;
    }

    public static Medico BuscaMedico(ArrayList<Funcionario> arrayList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do médico: ");
        String cpf = sc.nextLine();
        Optional<Funcionario> medicoproced= arrayList.stream().filter(f -> f.cpf.equals(cpf)).findFirst();
        return medicoproced.isPresent() ? (Medico) medicoproced.get() : null;
    }

    public static Paciente BuscaPaciente(ArrayList<Paciente> arrayList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do paciente: ");
        String cpf = sc.nextLine();
        Optional<Paciente> pacienteproced= arrayList.stream().filter(f -> f.cpf.equals(cpf)).findFirst();
        return pacienteproced.isPresent() ? pacienteproced.get() : null;
    }

    public void exibeprocedimento(){

        System.out.println("O médico que irá realizar a consulta é o:" + medico.nomeFuncionario);
        System.out.println("O Paciente é o " + paciente.nome);
    }
}


