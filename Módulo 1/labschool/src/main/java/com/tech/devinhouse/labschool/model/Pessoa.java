package com.tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;



@MappedSuperclass
@Table(name = "PESSOA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNasc;

    private long cpf;

}
