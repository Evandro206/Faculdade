package Aula02;

public class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    // construtor padrão
    public Funcionario() {

    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
