package model;

public class ContaPoupanca extends  Emprestimo{
    boolean contaPoupanca = false;

    public boolean isContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(boolean contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public ContaPoupanca(int numConta) {
        super(numConta);
    }
    public void virarContaPoupanca(){
        setContaPoupanca(true);
    }

    public void rendimentoPoupanca(double valorDeposito){
        if (isContaPoupanca()){
            Double acrescimo = valorDeposito * 0.02;
            setSaldo(getSaldo() + acrescimo);
        }else {
            System.out.println("Essa conta não é uma conta poupança.");
        }

    }
}
