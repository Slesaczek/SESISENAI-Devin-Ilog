package exercicios;

public class Exercicio8 {

    public static void main(String[] args) {
        // Dado que tem 12 vitórias, 2 derrotas e 6 empates
        // Imprimir a frase "O time <NOME_DO_TIME> acumulou <NRO_DE_PTOS> após jogar <NRO_PARTIDAS> partidas"
        String nomeTime = "Tabajara F.C.";
        int vitoria = 12;
        int derrotas = 2;
        int empates = 6;
        int partidas = vitoria + derrotas + empates;
        int pontos = (vitoria * 3) + (empates * 1) + (derrotas * 0); // versao completa para fins didáticos
//        System.out.println("O time " + nomeTime + " acumulou " + pontos + " pontos após jogar " + partidas + " partidas.");
        String frase = String.format("O time %s acumulou %d pontos após jogar %d partidas.",
                nomeTime, pontos, partidas);
        System.out.println(frase);
    }

}
