package TrabalhoAula03;

import java.util.Scanner;

public class Transacoes {
    
    // Atributos
    private float valorPago;
    private float troco;
    private static float valorTotal;
    private String metodoPagamento;

    private static final Scanner scanner = new Scanner(System.in);

    // Método para gerenciar transação
    public Transacoes(float valorTotalrecebido) {
        valorTotal = valorTotalrecebido;
        float desconto = 0.95f;
 
        System.out.print("Digite o método de pagamento: ");
        this.metodoPagamento = scanner.nextLine().trim().toUpperCase();
        switch (metodoPagamento) {
            case "PIX":
                valorTotal = valorTotal * desconto;
                break;
            case "DINHEIRO":
                valorTotal = valorTotal * desconto;
                break;
            default:
                break;
        }

        System.out.print("Digite o valor pago: ");
        try {
            this.valorPago = Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor informado inválido. Configurando valor pago como 0.");
            this.valorPago = 0;
        }
        this.troco = this.valorPago - valorTotal;
        if (this.troco < 0) {
            System.out.println("Pagamento insuficiente! Falta: " + Math.abs(this.troco));
        } else {
            System.out.println("Pagamento realizado com sucesso.");
        }
    }

    // Método get para valor pago
    public float getValorPago() {
        return valorPago;
    }

    // Método get para troco
    public float getTroco() {
        return troco;
    }

    // Método get para valor da compra
    public float getValorTotal() {
        return valorTotal;
    }

    // Método get para forma de pagamento
    public String getMetodoPagamento() {
        return metodoPagamento;
    }
}