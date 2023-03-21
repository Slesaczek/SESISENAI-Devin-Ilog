package com.exercicios.Ex05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConversorArrayParaLista {

    public static List<Integer> converter(int[] arr) {
        List<Integer> lista = new ArrayList<>();
        for(int nro: arr) {
            lista.add(nro);
        }
        return lista;
    }

    public static List<Integer> converterOrdenado(int[] arr) {
        List<Integer> convertido = converter(arr);
        Collections.sort(convertido);
        return convertido;
    }

}