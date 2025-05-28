package TrabalhoAula06.Agendados;

import TrabalhoAula06.Funcionarios.Anestesista;
import TrabalhoAula06.Funcionarios.Responsaveis.Medico;
import TrabalhoAula06.Funcionarios.Responsaveis.Responsaveis;
import TrabalhoAula06.Funcionarios.Responsaveis.ResponsavelTecnico;
import TrabalhoAula06.Paciente;

public class ProcedimentoEstetico extends Procedimento {
    public ProcedimentoEstetico(Medico m, Anestesista a, Paciente p) {
        super(m, a, p);
    }
}
