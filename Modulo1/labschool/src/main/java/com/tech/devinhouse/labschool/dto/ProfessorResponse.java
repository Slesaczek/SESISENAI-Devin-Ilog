package com.tech.devinhouse.labschool.dto;

import com.tech.devinhouse.labschool.model.EstadoProfessor;
import com.tech.devinhouse.labschool.model.ExperienciaProfessor;
import com.tech.devinhouse.labschool.model.FormacaoProfessor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfessorResponse {
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNasc;

    private Long cpf;

    private FormacaoProfessor formacao;

    private ExperienciaProfessor experiencia;

    private EstadoProfessor estado;
}
