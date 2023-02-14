package org.labschool.repository;

import org.labschool.model.Aluno;
import org.labschool.model.Pedagogo;
import org.labschool.model.Pessoa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PessoaRepository {

    private List<Pessoa> dados = new ArrayList<>();

    private List<Aluno> alunoDesc = new ArrayList<>();

    private List<Pedagogo> pedagogoDesc = new ArrayList<>();

    private static int id = 0;

    public void inserir(Pessoa pessoa) {
        pessoa.setId(++id);
        dados.add(pessoa);
    }

    public List<Pessoa> consultar() {
        return dados;
    }

    public List<Aluno> consultarAluno() {
        for (Pessoa pessoa : dados) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                alunoDesc.add(aluno);
            }
        }
        Collections.sort(alunoDesc,Collections.reverseOrder());
        return alunoDesc;
    }

    public List<Pedagogo> consultarPedagogo() {
        for (Pessoa pessoa : dados) {
            if (pessoa instanceof Pedagogo) {
                Pedagogo pedagogo = (Pedagogo) pessoa;
                pedagogoDesc.add(pedagogo);
            }
        }
        Collections.sort(pedagogoDesc,Collections.reverseOrder());
        return pedagogoDesc;
    }
}

