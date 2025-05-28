package TrabalhoAula06.Agendados;


import TrabalhoAula06.Funcionarios.Anestesista;
import TrabalhoAula06.Funcionarios.Responsaveis.Medico;
import TrabalhoAula06.Paciente;

public class ProcedimentoCirurgico extends Procedimento{
    public ProcedimentoCirurgico(Medico m, Anestesista a, Paciente p) {
        super(m, a, p);
    }
}