package org.labschool.model;

public enum SituacaoMatricula {
    TODOS,
    ATIVO,

    IRREGULAR,

    ATENDIMENTO_PEDAGOGICO,

    INATIVO;



    public static SituacaoMatricula obterPeloCodigo(int codigo) {
        if(codigo == 5){
            codigo = 0;
        }
        SituacaoMatricula[] SituacaoMatriculas = SituacaoMatricula.values();
        return SituacaoMatriculas[codigo];
    }


}
