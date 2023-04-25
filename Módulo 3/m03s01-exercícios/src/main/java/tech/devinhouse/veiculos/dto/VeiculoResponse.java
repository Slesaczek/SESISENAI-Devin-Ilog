package tech.devinhouse.veiculos.dto;

import lombok.Data;

@Data
public class VeiculoResponse {

    private String placa;

    private String tipo;

    private String cor;

    private Integer anoDeFabricacao;

    private Integer qtdMultas;

}
