package com.tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Aluno extends Pessoa {

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "situacao", referencedColumnName = "situacao")
    private SituacaoMatriculaAluno situacao;

    private Double nota;

    private Integer atendimento=0;

    public Aluno(Integer codigo, String nome, String telefone, LocalDate dataNasc, long cpf, SituacaoMatriculaAluno situacao, Double nota, Integer atendimento) {
        super(codigo, nome, telefone, dataNasc, cpf);
        this.situacao = situacao;
        this.nota = nota;
        this.atendimento = atendimento;
    }
}
