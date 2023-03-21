package tech.devinhouse.m01s06spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pessoa {



    private Integer id;
    private String nome;
    private Integer idade;
    private List<Pessoa> filhos = new ArrayList<>();



}