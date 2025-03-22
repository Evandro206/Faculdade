package TrabalhoAula03;

public class Cliente {
    
    // Atributos
	private String nomeCliente;
	private String dataCadastroCliente;
	private String cpfCnpjCliente;

    // Contador de clientes
    public static int codigoCliente = 1;
    
    // Método criador
    public Cliente(String nomeCliente, String dataCadastroCliente, String cpfCnpjCliente) {
        this.nomeCliente = nomeCliente;
        this.dataCadastroCliente = dataCadastroCliente;
        this.cpfCnpjCliente = cpfCnpjCliente;
        codigoCliente++;
    }

    // Método para exibir informações sobre o cliente
    public void exibirCliente(){
        System.out.println("------ Informações Cliente ------");
        System.out.println("Nome: " + nomeCliente);
        System.out.println("CPF/CNPJ: " + cpfCnpjCliente);
        System.out.println("Código: " + codigoCliente);
        System.out.println("Data do Cadastro: " + dataCadastroCliente);
    }

    // Método para o cliente realizar uma consulta de um item
    public void consultaItem(Item itemVerificado){
        itemVerificado.exibirItem();
    }
}
