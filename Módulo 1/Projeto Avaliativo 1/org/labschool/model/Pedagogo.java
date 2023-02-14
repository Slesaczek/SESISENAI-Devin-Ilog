package org.labschool.model;

import java.time.LocalDate;

public class Pedagogo extends Pessoa implements Comparable<Pedagogo>{
    private int qtdAtendimento;

    public Pedagogo(String nome, Long cpf, String telefone, String dataNasc, int qtdAtendimento) {
        super(nome, cpf, telefone, dataNasc);
        this.qtdAtendimento = qtdAtendimento;
    }

    public String relatorio(){
        return  "Pedagogo: Código: " + super.getId()
                + " Nome: " + super.getNome()
                + " Atendimento: " + qtdAtendimento;
    }

    @Override
    public int compareTo(Pedagogo o) {
        return (this.qtdAtendimento - o.qtdAtendimento);
    }

    public int getQtdAtendimento() {
        return qtdAtendimento;
    }

    public void setQtdAtendimento(int qtdAtendimento) {
        this.qtdAtendimento = qtdAtendimento;
    }


}
