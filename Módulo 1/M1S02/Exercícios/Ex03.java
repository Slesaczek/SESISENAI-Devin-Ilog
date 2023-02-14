public class Ex03 {

    public static void main(String[] args) {


/*    Percorra array com estrutura de repetição e faça operações com condicionais:

    O array abaixo representa lançamentos na conta bancária do Luke.
    Os valores negativos são débitos e os valores positivos são créditos.

    Implemente um código copiando o array abaixo, e depois imprima no console o que se pede:

    int[] extrato = { 100, -35, -15, -5, 55, -20 };

    a) Percorra o array (operador 'for') e imprima cada elemento do array na ordem;
    b) Percorra o array (operador 'for') e imprima os elementos de trás pra frente (do último para o primeiro);
    c) Percorra o array (operador 'for') e calcule o saldo final da conta (valor inicial era zero),
    imprima o resultado no console. (Dica: crie uma variável saldo inicializada com zero e vá atualizando seu valor);
    d) Imprima no console a mensagem 'saldo positivo' ou 'saldo negativo', dependendo do resultado do saldo final calculado.*/


        int[] extrato = { 100, -35, -15, -5, 55, -20 };
        int i = 0;
        float valorConta = 0f;

        //A
        for(i = 0; i<extrato.length; i++) {
            //System.out.println(extrato[i]);
        }
        //B
        for(i=extrato.length-1; i>=0; i--) {
            System.out.println(extrato[i]);
        }
        //C
        for(i=extrato.length-1; i>=0; i--) {
            valorConta += extrato[i];
        }
        System.out.println(valorConta);
        //D
        if(valorConta>0){
            System.out.println("Saldo positvo");
        }else{
            System.out.println("Saldo negativo");
        }


    }
}

