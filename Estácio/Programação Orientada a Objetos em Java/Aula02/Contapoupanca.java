package Aula02;

public class Contapoupanca extends Conta {
    public Contapoupanca(int agencia, int numero, Cliente titular) {
        super(agencia, numero, titular);
    }

    @Override
    public void deposita(double valor) {
        super.deposita(valor - 0.10); 
    }

    @Override
    public boolean sacar(double valor) {
        return super.sacar(valor + 0.10);
    }
}