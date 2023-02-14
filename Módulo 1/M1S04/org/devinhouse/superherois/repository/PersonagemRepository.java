package org.devinhouse.superherois.repository;

import org.devinhouse.superherois.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagemRepository {

    private List<Personagem> dados = new ArrayList<>();

    public void inserir(Personagem personagem) {
        dados.add(personagem);
    }

    public List<Personagem> consultar() {
        return dados;
    }

}
