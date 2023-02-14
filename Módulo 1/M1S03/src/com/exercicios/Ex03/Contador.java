package com.exercicios.Ex03;

public class Contador {

    public static void contarPalavras(String frase){
        String [] listaPalavras = frase.split(" ");

        System.out.println("Quantidade de palavras no texto: "+listaPalavras.length);
    }
}

