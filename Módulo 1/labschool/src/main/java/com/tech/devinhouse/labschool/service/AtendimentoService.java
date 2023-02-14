package com.tech.devinhouse.labschool.service;

import com.tech.devinhouse.labschool.exception.RegistroNaoEncontradoException;
import com.tech.devinhouse.labschool.model.Aluno;
import com.tech.devinhouse.labschool.model.Pedagogo;
import com.tech.devinhouse.labschool.model.SituacaoMatriculaAluno;
import com.tech.devinhouse.labschool.repository.AlunoRepository;
import com.tech.devinhouse.labschool.repository.PedagagoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AtendimentoService {

    private AlunoRepository alunoRepository;
    private PedagagoRepository pedagogoRepository;

    public void atendimento(Integer codigoAluno, Integer codigoPedagogo){
        Optional<Aluno> alunoOpt = alunoRepository.findById(codigoAluno);
        Optional<Pedagogo> pegagogoOpt = pedagogoRepository.findById(codigoPedagogo);
        if(alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", codigoAluno);
        if(pegagogoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Pedagogo", codigoPedagogo);
        Aluno aluno = alunoOpt.get();
        Pedagogo pedagogo = pegagogoOpt.get();
        aluno.setSituacao(SituacaoMatriculaAluno.ATENDIMENTO_PEDAGOGICO);
        aluno.setAtendimento(aluno.getAtendimento()+1);
        pedagogo.setAtendimentos(pedagogo.getAtendimentos()+1);
        alunoRepository.save(aluno);
        pedagogoRepository.save(pedagogo);
    }
}
