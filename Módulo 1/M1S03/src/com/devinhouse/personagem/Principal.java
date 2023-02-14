package com.devinhouse.personagem;

import java.time.LocalDateTime;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Personagem personagem = new Personagem();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Coloque as informações sobre seu personagem?");

        System.out.println("Qual é o seu nome?");
        personagem.setNome(scanner.nextLine());

        System.out.println("Uma refência(Série ou filme)?");
        personagem.setReferencia(scanner.nextLine());

        System.out.println("Qual a idade do personagem?");
        personagem.setIdade(scanner.nextInt());

        personagem.setCreateDate(LocalDateTime.now().toLocalDate());

        System.out.println(personagem.obterNomeEmMaiusculo(personagem.getNome()));
        System.out.println(personagem.obterTresPrimeirasLetrasDoNome(personagem.getNome()));
        System.out.println(personagem.toString());




    }
}
