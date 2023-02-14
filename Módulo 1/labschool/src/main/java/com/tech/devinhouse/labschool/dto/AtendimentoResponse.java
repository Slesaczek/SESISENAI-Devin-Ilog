package com.tech.devinhouse.labschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoResponse {


    private AlunoResponse alunoResponse;

    private PedagogoResponse pedagogosResponse;
}
