package org.labschool.cli;

import org.labschool.exception.OpcaoInvalidaException;
import org.labschool.model.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Display {



    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public int operacao() throws OpcaoInvalidaException {
        System.out.print("Digite a opção desejada: ");
        Scanner scanner = new Scanner(System.in);
        int codigoOpcao = scanner.nextInt();
        if (codigoOpcao < 0 || codigoOpcao > OperacaoMenuPrincipal.values().length) {
            throw new OpcaoInvalidaException();
        }
        return codigoOpcao;
    }

    public OperacaoMenuPrincipal obterOperacao() throws OpcaoInvalidaException {
        int codigoOpcao = operacao();
        OperacaoMenuPrincipal operacaoMenuPrincipal = OperacaoMenuPrincipal.obterPeloCodigo(codigoOpcao);
        return operacaoMenuPrincipal;
    }

    public SituacaoMatricula obterSituacaoMatricula() throws OpcaoInvalidaException {
        exibirSituacaoMatricula();
        SituacaoMatricula situacaoMatricula = SituacaoMatricula.obterPeloCodigo(operacao());
        return situacaoMatricula;
    }

    public SituacaoMatricula obterSituacaoMatricula2() throws OpcaoInvalidaException {
        exibirRelatorioAlunos();
        SituacaoMatricula situacaoMatricula = SituacaoMatricula.obterPeloCodigo(operacao());
        return situacaoMatricula;
    }

    public TipoPessoa obterTipoPessoa() throws OpcaoInvalidaException {
        this.exibirMenuCadastro();
        TipoPessoa obterTipoPessoa = TipoPessoa.obterPeloCodigo(operacao());
        return obterTipoPessoa;
    }

    public FormacaoAcademica obterFormacaoAcademica() throws OpcaoInvalidaException {
        exibirMenuFormacao();
        FormacaoAcademica formacaoAcademica = FormacaoAcademica.obterPeloCodigo(operacao());
        return formacaoAcademica;
    }

    public Experiencia obterExperiencia() throws OpcaoInvalidaException {
        exibirMenuExperiencia();
        Experiencia experiencia = Experiencia.obterPeloCodigo(operacao());
        return experiencia;
    }

    public Experiencia obterExperiencia2() throws OpcaoInvalidaException {
        exibirMenuListaProfessores();
        Experiencia experiencia = Experiencia.obterPeloCodigo(operacao());
        return experiencia;
    }


    public Status obterStatus() throws OpcaoInvalidaException {
        exibirMenuStatus();
        Status status = Status.obterPeloCodigo(operacao());
        return status;
    }

    public ListarPessoas obterlistaPessoa() throws OpcaoInvalidaException {
        exibirMenuListarPessoas();
        ListarPessoas listarPessoas = ListarPessoas.obterPeloCodigo(operacao());
        return listarPessoas;
    }

    public void imprimirListaAluno(List<Aluno> alunos){
        for(Aluno aluno: alunos) {
            System.out.println(aluno.relatorio());
        }
    }

    public void imprimirListaPedagogo(List<Pedagogo> pedagogos){
        for(Pedagogo pedagogo: pedagogos) {
            System.out.println(pedagogo.relatorio());
        }
    }

    public Pessoa cadastrar(TipoPessoa tipo) throws OpcaoInvalidaException {

        if(tipo != TipoPessoa.SAIR) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Informe o nome: ");
            String nome = scanner.nextLine();
            System.out.println();
            System.out.print("Informe o CPF: ");
            Long cpf = Long.valueOf(scanner.nextLine());
            System.out.println();
            System.out.print("Informe a data de nascimento: ");
            String dataNasc = scanner.nextLine();
            System.out.println();
            System.out.print("Informe o telefone: ");
            String telefone = scanner.nextLine();
            System.out.println();
            Pessoa pessoa = null;
            if (tipo == TipoPessoa.ALUNO) {
                System.out.print("Informe a nota: ");
                double nota = Double.parseDouble(scanner.nextLine());
                System.out.println();
                String situacao = String.valueOf(this.obterSituacaoMatricula());
                System.out.println();
                int atendimento = 0;
                pessoa = new Aluno(nome, cpf, telefone, dataNasc, nota, atendimento, situacao);
            } else if (tipo == TipoPessoa.PROFESSOR) {
                System.out.printf("Informe o formação academica:");
                String formacao = String.valueOf(obterFormacaoAcademica());
                System.out.printf("\nInforme o experiência: ");
                String experiencia = String.valueOf(obterExperiencia());
                System.out.printf("\nInforme o status: ");
                String status = String.valueOf(obterStatus());
                pessoa = new Professor(nome,cpf,telefone,dataNasc,formacao,experiencia,status);
            } else if (tipo == TipoPessoa.PEDAGOGO) {
                int atendimento = 0;
                pessoa = new Pedagogo(nome,cpf,telefone,dataNasc,atendimento);
            }

            System.out.println("Cadastrado com sucesso!");
            return pessoa;

        } else {
            return null;
        }
    }
    //RF02
    public Pessoa alterar(List<Pessoa> pessoas) throws OpcaoInvalidaException {
        //listarAlunos(pessoas);
        System.out.println("Selecione um aluno para alteração:");
        Scanner scanner = new Scanner(System.in);
        int codigo = scanner.nextInt();
        String situacao = String.valueOf(this.obterSituacaoMatricula());
        for (Pessoa pessoa: pessoas) {
            if(pessoa.getId() == codigo){
                Aluno aluno = (Aluno) pessoa;
                aluno.setSituacao(String.valueOf(situacao));
            }
        }
        return null;
    }

    public Pessoa atendimentoAluno(List<Pessoa> pessoas){
        listarAlunos(pessoas);
        System.out.println("\nSelecione um aluno para alteração:");
        Scanner scanner = new Scanner(System.in);
        int codigo = scanner.nextInt();
        for (Pessoa pessoa: pessoas) {
            if(pessoa.getId() == codigo){
                Aluno aluno = (Aluno) pessoa;
                aluno.setQtdAtendimentos(aluno.getQtdAtendimentos()+1);
                aluno.setSituacao(String.valueOf(SituacaoMatricula.ATENDIMENTO_PEDAGOGICO));
            }
        }
        return null;
    }
    public Pessoa atendimentoPedagogo(List<Pessoa> pessoas){
        listarPedagogos(pessoas);
        System.out.println("\nSelecione um pedagogo para alteração:");
        Scanner scanner = new Scanner(System.in);
        int codigo = scanner.nextInt();
        for (Pessoa pessoa: pessoas) {
            if(pessoa.getId() == codigo){
                Pedagogo pedagogo = (Pedagogo) pessoa;
                pedagogo.setQtdAtendimento(pedagogo.getQtdAtendimento()+1);
            }
        }
        return null;
    }

    public Pessoa atendimento(List<Pessoa> pessoas){
        System.out.println("Selecione quem participou do atendimento:");
        atendimentoAluno(pessoas);
        System.out.println();
        atendimentoPedagogo(pessoas);

        return null;
    }

    public void listarAlunos(List<Pessoa> pessoas){
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                System.out.println(aluno.relatorio());
            }
        }
    }

    public void listarProfessores(List<Pessoa> pessoas){
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Professor) {
                Professor professor = (Professor) pessoa;
                System.out.println(professor.relatorio());
            }
        }
    }
    public void listarPedagogos(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Pedagogo) {
                Pedagogo pedagogo = (Pedagogo) pessoa;
                System.out.println(pedagogo.relatorio());
            }
        }
    }



    //RF01
    public void exibirSituacaoMatricula() {
        System.out.println();
        System.out.println("=== CADASTRO ===");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atendimento pedagógico");
        System.out.println("4 - Inativo");
        System.out.println();
    }


    public void exibirMenuPrincipal() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar(Somente aluno)");
        System.out.println("3 - Atendimento");
        System.out.println("4 - Listar");
        System.out.println("5 - Relátorios");
        System.out.println("0 - Sair");
        System.out.println();
    }

    //RF03
    public void exibirMenuCadastro() {
        System.out.println();
        System.out.println("=== CADASTRO ===");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Pedagogo");
        System.out.println("0 - Sair");
        System.out.println();
    }

    //RF07
    public void exibirRelatorioAlunos() {
        System.out.println();
        System.out.println("=== RELATÓRIO ===");
        System.out.println("1 - Ativos");
        System.out.println("2 - Irregulares");
        System.out.println("3 - Atendimento pedagógico");
        System.out.println("4 - Inativos");
        System.out.println("5 - Todos");
        System.out.println();
    }

    //RF08
    public void exibirMenuListaProfessores() {
        System.out.println();
        System.out.println("=== RELATÓRIO ===");
        System.out.println("1 - Front-End");
        System.out.println("2 - Back-End");
        System.out.println("3 - Full-Stack");
        System.out.println("4 - Todos");
        System.out.println("0 - Sair");
        System.out.println();
    }

    public void exibirMenuListarPessoas() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Listar Professores");
        System.out.println("3 - Listar Pedagogs");
        System.out.println("4 - Listar todos");
        System.out.println("0 - Sair");
        System.out.println();
    }

    public void exibirMenuFormacao() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1 - Graduação incompleta");
        System.out.println("2 - Graduação completa");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado");
        System.out.println("0 - Sair");
        System.out.println();
    }

    public void exibirMenuExperiencia() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1 - Front-end");
        System.out.println("2 - Back-end");
        System.out.println("3 - Full-stack");
        System.out.println("0 - Sair");
        System.out.println();
    }
    public void exibirMenuStatus() {
        System.out.println();
        System.out.println("=== STATUS ===");
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
        System.out.println("0 - Sair");
        System.out.println();
    }
}


