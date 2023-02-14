package tech.devinhouse.m01s06spring.repositories;

import tech.devinhouse.m01s06spring.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository{

    private static Integer SEQUENCIA = 0;

    private static List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> findAll(){
        return pessoas;
    }

    public Pessoa() {
        this.id = gerarId();
    }

    private Integer gerarId() {
        return ++SEQUENCIA;
    }

}


