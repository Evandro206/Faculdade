package Aula02;

public class Conta {

    // Atributos
    private int agencia;
    private int numero;
    private double saldo;
    public Cliente titular;

    // Atributo de classe
    public static int totalContas;

    public Conta(int agencia, int numero, Cliente titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = 100;
        Conta.totalContas++;
    }

    public void deposita(double valor) {
        this.saldo += valor;
        System.out.println("Depositado: " + valor + " na conta do titular: " + titular.getNome());
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Sacado: " + valor + " da conta do titular: " + titular.getNome());
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque");
            return false;
        }
    } 

    public boolean transfere(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.deposita(valor);
            System.out.println("Transferido: " + valor + " da conta do titular: " + titular.getNome() + " para a conta do titular: " + destino.titular.getNome());
            return true;
        } else {
            System.out.println("Saldo insuficiente para transferência");
            return false;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getTitular() {
        return titular.getNome();
    }
}