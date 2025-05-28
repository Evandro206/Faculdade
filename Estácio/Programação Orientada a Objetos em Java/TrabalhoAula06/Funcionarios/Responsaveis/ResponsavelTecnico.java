package TrabalhoAula06.Funcionarios.Responsaveis;

import TrabalhoAula06.Agendados.ProcedimentoCirurgico;
import TrabalhoAula06.Agendados.ProcedimentoEstetico;
import TrabalhoAula06.Funcionarios.Funcionario;
import TrabalhoAula06.Paciente;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


public class ResponsavelTecnico extends Responsaveis {
    public void LiberaProcedimentoCirurgico(ProcedimentoCirurgico proced) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a senha ");
        String senhav = sc.nextLine();
        boolean valido = senha == senhav;
        if (valido) {
            System.out.println("Procedimento Cirugico liberado com sucesso!");
            proced.liberacao();
        }
        else {
            System.out.println("CPF ou senha incorreto");
        }

    }
    public void LiberaProcedimentoEstetico(ProcedimentoEstetico proced) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a senha ");
        String senhav = sc.nextLine();
        boolean valido = senha == senhav;
        if (valido) {
            System.out.println("Procedimento Cirugico liberado com sucesso!");
            proced.liberacao();
        }
        else {
            System.out.println("CPF ou senha incorreto");
        }

    }


}