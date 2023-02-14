package com.exercicios.Ex01;

public class Ex01 {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();

        funcionario.nomeCompleto = "César Augusto";
        funcionario.cpf = "11111111111";
        funcionario.salario = 1000.00f;

        funcionario.promover(10);

        System.out.println("Novo salário:"+funcionario.salario);
    }
}
