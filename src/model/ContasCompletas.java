package model;

public class ContasCompletas extends ContaInvestimento{
    public ContasCompletas(int numConta) {
        super(numConta);
    }

    @Override
    public String toString() {
        String stringSaldo = String.format("Saldo: R$ %.2f", getSaldo());
        String stringFatura = String.format("Fatura: R$ %.2f", getFatura());

        return "Nome: "+getNome()+"\n" + stringSaldo+"\nLimite Crédito Disponível: R$ "+getSaldoDisponivel()+"\n"+stringFatura ;

    }
}
