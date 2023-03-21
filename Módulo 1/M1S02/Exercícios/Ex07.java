import java.util.*;


public class Ex07 {
    public static void main(String[] args) {
        /*Dado a lista de nomes:

        List<String> nomes = Arrays.asList("kirk", "spock", "scott", "mccoy", "sulu");

        a) Percorra a lista usando o operador 'for' clássico, usando uma variável para iterar pelos índices,
        e imprima no console os valores de cada nome;
        b) Percorra a lista usando o operador 'for-each' usando a forma simplificada, e imprima no console os valores de cada nome;
        c) Percorra a lista usando o operador 'while', e imprima no console os valores de cada nome;*/

        List <String> nomes = Arrays.asList("kirk", "spock", "scott", "mccoy", "sulu");

        //A
        for(int i=0;i<nomes.size();i++){
            System.out.println("For:"+ nomes.get(i));
        }

        nomes.forEach((n) -> System.out.println("ForEach:"+n));

        int j=0;

        while(j<nomes.size()){
            System.out.println("While:"+nomes.get(j));
            j++;
        }






    }
}
