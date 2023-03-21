package com.devinhouse.personagem;

import java.time.LocalDate;
import java.util.Date;

public class Personagem {

    String  nome;
    String  referencia;
    Integer idade;
    LocalDate createDate;


    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", referencia='" + referencia + '\'' +
                ", idade=" + idade +
                ", createDate=" + createDate +
                '}';
    }

    public String obterNomeEmMaiusculo(String nome){
        return this.nome.toUpperCase();
    }

    public String obterTresPrimeirasLetrasDoNome(String nome){
        return this.nome.substring(0,3);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
