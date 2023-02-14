package com.Ex01;

public class ContaCorrente extends Conta implements Operavel{

    private double saldo;

    @Override
    protected double obterSaldoAtual() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public double sacar(double valor) {
        saldo -= valor;
        return saldo;
    }


}
