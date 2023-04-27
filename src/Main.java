import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();

        ArrayList<ContasCompletas> contas= new ArrayList<ContasCompletas>();

        boolean respostaGlobal = true;
        int id = 1;

        while (respostaGlobal == true){
            System.out.println(menu.menuInicial());
            int resposta = input.nextInt();
            switch (resposta){
                case 1:
                    menu.menuCriarConta(1);
                    String nome = input.next();
                    System.out.println("Qual seu salário: ");
                    double salario = input.nextDouble();
                    ContasCompletas c1 = new ContasCompletas(id);
                    c1.setNome(nome);
                    c1.definirLimite(salario);
                    System.out.println("Sua conta foi criada e seu ID foi definido como: "+id+", esse é o código que você utilizará para acessar a conta.");
                    id++;
                    contas.add(c1);
                    break;
                case 2:
                    System.out.println("\n-------------------------------------\n" +
                                        "ACESSO DE CONTA\n" +
                                        "-------------------------------------\n");
                    System.out.println("[1] CONTA");
                    System.out.println("[2] CARTÃO DE CRÉDITO");
                    int respostaAcesso = input.nextInt();
                    if(respostaAcesso == 1){
                        menu.menuAcesso(1);
                        int respostaID = input.nextInt();
                        System.out.println("\n");
                        for(int i = 0; i <contas.size();i++){
                            if(respostaID == contas.get(i).getNumConta()){
                                System.out.println(contas.get(i).toString());
                                System.out.println("\n");
                                System.out.println("Bem vindo "+contas.get(i).getNome()+"\nQual operação deseja fazer:");
                                System.out.println("[1] DEPOSITO");
                                System.out.println("[2] SAQUE");
                                System.out.println("[3] EXTRATO");
                                System.out.println("[4] TRANSFERÊNCIA");
                                System.out.println("[5] EMPRESTIMO");
                                System.out.println("[6] ALTERAÇÕES NA CONTA");
                                System.out.println("[0] SAIR");
                                int repostaOperacao = input.nextInt();
                                System.out.println("\n");
                                switch (repostaOperacao){
                                    case 1:
                                        System.out.println("Qual o valor do depósito:");
                                        double valorDeposito = input.nextDouble();
                                        contas.get(i).depositar(valorDeposito);
                                        break;
                                    case 2:
                                        System.out.println(contas.get(i).toString());
                                        System.out.println("Qual o valor do saque:");
                                        double valorSaque = input.nextDouble();
                                        contas.get(i).sacar(valorSaque);
                                        break;
                                    case 3:
                                        System.out.println(contas.get(i).getExtrato());
                                        break;
                                    case 4:
                                        System.out.println("Qual ID da conta que vai receber a transferência: ");
                                        int idRecebe = input.nextInt();
                                        for(int z = 0; z <contas.size();z++){
                                            if (idRecebe == contas.get(z).getNumConta()){
                                                ContasCompletas contaRecebe = contas.get(z);
                                                System.out.println("Qual valor para transferir: ");
                                                double valorTransf = input.nextDouble();
                                                contas.get(i).transfetir(contas.get(i),valorTransf,contaRecebe);
                                            }
                                        }
                                        break;
                                    case 5:
                                        System.out.println("EMPRESTIMO");
                                        System.out.println("[1] SIMULAR EMPRESTIMO");
                                        System.out.println("[2] SOLICITAR EMPRESTIMO");
                                        int respostaEmprestimo = input.nextInt();
                                        switch (respostaEmprestimo) {
                                            case 1:
                                                System.out.println("Qual o valor do emprestimo: ");
                                                double valorSimularEmprestimo = input.nextDouble();
                                                contas.get(i).simularEmprestimo(valorSimularEmprestimo);
                                                break;
                                            case 2:
                                                System.out.println("Qual o valor do emprestimo: ");
                                                double valorEmprestimo = input.nextDouble();
                                                contas.get(i).solicitarEmprestimo(valorEmprestimo);
                                                break;
                                        }
                                        break;
                                    case 6:
                                        System.out.println("Alterações na conta: ");
                                        System.out.println("[1] NOME");
                                        System.out.println("[2] SALÁRIO");
                                        int respostaAlteracao = input.nextInt();
                                        switch (respostaAlteracao){
                                            case 1:
                                                System.out.println("Informe o novo nome: ");
                                                String novoNome = input.next();
                                                contas.get(i).setNome(novoNome);
                                                break;
                                            case 2:
                                                System.out.println("Informe seu novo salário");
                                                double novoSalario = input.nextDouble();
                                                contas.get(i).definirLimite(novoSalario);
                                                System.out.println("Seu limite foi redefinido para R$"+contas.get(i).getLimiteCredito());
                                                break;
                                        }
                                        break;
                                    case 0:
                                        break;
                                }
                            }else {
                                System.out.println("Conta inexistente.");
                            }
                        }


                    } else if (respostaAcesso == 2) {
                        menu.menuAcesso(2);
                        int respostaIDb = input.nextInt();
                        for(int i = 0; i <contas.size();i++){
                            if(respostaIDb == contas.get(i).getNumConta()){
                                System.out.println(contas.get(i).toString());
                                System.out.println("Qual operação você deseja fazer:");
                                System.out.println("[1] Compra Crédito");
                                System.out.println("[2] Pagar cartão");
                                int respostaOp = input.nextInt();
                                switch (respostaOp){
                                    case 1:
                                        System.out.println("\nQual o valor da compra: ");
                                        double valorCredito = input.nextDouble();
                                        contas.get(i).compraCredito(valorCredito);
                                        break;
                                    case 2:
                                        System.out.println("\nMétodo de pagamento: ");
                                        System.out.println("[1] Conta Corrente");
                                        System.out.println("[2] Dinheiro");
                                        int respostaPagamento = input.nextInt();
                                        switch (respostaPagamento){
                                            case 1:
                                                contas.get(i).pagarFaturaComContaCorrente();
                                                break;
                                            case 2:
                                                System.out.println("\nValor total da fatura: R$ "+ contas.get(i).getFatura());
                                                System.out.println("Valor do pagamento em dinheiro: ");
                                                double pagamentoDinheiro = input.nextDouble();
                                                contas.get(i).Pagamento(pagamentoDinheiro);
                                                break;
                                            default:
                                                System.out.println("Opção inválida");
                                        }
                                    default:
                                        System.out.println("Opção inválida");
                                }
                            }else {
                                System.out.println("Conta inexistente.");
                            }
                        }
                    }else{
                        System.out.println("Opção inválida");
                    }
                    break;
                case 0:
                    System.out.println("Saiu do sistema");
                    respostaGlobal=false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

        for (ContasCompletas i:contas){
            System.out.println(i);
        }


    }
}