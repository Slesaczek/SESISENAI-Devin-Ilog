public class DesafioAula3 {

    public static void main(String[] args) {

        for(int i=0; i<=33;i++) {

            if(i==0) {
                continue;
            }else if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz:"+i);
            }else if(i % 5 == 0){
                System.out.println("Buzz:"+i);
            }else if(i % 3 == 0) {
                System.out.println("Fizz:" + i);
            }else{
                System.out.println("Repete mesmo número:" + i);
            }


        }

    }
}
