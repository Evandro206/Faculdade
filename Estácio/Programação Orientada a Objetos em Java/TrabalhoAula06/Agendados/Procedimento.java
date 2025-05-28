package TrabalhoAula06.Agendados;

import TrabalhoAula06.Funcionarios.Anestesista;
import TrabalhoAula06.Funcionarios.Funcionario;
import TrabalhoAula06.Funcionarios.Responsaveis.Medico;
import TrabalhoAula06.Funcionarios.Responsaveis.Responsaveis;
import TrabalhoAula06.Funcionarios.Responsaveis.ResponsavelTecnico;
import TrabalhoAula06.Paciente;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

abstract class Procedimento {
    public Medico medico;
    public Anestesista anestesista;
    public Paciente paciente;
    private boolean liberado;
    public int idprocedimento = 0;


    public Procedimento(Medico m, Anestesista a, Paciente p) {
        medico = m;
        anestesista = a;
        paciente = p;
        liberado = false;
        System.out.println(idprocedimento);
        idprocedimento++;
    }

    public static Medico BuscaMedico(ArrayList<Funcionario> arrayList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do médico: ");
        String cpf = sc.nextLine();
        Optional<Funcionario> medicoproced= arrayList.stream().filter(f -> f.cpf.equals(cpf)).findFirst();
        return medicoproced.isPresent() ? (Medico) medicoproced.get() : null;
    }

    public static Anestesista BuscaAnestesista(ArrayList<Funcionario> arrayList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do anestesista: ");
        String cpf = sc.nextLine();
        Optional<Funcionario> anestesistaproced= arrayList.stream().filter(f -> f.cpf.equals(cpf)).findFirst();
        return anestesistaproced.isPresent() ? (Anestesista) anestesistaproced.get() : null;
    }

    public static Paciente BuscaPaciente(ArrayList<Paciente> arrayList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do paciente: ");
        String cpf = sc.nextLine();
        Optional<Paciente> pacienteproced= arrayList.stream().filter(f -> f.cpf.equals(cpf)).findFirst();
        return pacienteproced.isPresent() ? pacienteproced.get() : null;
    }

    public void liberacao(){
        liberado = true;
    }

    public void exibeprocedimento(){

        System.out.println("O médico que irá realiza o exame é o:" + medico.nomeFuncionario);
        System.out.println("O anestesista que irá fazer a sedação é o" + anestesista.nomeFuncionario);
        System.out.println("O Paciente é o " + paciente.nome);
        String resposta = liberado ? "O procedimento se encontra liberado" : "O procedimento não foi liberado ainda";
        System.out.println(resposta);
    }
}


