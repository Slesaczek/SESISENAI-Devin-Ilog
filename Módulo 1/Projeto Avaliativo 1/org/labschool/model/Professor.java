package org.labschool.model;

public class Professor extends Pessoa {

    private String formacao;
    private String experiencia;
    private String estado;

    public Professor(String nome, Long cpf, String telefone, String dataNasc, String formacao, String experiencia, String estado) {
        super(nome, cpf, telefone, dataNasc);
        this.formacao = formacao;
        this.experiencia = experiencia;
        this.estado = estado;
    }

    public String relatorio(){
        return  "Professor: Código:" + super.getId()
                + " Nome: " + super.getNome()
                + " Formação: " + formacao
                + " Experiência: " + experiencia
                + " Estado: " + estado;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


