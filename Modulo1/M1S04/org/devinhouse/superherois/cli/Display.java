package org.devinhouse.superherois.cli;

import org.devinhouse.superherois.exception.OpcaoInvalidaException;
import org.devinhouse.superherois.model.*;

import java.util.List;
import java.util.Scanner;

public class Display {

    public void exibirMenu() {
        System.out.println();
        System.out.println("== MENU ==");
        System.out.println("1 - Cadastrar Herói");
        System.out.println("2 - Cadastrar Vilão");
        System.out.println("3 - Listar");
        System.out.println("4 - Sair");
        System.out.println();
    }

    public Operacao obterOperacao() throws OpcaoInvalidaException {
        System.out.print("Digite a opção desejada: ");
        Scanner scanner = new Scanner(System.in);
        int codigoOpcao = scanner.nextInt();
        if (codigoOpcao < 0 || codigoOpcao > Operacao.values().length) {
            throw new OpcaoInvalidaException();
        }
        Operacao operacao = Operacao.obterPeloCodigo(codigoOpcao);
        return operacao;
    }

    public Personagem cadastrar(TipoPersonagem tipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.print("Informe o super-poder: ");
        String poder = scanner.nextLine();
        System.out.println();
        Personagem personagem;
        if (tipo == TipoPersonagem.HEROI) {
            System.out.print("Informe o nome na vida real: ");
            String outroNome = scanner.nextLine();
            System.out.println();
            personagem = new Heroi(nome, poder, outroNome);
        } else {
            System.out.print("Informe o tempo de prisao: ");
            String prisao = scanner.nextLine();
            System.out.println();
            personagem = new Vilao(nome, poder, Integer.valueOf(prisao));
        }
        return personagem;
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void listar(List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            System.out.println(personagem);
        }
    }
}
