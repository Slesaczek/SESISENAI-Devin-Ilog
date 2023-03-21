package com.tech.devinhouse.labschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest{

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min = 1, max = 100, message = "campo.invalido")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    private String telefone;

    @NotNull(message = "{campo.obrigatorio}")
    @Past(message = "campo.invalido")
    private LocalDate dataNascimento;

    @NotNull(message = "{campo.obrigatorio}")
    private Long cpf;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Pattern(regexp = "ATIVO|IRREGULAR|ATENDIMENTO_PEDAGOGICO|INATIVO", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{campo.invalido}")
    private String situacao;

    @NotNull(message = "{campo.obrigatorio}")
    private Double nota;

}
