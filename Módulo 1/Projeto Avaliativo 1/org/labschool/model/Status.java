package org.labschool.model;

public enum Status {
    ATIVO,
    INATIVO;

    public static Status obterPeloCodigo(int codigo) {
        Status[] estadoProfessores = Status.values();
        return estadoProfessores[codigo - 1];
    }
}
