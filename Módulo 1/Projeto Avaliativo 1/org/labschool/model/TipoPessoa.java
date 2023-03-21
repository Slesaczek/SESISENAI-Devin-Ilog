package org.labschool.model;

public enum TipoPessoa {
    SAIR,
    ALUNO,
    PROFESSOR,
    PEDAGOGO;

    public static TipoPessoa obterPeloCodigo(int codigo) {
        TipoPessoa[] tipoPessoa = TipoPessoa.values();
        return tipoPessoa[codigo];
    }
}
