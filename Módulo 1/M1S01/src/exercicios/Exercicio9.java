package exercicios;

import java.util.Scanner;

public class Exercicio9 {

    public static void main(String[] args) {
        System.out.print("Qual seu herói favorito? ");
        Scanner scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();
        System.out.println("Seu herói favorito é " + resposta);
//        System.out.println( String.format("Seu herói favorito é %s", resposta) );
    }

}
