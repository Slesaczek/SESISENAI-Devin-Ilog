package com.Ex03;

public class Produto implements Tributavel {

    private double valor;
    private double valorImposto;

    @Override
    public double calcularValorComImposto() {
        return this.valor + this.valorImposto;
    }
}
