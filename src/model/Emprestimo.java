package model;

import java.util.ArrayList;

public class Emprestimo extends CartaoCredito{
    double valorEmprestimo;
    String dataPagamento;
    double taxaJuros;
    ArrayList<String> historicoEmprestimo = new ArrayList<>();

    public Emprestimo(int numConta) {
        super(numConta);
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public ArrayList<String> getHistoricoEmprestimo() {
        return historicoEmprestimo;
    }

    public void setHistoricoEmprestimo(ArrayList<String> historicoEmprestimo) {
        this.historicoEmprestimo = historicoEmprestimo;
    }

    public void simularEmprestimo(double valor){
        setTaxaJuros(1.1);
        if (valor >= 1000) {
            setTaxaJuros(1.3);
            int dividirPagamento = 4;
            double valorFinal = valor * getTaxaJuros();
            String valorFinalstr = String.format("%.2f", (valorFinal));
            String valorDividido = String.format("%.2f", (valorFinal/dividirPagamento));
            System.out.println(String.format("Simulação de empréstimo: \n-> Empréstimo: "+valor+" reais.\n-> Valor à pagar: "+valorFinalstr+" reais.\nPode dividir até em "+dividirPagamento+"x de "+valorDividido+" reais."));
        } else if (valor > 500) {
            setTaxaJuros(1.2);
            int dividirPagamento = 3;
            double valorFinal = valor * getTaxaJuros();
            String valorFinalstr = String.format("%.2f", (valorFinal));
            String valorDividido = String.format("%.2f", (valorFinal/dividirPagamento));
            System.out.println(String.format("Simulação de empréstimo: \n-> Empréstimo: "+valor+" reais.\n-> Valor à pagar: "+valorFinalstr+" reais.\nPode dividir até em "+dividirPagamento+"x de "+valorDividido+" reais."));
        }else {
            int dividirPagamento = 2;
            double valorFinal = valor * getTaxaJuros();
            String valorFinalstr = String.format("%.2f", (valorFinal));
            String valorDividido = String.format("%.2f", (valorFinal/dividirPagamento));
            System.out.println(String.format("Simulação de empréstimo: \n-> Empréstimo: "+valor+" reais.\n-> Valor à pagar: "+valorFinalstr+" reais.\nPode dividir até em "+dividirPagamento+"x de "+valorDividido+" reais."));
        }
    }

    public void solicitarEmprestimo(double valor){
        simularEmprestimo(valor);
        setFatura(getFatura()+ valor);
        System.out.println("Valor de "+valor+" reais adicionado à fatura.\nTotal da Fatura: "+getFatura()+" reais.");


    }

}
