package model;

import java.util.ArrayList;

public class CartaoCredito extends ContaCorrente{
    double limiteCredito;
    double saldoDisponivel;

    String dataVencimento;
    ArrayList<String> historicoCompras = new ArrayList<>();

    public CartaoCredito(int numConta) {
        super(numConta);
        this.limiteCredito = 0;
        this.saldoDisponivel = 0;
        this.fatura = 0;
        this.dataVencimento = "0";
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public ArrayList<String> getHistoricoCompras() {
        return historicoCompras;
    }

    public void definirLimite(double salario){
        this.limiteCredito = (salario/2)+200;
        setSaldoDisponivel(this.limiteCredito);
    }

    public void compraCredito(double valor){
        if(this.saldoDisponivel >= valor){
            saldoDisponivel -= valor;
            this.fatura += valor;
            String stringHistCompras = "Compra de "+valor+" reais.";
            historicoCompras.add(stringHistCompras);
            System.out.println("Compra efetuada com sucesso.");
        }else{
            System.out.println("Saldo insuficiente para a compra.");
        }
    }

    public void Pagamento(double valor){
        if(valor == this.fatura){
                this.fatura = 0;
                setSaldoDisponivel(getLimiteCredito());
                System.out.println("Pagamento da fatura efetuado com sucesso");

            } else {
                System.out.println("Valor insuficiente para pagar a fatura");

            }
    }

    public String toString(){
        return "Nome: "+ getNome() +
                "\nCrédito disponível: "+ getSaldoDisponivel() +
                "\nFatura: "+ getFatura();
    }

}
