public class Operadores {

    public static void main(String[] args) {

        float resultado = 3.2f + 2.5f;

        System.out.println("O resultado da conta é " + resultado);

        String nome = "tiago";
        nome = "silvana";

        float salario = 1200f;
        float salarioReajustado = salario + 100f;
        salarioReajustado = salarioReajustado + 200f;

        System.out.println(salarioReajustado);

        int diaDaSemana = 4;
        boolean ehFimDeSemana = diaDaSemana == 7;

        System.out.println("fim de semana = " + ehFimDeSemana);
    }

}
