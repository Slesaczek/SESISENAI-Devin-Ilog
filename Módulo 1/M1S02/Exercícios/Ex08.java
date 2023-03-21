import java.util.*;

public class Ex08 {
    public static void main(String[] args) {
        /*Localize na lista abaixo e imprima no console a primeira ocorrência de número maior que 50.*/

        List <Integer> numeros = Arrays.asList(0,2,88,56,33,42,67,3,9,0,2);


        for(int i=0;i<numeros.size();i++){
            if(numeros.get(i)>50){
                System.out.println(numeros.get(i));
                return;
            }

        }

    }
}
