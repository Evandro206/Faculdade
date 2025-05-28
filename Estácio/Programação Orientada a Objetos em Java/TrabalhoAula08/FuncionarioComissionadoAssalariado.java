public class FuncionarioComissionadoAssalariado extends FuncionarioComissionado {
    public FuncionarioComissionadoAssalariado(String primeiroNome, String ultimoNome, String pis, Double salario, Double valorComissionado, int numVendas) {
        super(primeiroNome, ultimoNome, pis, valorComissionado, numVendas);
        this.salario = salario;
        calculaSalario();
    }

    @Override
    public String toString(){
        return "Nome: " + primeiroNome + " " + ultimoNome +
                "\nPIS: " + pis +
                "\nSalario: " + salario +
                "\nValor comissionado: " + valorComissionado +
                "\nVendas: " + numVendas;
    }

    public void calculaSalario() {
        setSalario(salario += valorComissionado * numVendas);
    }
}
