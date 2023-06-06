package model;

import java.util.ArrayList;

public class Conta {
    private String nome;
    private int numConta;
    private double saldo;
    private double fatura;

    public Conta(int numConta) {
        this.numConta = numConta;
        this.saldo = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getFatura() {
        return fatura;
    }

    public void setFatura(double fatura) {
        this.fatura = fatura;
    }

    public String toString(){
        String stringSaldo = String.format("Saldo: R$ %.2f", getSaldo());

        return "Nome: "+ getNome() +
                "\n"+ stringSaldo +
                "\nFatura: R$"+getFatura();

    }


}
