package com.Desafio01;

public interface Operacao {

     Double calcular(Double valor1, Double valor2);

     default String getDescricao(){
          return getClass().getSimpleName();
     }
}
