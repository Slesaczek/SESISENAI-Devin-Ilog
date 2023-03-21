package org.labschool;



import org.labschool.exception.OpcaoInvalidaException;
import org.labschool.model.*;
import org.labschool.cli.Display;
import org.labschool.repository.PessoaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    private Display display = new Display();
    private PessoaRepository repo = new PessoaRepository();

    public void executar() {
        OperacaoMenuPrincipal operacaoMenuPrincipal = null;

        while (operacaoMenuPrincipal != operacaoMenuPrincipal.SAIR) {
            display.exibirMenuPrincipal();
            try {
                operacaoMenuPrincipal = display.obterOperacao();
                if(operacaoMenuPrincipal != operacaoMenuPrincipal.SAIR) {
                    processar(operacaoMenuPrincipal);
                }

            } catch (OpcaoInvalidaException e) {
                display.exibirMensagem("Opção informada é inválida!");
            }
        }

    }

    private void processar(OperacaoMenuPrincipal operacaoMenuPrincipal) throws OpcaoInvalidaException {

        switch (operacaoMenuPrincipal) {


            case CADASTRAR:
                Pessoa cadastro = display.cadastrar(display.obterTipoPessoa());
                if(cadastro != null){
                    repo.inserir(cadastro);
                }
                break;
            case ALTERAR:
                List<Pessoa> alterar = repo.consultar();
                if (alterar.isEmpty()) {
                    display.exibirMensagem("Não há pessoas cadastradas");
                    break;
                }
                display.alterar(alterar);
                break;
            case ATENDIMENTO:
                List<Pessoa> atendimento = repo.consultar();
                if (atendimento.isEmpty()) {
                    display.exibirMensagem("Não há pessoas cadastradas");
                } else {
                    display.atendimento(atendimento);
                }
                break;
            case LISTAR:
                List<Pessoa> lista = repo.consultar();
                if (lista.isEmpty()) {
                    display.exibirMensagem("Não há pessoas cadastradas");
                    break;
                }
                ListarPessoas listarPessoas = display.obterlistaPessoa();
                switch(listarPessoas){
                    case ALUNOS:
                        display.listarAlunos(lista);
                        break;
                    case PROFESSORES:
                        display.listarProfessores(lista);
                        break;
                    case PEDAGOGOS:
                        display.listarPedagogos(lista);
                        break;
                    case TODOS:
                        System.out.println("Alunos:");
                        display.listarAlunos(lista);
                        System.out.println();
                        System.out.println("Professores:");
                        display.listarProfessores(lista);
                        System.out.println();
                        System.out.println("Pedagogos:");
                        display.listarPedagogos(lista);
                    case SAIR:
                        break;
                }
                break;
            case RELATORIOS:
                System.out.println("=== RELATÓRIOS ===");
                System.out.println("1 - Alunos");
                System.out.println("2 - Professores");
                System.out.println("3 - Alunos com mais atendimentos");
                System.out.println("4 - Pedagogos com mais atendimentos");
                System.out.println("0 - Sair");
                System.out.print("Digite a opção desejada: ");
                Scanner scanner = new Scanner(System.in);
                int opcao = scanner.nextInt();
                if(opcao == 0){
                    break;
                }
                List<Pessoa> relatorio = repo.consultar();
                if (relatorio.isEmpty()) {
                    display.exibirMensagem("Não há pessoas cadastradas");
                    break;
                }
                if(opcao == 1){
                        SituacaoMatricula situacaoMatricula = display.obterSituacaoMatricula2();
                        for (Pessoa pessoa : relatorio) {
                            if (pessoa instanceof Aluno) {
                                Aluno aluno = (Aluno) pessoa;
                                if (aluno.getSituacao().compareTo(situacaoMatricula.name()) == 0) {
                                    System.out.println(aluno.relatorio());
                                } else if(situacaoMatricula.equals(SituacaoMatricula.TODOS)){
                                    System.out.println(aluno.relatorio());
                                }
                            }
                        }
                } else if(opcao == 2){
                    Experiencia experiencia = display.obterExperiencia2();
                    for (Pessoa pessoa : relatorio) {
                        if (pessoa instanceof Professor) {
                            Professor professor = (Professor) pessoa;
                            if (professor.getExperiencia().compareTo(experiencia.name()) == 0) {
                                System.out.println(professor.relatorio());
                            } else if(experiencia.equals(Experiencia.TODOS)){
                                System.out.println(professor.relatorio());
                            }
                        }
                    }
                } else if(opcao == 3){
                    List<Aluno> alunoDesc = repo.consultarAluno();
                    display.imprimirListaAluno(alunoDesc);
                    alunoDesc.clear();
                } else if(opcao == 4){
                    List<Pedagogo> pedagogoDesc = repo.consultarPedagogo();
                    display.imprimirListaPedagogo(pedagogoDesc);
                    pedagogoDesc.clear();
                }

            case SAIR:
                break;

        }
    }
}



