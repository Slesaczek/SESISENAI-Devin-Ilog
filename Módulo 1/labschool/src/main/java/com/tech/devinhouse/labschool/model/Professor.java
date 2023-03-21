package com.tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "professor")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Professor extends Pessoa {




    @Column(name = "ESTADO", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoProfessor estadoProfessor;

    @Column(name = "EXPERIENCIA", nullable = false)
    @Enumerated(EnumType.STRING)
    private ExperienciaProfessor experienciaProfessor;

    @Column(name = "FORMACAO", nullable = false)
    @Enumerated(EnumType.STRING)
    private FormacaoProfessor formacaoProfessor;

    public Professor(Integer codigo, String nome, String telefone, LocalDate dataNascimento, long cpf, EstadoProfessor estadoProfessor, ExperienciaProfessor experienciaProfessor, FormacaoProfessor formacaoProfessor) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.estadoProfessor = estadoProfessor;
        this.experienciaProfessor = experienciaProfessor;
        this.formacaoProfessor = formacaoProfessor;
    }
}
