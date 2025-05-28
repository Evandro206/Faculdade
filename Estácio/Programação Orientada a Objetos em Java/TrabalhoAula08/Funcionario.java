public abstract class Funcionario implements Payable {
    protected String primeiroNome, ultimoNome, pis;
    protected Double salario;

    public Funcionario(String primeiroNome, String ultimoNome, String pis) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.pis = pis;
        this.salario = 0.0;
    }

    public String toString(){
        return "Nome: " + primeiroNome + " " + ultimoNome +
                "\nPIS: " + pis +
                "\nSalario: " + salario;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public void calculaSalario() {}
}
