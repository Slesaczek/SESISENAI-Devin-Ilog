package main.java.tech.devinhouse.petshop.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tutor {

    private Integer id;
    private String nome;
    private Integer idade;

}
