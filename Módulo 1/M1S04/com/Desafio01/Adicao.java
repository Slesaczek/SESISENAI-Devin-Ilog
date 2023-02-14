package com.Desafio01;

public class Adicao implements Operacao {

    @Override
    public Double calcular(Double valor1, Double valor2) {
        return valor1+valor2;
    }

    @Override
    public String getDescricao() {
        return "Adição";
    }
}
