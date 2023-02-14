import java.util.Scanner;

public class LinhaDeComando {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // objeto que lê da entrada padrão do computador = teclado

        System.out.println("Digite seu primeiro nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite sua idade:");
        int idade = scanner.nextInt();

        System.out.println("O nome informado foi " + nome + " e a idade informada foi " + idade);
    }

}
