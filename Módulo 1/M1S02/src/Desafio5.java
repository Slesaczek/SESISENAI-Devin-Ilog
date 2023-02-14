import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Desafio5 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1,2,3,4);

        List<String> opcoes = Arrays.asList("1 - Primeira Opção", "2 - Segunda Opção","3 - Terceira Opção","4 - Quarta Opção");

        System.out.println(opcoes.get(0));
        System.out.println(opcoes.get(1));
        System.out.println(opcoes.get(2));
        System.out.println(opcoes.get(3));

        System.out.println("Digite a opção desejada:");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        System.out.println("Opção valida: " + numeros.contains(opcao));

    }
}
