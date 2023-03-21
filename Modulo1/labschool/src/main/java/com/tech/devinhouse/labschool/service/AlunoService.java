package com.tech.devinhouse.labschool.service;

import com.tech.devinhouse.labschool.exception.RegistroExistenteException;
import com.tech.devinhouse.labschool.exception.RegistroNaoEncontradoException;
import com.tech.devinhouse.labschool.model.Aluno;
import com.tech.devinhouse.labschool.model.SituacaoMatriculaAluno;
import com.tech.devinhouse.labschool.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    private ModelMapper mapper;

    public Aluno criar(Aluno aluno) {
        if (alunoRepository.existsAlunoByCpf(aluno.getCpf()))
            throw new RegistroExistenteException(Aluno.class.getSimpleName(), aluno.getCodigo());
        aluno.setAtendimento(0);
        alunoRepository.save(aluno);
        return aluno;
    }

    public Aluno salvar(Aluno aluno) {
        Optional<Aluno> alunoOpt = alunoRepository.findByCpf(aluno.getCpf());
        if (!alunoOpt.isEmpty())
            throw new RegistroExistenteException(Aluno.class.getSimpleName(), aluno.getCodigo());
        aluno = alunoRepository.save(aluno);
        return aluno;
    }

    public void excluir(Integer codigo) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(codigo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", String.valueOf(codigo));
        alunoRepository.deleteById(codigo);
    }

    public Aluno consultar(Long cpf) {
        boolean existe = alunoRepository.existsAlunoByCpf(Long.valueOf(cpf));
        if (!existe)
            throw new RegistroNaoEncontradoException("Aluno", Math.toIntExact(cpf));
        Optional<Aluno> alunoOpt = alunoRepository.findByCpf(cpf);
        Aluno aluno = alunoOpt.get();
        return aluno;
    }


    public Aluno consultar(Integer codigo) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(codigo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", String.valueOf(codigo));
        Aluno aluno = alunoOpt.get();
        return aluno;
    }


    public List<Aluno> consultar() {

        return alunoRepository.findAll();
    }


    public List<Aluno> consultar(String situacao) {
        List<Aluno> alunos = alunoRepository.findAll();
        if(situacao == null){
            return alunos;
        }
        List<Aluno> listaFiltrada = new ArrayList<>();
        for (Aluno aluno: alunos){
            if(aluno.getSituacao().toString().equals(situacao)){
                listaFiltrada.add(aluno);
            }
        }
        return listaFiltrada;
    }


    public Aluno alterarSituacaoMatricula(Integer codigo, SituacaoMatriculaAluno situacaoMatriculaAluno) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(codigo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", String.valueOf(codigo));
        Aluno aluno = alunoOpt.get();
        aluno.setSituacao(situacaoMatriculaAluno);
        alunoRepository.save(aluno);
        return aluno;
    }
}
