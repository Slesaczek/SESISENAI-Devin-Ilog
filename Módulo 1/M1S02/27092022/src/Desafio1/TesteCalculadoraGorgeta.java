package Desafio1;

public class TesteCalculadoraGorgeta {

    public static void main(String[] args) {

        CalculadoraGorgeta calculadora = new CalculadoraGorgeta();

        calculadora.setPercentual(10);
        calculadora.setValorConta(1000f);

        float resultado = calculadora.calcularGorgeta();

        System.out.println("A gorgeta é de: "+ resultado);


    }

}
