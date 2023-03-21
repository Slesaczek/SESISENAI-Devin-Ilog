import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormataData {

    public static void main(String[] args) {

        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String dataFormatada = formatador.format(agora);

        System.out.println(dataFormatada);

    }

}
