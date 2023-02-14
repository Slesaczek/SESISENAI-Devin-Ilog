package com.exercicios.Ex04;

public class Contador2 {

    private String frase;

    public Contador2(String frase) {
        this.frase = frase;
    }

    public String contarPalavras(){

        String[] listaPalavras = this.frase.split(" ");

        return String.format("Quantidade de palavras no texto: %s",listaPalavras.length);
    }
}
