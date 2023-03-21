package com.tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pedagogo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa{

    private int atendimentos=0;

    public Pedagogo(Integer codigo, String nome, String telefone, LocalDate dataNascimento, long cpf, int atendimentos) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.atendimentos = atendimentos;
    }
}
