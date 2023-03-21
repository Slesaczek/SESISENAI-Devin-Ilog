package org.labschool.model;

public enum Experiencia {
    TODOS,

    FRONT_END,

    BACK_END,

    FULL_STACK;

    public static Experiencia obterPeloCodigo(int codigo) {
        if(codigo == 4){
            codigo = 0;
        }
        Experiencia[] experiencia = Experiencia.values();
        return experiencia[codigo];
    }
}
