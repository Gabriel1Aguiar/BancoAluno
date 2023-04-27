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
}
