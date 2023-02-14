package org.labschool.model;

public class Aluno extends Pessoa implements Comparable<Aluno>{

    private double nota;
    private int qtdAtendimentos;
    private String situacao;

    public Aluno(String nome, Long cpf, String telefone, String dataNasc, double nota, int qtdAtendimentos, String situacao) {
        super(nome, cpf, telefone, dataNasc);
        this.nota = nota;
        this.qtdAtendimentos = qtdAtendimentos;
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nota=" + nota +
                ", qtdAtendimentos=" + qtdAtendimentos +
                ", situacao='" + situacao + '\'' +
                '}';
    }
    public String relatorio(){
        return "Aluno: Código:" + super.getId()
                + " Nome:" + super.getNome()
                + " Nota:" + nota
                + " Atendimento:" + qtdAtendimentos;
    }

    @Override
    public int compareTo(Aluno o) {
        return (this.qtdAtendimentos-o.qtdAtendimentos);
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getQtdAtendimentos() {
        return qtdAtendimentos;
    }

    public void setQtdAtendimentos(int qtdAtendimentos) {
        this.qtdAtendimentos = qtdAtendimentos;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }



}
