public class DesafioAula2 {

    public static void main(String[] args) {

        float altura = 1.85f;
        float peso = 88f;
        float imc  = peso/(altura*altura);

        if(imc<18.5){
            System.out.println("Magreza");
        }else if(imc>=18.5 && imc<=24.9){
            System.out.println("Normal");
        }else if(imc>=25 && imc<=29.9){
            System.out.println("Sobrepeso");
        }else if(imc>=30 && imc<=39.9){
            System.out.println("Obesidade");
        }else if(imc>40){
            System.out.println("Obesidade grave");
        }

    }

}
