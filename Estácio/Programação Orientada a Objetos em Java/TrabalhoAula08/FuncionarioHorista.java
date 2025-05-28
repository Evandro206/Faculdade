public class FuncionarioHorista extends Funcionario {
    Double horasTrabalhadas, valorHoras;
    FuncionarioHorista(String primeiroNome, String ultimoNome, String pis, Double valorHoras, Double horasTrabalhadas) {
        super(primeiroNome, ultimoNome, pis);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHoras = valorHoras;
    }

    @Override
    public String toString(){
        return "Nome: " + primeiroNome + " " + ultimoNome +
                "\nPIS: " + pis +
                "\nSalario: " + salario +
                "\nValor Horas: " + valorHoras +
                "\nHoras: " + horasTrabalhadas;
    }

    public Double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Double getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(Double valorHoras) {
        this.valorHoras = valorHoras;
    }

    public void calculaSalario() {
        if (horasTrabalhadas <= 40) {
            setSalario(horasTrabalhadas * valorHoras);
        } else if (horasTrabalhadas > 40) {
            double horasExtras = (horasTrabalhadas - 40) * (valorHoras * 1.5);
            System.out.println("Horas Extras: " + horasExtras);
            setSalario((40 * valorHoras) + horasExtras);
        }
    }
}
