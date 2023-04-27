package model;

import java.util.ArrayList;

public class ContaCorrente extends Conta{
    ArrayList<String> extrato = new ArrayList<>();
    ArrayList<String> histTransacoes = new ArrayList<>();

    public ContaCorrente(int numConta) {
        super(numConta);
    }

    public ArrayList<String> getExtrato() {
        return extrato;
    }

    public ArrayList<String> getHistTransacoes() {
        return histTransacoes;
    }

    public void depositar(double valor){
        setSaldo(getSaldo() + valor);
        String stringExtrato = "Depósito de "+ valor + " reais.";
        extrato.add(stringExtrato);
    }

    public void sacar(double valor){
        if(this.saldo>=valor){
            setSaldo(getSaldo() - valor);
            String stringExtrato = "Saque de "+ valor + " reais.";
            extrato.add(stringExtrato);
        }else {
            System.out.println("Saldo insuficiente para o saque.");
        }
    }

    public void transfetir(ContaCorrente contaTransfere, double valor, ContaCorrente contaRecebe){
        if(this.saldo>=valor){
            contaTransfere.setSaldo(contaTransfere.getSaldo() - valor);
            contaRecebe.setSaldo(contaRecebe.getSaldo() + valor);
            String stringHist =" Transferência de "+ valor + " reais para "+contaRecebe.getNome();
            histTransacoes.add(stringHist);
        }else {
            System.out.println("Saldo insuficiente para a transferência.");
        }
    }

    public void pagarFaturaComContaCorrente(){
        if(getSaldo() >= getFatura()){
            setSaldo(getSaldo()- getFatura());
            setFatura(0);
            System.out.println("Pagamento da fatura efetuado pela conta corrente.");
        } else {
            System.out.println("Valor insuficiente para pagar a fatura");
        }
    }

}
