public class Ex05 {
    public static void main(String[] args) {
    /*Implemente uma função 'calcular' que receba como parâmetro um array (numérico) e identifique o maior e menor  valor do mesmo.
    Imprima no console estes valores ou "Não é possível calcular" qdo não for possível.

     Teste a função com as seguintes entradas:

     - {56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47}
     - {1}
     - {1, -1}
     - null
     - {-2,-2,-2,-2}
     - {20,10, 30}*/

        int numeros[] = {-2,-2,-2,-2};

        calcular(numeros);
    }
    public static void calcular(int array[]){

        int  maior=0, menor=0;

        if(array.length==0){
            System.out.println("Não é possível calcular");
            return;
        }


        for(int i=0;i<array.length;i++) {
            if(i==0){
                maior = array[i];
            }else if(array[i]>maior){
                maior = array[i];
            }

        }
        for(int j=0;j<array.length;j++){
            if(j==0){
                menor = array[j];
            }else if(array[j]<menor){

            }
        }
        System.out.println("Maior número:"+ maior);
        System.out.println("Menor número:"+ menor);
    }
}
