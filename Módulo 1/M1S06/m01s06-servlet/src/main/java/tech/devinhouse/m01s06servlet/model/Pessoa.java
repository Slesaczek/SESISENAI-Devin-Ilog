package tech.devinhouse.m01s06servlet.model;

import jakarta.servlet.annotation.HttpMethodConstraint;

import java.math.BigDecimal;

public class Pessoa {

    private static Integer SEQUENCIA = 0;

    private Integer id;
    private String nome;
    private Integer idade;

    public Pessoa() {
        this.id = proximoId();
    }

    private Integer proximoId() {
        return ++SEQUENCIA;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}