
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static ArrayList<Invoice> pagamentos = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;
        while(continuar) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Bem vindo ao programa da folha de pagamento!");
            System.out.println("O que deseja fazer?\n" +
                    "1 - Criar funcionário\n" +
                    "2 - Gerar folha de pagamento");
            switch (sc.nextInt()) {
                case 1:
                    funcionarios.add(criarFuncionario());
                    System.out.println("Fucionario criado com sucesso!\n");
                    break;
                    case 2:
                        for (Funcionario funcionario : funcionarios) {
                            if (funcionario instanceof FuncionarioComissionadoAssalariado) {funcionario.setSalario(funcionario.getSalario() * 1.1);}
                            pagamentos.add(new Invoice(funcionario));
                            pagamentos.getLast().calculaSalario();
                            System.out.println(pagamentos.getLast().toString() + "\n");
                        }
                        continuar = false;
                        break;
                        default:
                            break;

            }
        }
    }

    private static Funcionario criarFuncionario(){
        String[] funcionarioInfo;
        double salario;
        double valorComissionado;
        int numVendas;
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual tipo de fucionario deseja criar:\n" +
                "1 - Fucionário Assalariado\n" +
                "2 - Funcionário Horista\n" +
                "3 - Funcionário Comissionado\n" +
                "4 - Funcionário Comissiona/Assalariado");
        switch(sc.nextInt()) {
            case 1:
                funcionarioInfo = criarFuncionarioPadrao();
                verificaPIS(funcionarioInfo[2]);
                System.out.println("Digite o salario: ");
                salario = sc.nextDouble();
                return new FuncionarioAssalariado(funcionarioInfo[0], funcionarioInfo[1], funcionarioInfo[2], salario);
                case 2:
                    funcionarioInfo = criarFuncionarioPadrao();
                    verificaPIS(funcionarioInfo[2]);
                    System.out.println("Digite o valor da hora: ");
                    Double valorHora = sc.nextDouble();
                    System.out.println("Digite o numero de horas: ");
                    Double numHoras = sc.nextDouble();
                    return new FuncionarioHorista(funcionarioInfo[0], funcionarioInfo[1], funcionarioInfo[2], valorHora, numHoras);
                    case 3:
                        funcionarioInfo = criarFuncionarioPadrao();
                        verificaPIS(funcionarioInfo[2]);
                        System.out.println("Digite o valor da comissão: ");
                        valorComissionado = sc.nextDouble();
                        System.out.println("Digite o numero de vendas: ");
                        numVendas = sc.nextInt();
                        return new FuncionarioComissionado(funcionarioInfo[0], funcionarioInfo[1], funcionarioInfo[2], valorComissionado, numVendas);
                        case 4:
                            funcionarioInfo = criarFuncionarioPadrao();
                            verificaPIS(funcionarioInfo[2]);
                            System.out.println("Digite o salario: ");
                            salario = sc.nextDouble();
                            System.out.println("Digite o valor da comissão: ");
                            valorComissionado = sc.nextDouble();
                            System.out.println("Digite o numero de vendas: ");
                            numVendas = sc.nextInt();
                            return new FuncionarioComissionadoAssalariado(funcionarioInfo[0], funcionarioInfo[1], funcionarioInfo[2], salario, valorComissionado, numVendas);
        }
        return null;
    }

    private static String[] criarFuncionarioPadrao(){
        Scanner sc = new Scanner(System.in);
        String[] funcionarioInfo = new String[3];
        System.out.println("Digite o primeiro nome: ");
        funcionarioInfo[0] = sc.nextLine();
        System.out.println("Digite o ultimo nome: ");
        funcionarioInfo[1] = sc.nextLine();
        System.out.println("Digite o pis: ");
        funcionarioInfo[2] = sc.nextLine();
        return funcionarioInfo;
    }

    private static void verificaPIS(String pis){
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getPis().equals(pis)){
                System.out.println("PIS ivalido!");
                criarFuncionario();
            }
        }
    }
}