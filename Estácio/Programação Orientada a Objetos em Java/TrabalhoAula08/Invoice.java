public class Invoice implements Payable {
    final Funcionario funcionario;
    private boolean pagamento = false, conformidade = true;
    private Double valorPago;

    public Invoice(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String toString(){
        return funcionario.toString() + "\nPagamento: " + pagamento + "\nConformidade: " + conformidade + "\nValorPago: " + valorPago;
    }

    public void calculaSalario() {
        valorPago = funcionario.getSalario();
        if (funcionario instanceof FuncionarioHorista){
            if (((FuncionarioHorista) funcionario).getHorasTrabalhadas() > 50){
                conformidade = false;
            }
        }
        System.out.println("valor do pagamento: " + valorPago);
        pagamento = true;
    }
}
