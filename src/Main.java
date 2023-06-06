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
                    System.out.println("Deseja que sua conta seja Conta Poupança ou uma Conta de Investimentos? ");
                    System.out.println("[1] Sim");
                    System.out.println("[2] Não");
                    int respostaInicial = input.nextInt();
                    if (respostaInicial == 1){
                        System.out.println("\nTipo de Conta:");
                        System.out.println("[1] Conta Poupança");
                        System.out.println("[2] Conta Investimento");
                        System.out.println("[0] Sair");
                        int tipoDeConta = input.nextInt();
                        if (tipoDeConta == 1){
                            c1.virarContaPoupanca();
                        } else if (tipoDeConta == 2) {
                            c1.virarContaInvestimento();
                        }
                    }
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
                                menu.menuOperacoes();
                                int respostaOperacao = input.nextInt();
                                while(respostaOperacao != 0){
                                    switch (respostaOperacao){
                                        case 1:
                                            System.out.println("Qual o valor do depósito:");
                                            double valorDeposito = input.nextDouble();
                                            contas.get(i).depositar(valorDeposito);
                                            if(contas.get(i).isContaPoupanca()){
                                                contas.get(i).rendimentoPoupanca(valorDeposito);
                                            } else if (contas.get(i).isContaInvestimento()) {
                                                contas.get(i).rendimentoInvestimento(valorDeposito);
                                            }
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
                                            System.out.println("[3] VIRAR CONTA POUPANÇA");
                                            System.out.println("[4] VIRAR CONTA INVESTIMENTO");
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
                                                case 3:
                                                    if(!contas.get(i).isContaPoupanca()){
                                                        System.out.println("Deseja que sua conta vire uma conta poupança? ");
                                                        System.out.println("[1] Sim");
                                                        System.out.println("[2] Não");
                                                        int repostaMudarConta1 = input.nextInt();
                                                        if(repostaMudarConta1 == 1){
                                                            contas.get(i).virarContaPoupanca();
                                                            System.out.println("Parabéns, sua conta agora é uma Conta Poupança");
                                                        }
                                                    }else {
                                                        System.out.println("Sua conta já é uma Conta Poupança.");
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Deseja que sua conta vire uma conta Investimento? ");
                                                    System.out.println("[1] Sim");
                                                    System.out.println("[2] Não");
                                                    int respostaMudarConta2 = input.nextInt();
                                                    if (respostaMudarConta2 == 1){
                                                        contas.get(i).virarContaInvestimento();
                                                    }
                                            }
                                            break;
                                        case 7:
                                            System.out.println("Seu saldo é: "+ contas.get(i).getSaldo());
                                        case 0:
                                            break;
                                    }
                                    menu.menuOperacoes();
                                    respostaOperacao = input.nextInt();
                                }
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
                                                break;
                                        }
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
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


    }
}