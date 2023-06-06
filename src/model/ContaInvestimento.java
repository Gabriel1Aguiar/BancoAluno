package model;

public class ContaInvestimento extends ContaPoupanca{

    boolean contaInvestimento = false;

    public ContaInvestimento(int numConta) {
        super(numConta);
    }

    public boolean isContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(boolean contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }

    public void virarContaInvestimento(){
        setContaInvestimento(true);
    }

    public void rendimentoInvestimento(double valorDeposito){
        if(isContaInvestimento()){
            Double acrescimo = valorDeposito * 0.10;
            setSaldo(getSaldo() + acrescimo);
        }else {
            System.out.println("Essa conta não é uma conta investimento.");
        }
    }
}
