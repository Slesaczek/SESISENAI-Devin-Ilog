package tech.devinhouse.m01s09ex.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50, unique = true)
    private String cpfCnpj;

}
