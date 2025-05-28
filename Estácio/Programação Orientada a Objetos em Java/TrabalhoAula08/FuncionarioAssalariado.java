public class FuncionarioAssalariado extends Funcionario {
    public FuncionarioAssalariado(String primeiroNome, String ultimoNome, String pis, Double salario) {
        super(primeiroNome, ultimoNome, pis);
        this.salario = salario;
    }
}
