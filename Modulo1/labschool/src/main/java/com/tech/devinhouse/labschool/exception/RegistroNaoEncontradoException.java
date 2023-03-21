package com.tech.devinhouse.labschool.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(String nomeRecurso, String codigo) {
        super(nomeRecurso + " com identificador " + codigo + " não encontrado!");
    }

    public RegistroNaoEncontradoException(String nomeRecurso, Integer codigo) {
        this(nomeRecurso, String.valueOf(codigo));
    }
}
