package org.labschool.model;

public enum OperacaoMenuPrincipal {
    SAIR,
    CADASTRAR,

    ALTERAR,

    ATENDIMENTO,
    LISTAR,
    RELATORIOS;

    public static OperacaoMenuPrincipal obterPeloCodigo(int codigo) {
        OperacaoMenuPrincipal[] OperacoesMenuPrincipal = OperacaoMenuPrincipal.values();
        return OperacoesMenuPrincipal[codigo];
    }

}
