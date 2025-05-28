package TrabalhoAula06;

import TrabalhoAula06.Agendados.Consulta;
import TrabalhoAula06.Agendados.ProcedimentoCirurgico;
import TrabalhoAula06.Agendados.ProcedimentoEstetico;
import TrabalhoAula06.Funcionarios.Anestesista;
import TrabalhoAula06.Funcionarios.Enfermeiro;
import TrabalhoAula06.Funcionarios.Funcionario;
import TrabalhoAula06.Funcionarios.Responsaveis.Medico;
import TrabalhoAula06.Funcionarios.Responsaveis.ResponsavelTecnico;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<ProcedimentoCirurgico> procedimentoCirurgicos = new ArrayList<>();
        ArrayList<ProcedimentoEstetico> procedimentoEsteticos = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        Medico m;
        Paciente p;
        Anestesista a;
        Scanner sc = new Scanner(System.in);
        ResponsavelTecnico tec;

        System.out.println("Cadastre o primeiro anestesista");
        funcionarios.add(new Anestesista());
        System.out.println("Cadastre o primeiro Enfermeiro");
        funcionarios.add(new Enfermeiro());
        System.out.println("Cadastre o primeiro Médico");
        funcionarios.add(new Medico());
        System.out.println("Cadastre o primeiro Responsavel Tecnico");
        funcionarios.add(new ResponsavelTecnico());
        System.out.println("Cadastre o primeiro Paciente");
        pacientes.add(new Paciente());

        int opcao = 0;
        while (opcao != 11){
            sc = new Scanner(System.in);
            System.out.println("Escolha uma opcao: ");
            System.out.println("Opcao 1: Cadastrar anestesista");
            System.out.println("Opcao 2: Cadastrar Enfermeiro");
            System.out.println("Opcao 3: Cadastrar Medico");
            System.out.println("Opcao 4: Cadastrar Responsavel Tecnico");
            System.out.println("Opcao 5: Cadastrar Paciente");
            System.out.println("Opcao 6: Agendar Procedimento de Cirurgico");
            System.out.println("Opcao 7: Agendar Procedimento de estetico");
            System.out.println("Opcao 8: Agendar consulta");
            System.out.println("Opcao 9: Liberar Procedimento de Cirurgico");
            System.out.println("Opcao 10: Liberar Procedimento de Estetica");
            System.out.println("Opcao 11: Encerrar o programa");
            opcao = sc.nextInt();
            switch(opcao){
                case 1:
                    funcionarios.add(new Anestesista());
                    break;
                case 2:
                    funcionarios.add(new Enfermeiro());
                    break;
                case 3:
                    funcionarios.add(new Medico());
                    break;
                case 4:
                    funcionarios.add(new ResponsavelTecnico());
                    break;
                case 5:
                    pacientes.add(new Paciente());
                    break;
                case 6:
                    m = ProcedimentoCirurgico.BuscaMedico(funcionarios);
                    if(m == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    p = ProcedimentoCirurgico.BuscaPaciente(pacientes);
                    if(p == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    a = ProcedimentoCirurgico.BuscaAnestesista(funcionarios);
                    if(a == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    procedimentoCirurgicos.add(new ProcedimentoCirurgico(m,a,p));
                    break;
                case 7:
                    m = ProcedimentoEstetico.BuscaMedico(funcionarios);
                    if(m == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    p = ProcedimentoEstetico.BuscaPaciente(pacientes);
                    if(p == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    a = ProcedimentoEstetico.BuscaAnestesista(funcionarios);
                    if(a == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    procedimentoEsteticos.add(new ProcedimentoEstetico(m,a,p));
                    break;
                case 8:
                    m = Consulta.BuscaMedico(funcionarios);
                    if(m == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    p = Consulta.BuscaPaciente(pacientes);
                    if(p == null){
                        System.out.println("Cpf fora da base de dados");
                        break;
                    }
                    consultas.add(new Consulta(m,p));
                case 9:
                    tec = Funcionario.BuscaTecnico(funcionarios);
                    if (tec == null){
                        sc = new Scanner(System.in);
                        System.out.println("Digite a senha ");
                        String senhav = sc.nextLine();
                        System.out.println("CPF ou senha incorreto");
                    }
                    else{
                        ProcedimentoCirurgico procedimentoliberado1 = ResponsavelTecnico.BuscaProcedimentoCirurgico(procedimentoCirurgicos);
                        tec.LiberaProcedimentoCirurgico(procedimentoliberado1);
                    }
                    break;
                case 10:
                    tec = Funcionario.BuscaTecnico(funcionarios);
                    if (tec == null){
                        sc = new Scanner(System.in);
                        System.out.println("Digite a senha ");
                        String senhav = sc.nextLine();
                        System.out.println("CPF ou senha incorreto");
                    }
                    else{
                        ProcedimentoEstetico procedimentoliberado2 = ResponsavelTecnico.BuscaProcedimentoEstetico(procedimentoEsteticos);
                        tec.LiberaProcedimentoEstetico(procedimentoliberado2);
                    }
                    break;
                case 11:
                    break;
            }
        }
    }
}