package com.exercicios.Ex02;

public class Funcionario {

    String nome;
    float  salario;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Funcionario(String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentar(float valor){
        this.salario += valor;
    }

    public void aumentar(float valor, float comissao){
        this.salario += valor + comissao;
    }
}
