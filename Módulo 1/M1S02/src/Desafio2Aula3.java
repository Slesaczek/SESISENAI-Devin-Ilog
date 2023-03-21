import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Desafio2Aula3 {

    public static void main(String[] args) {



        List<Integer> arr  = Arrays.asList(3, 5, 1, 4, 7, 6, 5, 2, 3, 4, 2, 3, 1, 0, 6);

        List<Integer> unico = new ArrayList<>();

        boolean validador = false;

        int n = arr.size();

        for (int i=0; i<n; i++) {
            int numero = arr.get(i);

            for(int j=0; j<n; j++) {
                if (j == i)
                    continue;

                int numeroValidador = arr.get(j);

                if (numero != numeroValidador) {
                    validador = true;
                    continue;
                } else if (numero == numeroValidador) {
                    validador = false;
                    break;
                }
            }
                if(validador) {
                    unico.add(numero);
                }
        }
        System.out.println(unico);


    }
}



