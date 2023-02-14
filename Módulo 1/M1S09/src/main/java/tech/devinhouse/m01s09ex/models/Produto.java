package tech.devinhouse.m01s09ex.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(nullable = false, length = 50, unique = true)
    private String sku;

    @Column(nullable = false, length = 50)
    private String nome;

    private String descricao;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valorUnitario = BigDecimal.ZERO;

}
