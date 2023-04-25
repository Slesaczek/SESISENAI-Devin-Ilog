package tech.devinhouse.veiculos.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoRequest {

    @NotEmpty(message = "Placa deve ser informada")
    private String placa;

    @NotEmpty(message = "Tipo deve ser informada")
    @Pattern(regexp = "carro|caminhao|onibus|trator|disco-voador", message = "Tipo deve ser: carro, caminhao, onibus, trator ou disco-voador")
    private String tipo;

    @NotEmpty(message = "Cor deve ser informada")
    private String cor;

    @NotNull(message = "Ano de Fabricação deve ser informado")
    private Integer anoDeFabricacao;

}
