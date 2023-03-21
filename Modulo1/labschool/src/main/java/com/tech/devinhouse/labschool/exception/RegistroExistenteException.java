package com.tech.devinhouse.labschool.exception;

public class RegistroExistenteException extends RuntimeException {

    public RegistroExistenteException(String nomeRecurso, String codigo) {
        super(nomeRecurso + " com identificador " + codigo + " já existente!");
    }

    public RegistroExistenteException(String nomeRecurso, Integer codigo) {

        this(nomeRecurso, String.valueOf(codigo));
    }
}

