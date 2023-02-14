public class Principal {

    public static void main(String[] args) {

        Gato gatoObjeto = new Gato();  // criando um novo objeto do tipo da classe Gato

//        System.out.println("ANTES");
//        System.out.println("O nome do gato é: " + gatoObjeto.nome);
//        System.out.println("A idade do gato é: " + gatoObjeto.idade);

        gatoObjeto.nome = "garfield";
        gatoObjeto.idade = 5;

//        System.out.println("DEPOIS");
        System.out.println("O nome do gato é: " + gatoObjeto.nome);
        System.out.println("A idade do gato é: " + gatoObjeto.idade);

        System.out.println( gatoObjeto.miar() );

        String retorno = gatoObjeto.andar();
        System.out.println(retorno);

        System.out.println("Usando toString: " + gatoObjeto );

        // usando outra classe de exemplo:

        Endereco endereco = new Endereco();
        endereco.rua = "Rua Max Cavalera";
        endereco.bairro = "Estreito";
        endereco.cep = 888888888L;

        Pessoa pessoa = new Pessoa();
        pessoa.nome = "tiago";
        pessoa.idade = 22;
        pessoa.endereco = endereco;

    }

}
