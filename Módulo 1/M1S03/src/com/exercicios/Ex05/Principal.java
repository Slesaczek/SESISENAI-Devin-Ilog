package com.exercicios.Ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Principal {

        public static void main(String[] args) throws IOException {
            List<String> lista = lerDoArquivo();
            List<Concurso> concursos = carregarConcursos(lista);
            MegaSena megaSena = new MegaSena(concursos);

            megaSena.imprimir(); // ex 05
            megaSena.imprimirComNrosSorteadosEmOrdem(); // ex 06
            megaSena.imprimirConcursosEmOrdemDeNumero(); // ex 07
            megaSena.verificarSeTeveSorteio(); // ex 08
            megaSena.verificarSeOsNumerosForamSorteados();  // ex 09
            megaSena.imprimirNrosFrequentes();  // ex 10
            megaSena.imprimirNroMaisAtrasado(); // ex 11
        }

        private static List<String> lerDoArquivo() throws IOException {
            Path arquivo = Paths.get("D:\\slehz\\Desktop\\","megasena.txt");
            List<String> lista = Files.readAllLines(arquivo);
            return lista;
        }

        private static List<Concurso> carregarConcursos(List<String> lista) {
            List<Concurso> concursos = new ArrayList<>();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for(String linha: lista) {
                String[] partes = linha.split(",");
                Integer nro = Integer.valueOf(partes[0]);
                String dataStr = partes[1];
                LocalDate data = LocalDate.parse(dataStr, formatador);
                int[] sorteados = new int[6];
                for (int i=2; i<=7; i++) {
                    sorteados[i-2] = Integer.parseInt(partes[i]);
                }
                // ou pode atribuir direto cada valor:
//            int[] sorteados = { Integer.parseInt(partes[2]), Integer.parseInt(partes[3]),
//                    Integer.parseInt(partes[4]), Integer.parseInt(partes[5]),
//                    Integer.parseInt(partes[6]), Integer.parseInt(partes[7]) };
                Concurso concurso = new Concurso(nro, data, sorteados);
                concursos.add(concurso);
            }
            return concursos;
        }


    }





