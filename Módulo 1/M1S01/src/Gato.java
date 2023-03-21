public class Gato {

    String nome;
    Integer idade;

    public String miar() {
        return "miauuuuuu";
    }

    public String andar() {
        return "estou andando";
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + "'" +
                ", idade=" + idade +
                '}';
    }

}

