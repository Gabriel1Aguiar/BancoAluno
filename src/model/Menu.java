package model;

public class Menu {
    public String menuInicial(){
        return "\n-------------------------------------\n             " +
                "BancoAluno\n" +
                "-------------------------------------\n" +
                "[1] Criar uma Conta\n" +
                "[2] Acessar sua conta\n" +
                "[0] Sair\n" +
                "-------------------------------------";
    }

    public void menuCriarConta(int opcao){
        if (opcao == 1){
            System.out.println("\n-------------------------------------\n" +
                    "CRIAÇÃO DE CONTA CORRENTE\n" +
                    "-------------------------------------\n" +
                    "Digite seu Nome:");
        } else if (opcao == 2) {
            System.out.println("\n-------------------------------------\n" +
                    "CRIAÇÃO CARTÃO DE CRÉDITO\n" +
                    "-------------------------------------\n" +
                    "Digite seu Nome:");
        }
    }

    public void menuAcesso(int opcao){
        if (opcao == 1){
            System.out.println("\n-------------------------------------\n" +
                    "CONTA \n" +
                    "-------------------------------------\n" +
                    "Informe seu ID:");
        } else if (opcao == 2) {
            System.out.println("\n-------------------------------------\n" +
                    "CARTÃO DE CRÉDITO\n" +
                    "-------------------------------------\n" +
                    "Informe seu ID:");
        }
    }

    public void menuOperacoes(){
        System.out.println("\n-------------------------------------\n" +
                "MENU DE OPERAÇÕES\n" +
                "-------------------------------------\n");
        System.out.println("[1] DEPOSITO");
        System.out.println("[2] SAQUE");
        System.out.println("[3] EXTRATO");
        System.out.println("[4] TRANSFERÊNCIA");
        System.out.println("[5] EMPRESTIMO");
        System.out.println("[6] ALTERAÇÕES NA CONTA");
        System.out.println("[7] CONSULTAR SALDO");
        System.out.println("[0] SAIR");
    }
}
