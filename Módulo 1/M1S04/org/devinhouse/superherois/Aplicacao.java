package org.devinhouse.superherois;

import org.devinhouse.superherois.cli.Display;
import org.devinhouse.superherois.exception.OpcaoInvalidaException;
import org.devinhouse.superherois.model.Operacao;
import org.devinhouse.superherois.model.Personagem;
import org.devinhouse.superherois.model.TipoPersonagem;
import org.devinhouse.superherois.repository.PersonagemRepository;

import java.util.List;

public class Aplicacao {

    private Display display = new Display();
    private PersonagemRepository repo = new PersonagemRepository();

    public void executar() {
        Operacao operacao = null;

        while (operacao != Operacao.SAIR) {
            display.exibirMenu();
            try {
                operacao = display.obterOperacao();
                processar(operacao);
            } catch (OpcaoInvalidaException e) {
                display.exibirMensagem("Opção informada é inválida!");
            }
        }

    }

    private void processar(Operacao operacao) {
        switch (operacao) {
            case CADASTRAR_HEROI:
                Personagem heroi = display.cadastrar(TipoPersonagem.HEROI);
                repo.inserir(heroi);
                break;
            case CADASTRAR_VILAO:
                Personagem vilao = display.cadastrar(TipoPersonagem.VILAO);
                repo.inserir(vilao);
                break;
            case LISTAR:
                List<Personagem> personagens = repo.consultar();
                if (personagens.isEmpty()) {
                    display.exibirMensagem("Sem personagens cadastrados");
                }
                display.listar(personagens);
                break;
        }
    }

}
