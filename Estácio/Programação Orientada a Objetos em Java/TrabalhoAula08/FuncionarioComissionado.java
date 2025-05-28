public class FuncionarioComissionado extends Funcionario{
    Double valorComissionado;
    int numVendas;
    public FuncionarioComissionado(String primeiroNome, String ultimoNome, String pis, Double valorComissionado, int numVendas) {
        super(primeiroNome, ultimoNome, pis);
        this.valorComissionado = valorComissionado;
        this.numVendas = numVendas;
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

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public Double getValorComissionado() {
        return valorComissionado;
    }

    public void setValorComissionado(Double valorComissionado) {
        this.valorComissionado = valorComissionado;
    }

    public void calculaSalario() {
        setSalario(valorComissionado * numVendas);
    }
}
