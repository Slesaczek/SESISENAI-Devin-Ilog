import java.util.*;

public class Ex10 {
    public static void main(String[] args) {
        String normal = "arara";
        String invertida = new StringBuffer(normal).reverse().toString();

        if(normal.equals(invertida)){
            System.out.println("É palindrome");
        } else {
            System.out.println("Não é palindrome");
        }

    }
}
