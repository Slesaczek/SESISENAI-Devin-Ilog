package org.labschool.model;

public enum ListarPessoas {
    SAIR,
    ALUNOS,
    PROFESSORES,
    PEDAGOGOS,
    TODOS;

    public static ListarPessoas obterPeloCodigo(int codigo) {
        ListarPessoas[] listarPessoas = ListarPessoas.values();
        return listarPessoas[codigo];
    }

}
