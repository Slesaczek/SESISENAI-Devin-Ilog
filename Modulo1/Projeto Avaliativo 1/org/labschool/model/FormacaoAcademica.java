package org.labschool.model;

public enum FormacaoAcademica {

    GRADUACAO_INCOMPLETA,

    GRADUACAO_COMPLETA,

    MESTRADO,

    DOUTORADO;

    public static FormacaoAcademica obterPeloCodigo(int codigo) {
        FormacaoAcademica[] FormacaoAcademicas = FormacaoAcademica.values();
        return FormacaoAcademicas[codigo - 1];
    }

}
