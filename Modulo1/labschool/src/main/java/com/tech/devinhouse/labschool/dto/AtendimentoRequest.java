package com.tech.devinhouse.labschool.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AtendimentoRequest {

    @NotNull(message = "{campo.obrigatorio}")
    private int codigoAluno;

    @NotNull(message = "{campo.obrigatorio}")
    private int codigoPedagogo;
}
