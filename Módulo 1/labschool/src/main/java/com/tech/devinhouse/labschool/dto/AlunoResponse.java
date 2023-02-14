package com.tech.devinhouse.labschool.dto;

import com.tech.devinhouse.labschool.model.SituacaoMatriculaAluno;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoResponse {

    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNasc;

    private Long cpf;

    private SituacaoMatriculaAluno situacao;

    private Double nota;

    private Integer atendimento;
}
