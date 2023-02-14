package com.tech.devinhouse.labschool.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PedagogoResponse {
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNasc;

    private Long cpf;

    private int atendimentos;
}
