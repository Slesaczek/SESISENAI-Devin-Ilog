package com.Desafio01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try{

            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a operação que deseja realizar: ");
            System.out.println("A - adição / S - subtração / M - multiplicação / D - divisão");
            String opcao = scanner.next();
            System.out.println("Digite o valor 1: ");
            double valor1 = scanner.nextDouble();
            System.out.println("Digite o valor 2: ");
            double valor2 = scanner.nextDouble();

            opcao = opcao.toUpperCase();
            Operacao operacao = obterOperacaoDesejada(opcao);
            double resultado = operacao.calcular(valor1, valor2);
            System.out.printf("O resultado é: %.2f", resultado);
            System.out.println();
            System.out.println("Descricao: " + operacao.getDescricao());
        } catch(Exception CalculadoraException) {

        }
    }

    private static Operacao obterOperacaoDesejada(String opcao) {
        Operacao operacao;
        switch (opcao) {
            case "A":
                operacao = new Adicao();
                break;
            case "S":
                operacao = new Subtracao();
                break;
            case "M":
                operacao = new Multiplicacao();
                break;
            case "D":
                operacao = new Divisao();
                break;
            default:
                operacao = null;
        }
        return operacao;
    }
}





