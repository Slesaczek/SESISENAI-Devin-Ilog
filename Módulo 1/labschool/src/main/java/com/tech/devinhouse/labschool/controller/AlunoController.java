package com.tech.devinhouse.labschool.controller;


import com.tech.devinhouse.labschool.dto.AlunoRequest;
import com.tech.devinhouse.labschool.dto.AlunoResponse;
import com.tech.devinhouse.labschool.dto.SituacaoMatriculaRequest;
import com.tech.devinhouse.labschool.model.Aluno;
import com.tech.devinhouse.labschool.model.SituacaoMatriculaAluno;
import com.tech.devinhouse.labschool.service.AlunoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
public class AlunoController {

    private ModelMapper mapper;
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> consultar(
            @RequestParam (value = "situacao", required = false)
            @Pattern(regexp = "ATIVO|IRREGULAR|ATENDIMENTO_PEDAGOGICO|INATIVO", message = "{campo.invalido}" ) String situacao){
        List<Aluno> alunos = service.consultar(situacao);
        List<AlunoResponse> resp = new ArrayList<>();
        for (Aluno aluno : alunos) {
            AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
            resp.add(alunoResponse);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<AlunoResponse> consultar(@PathVariable("codigo")Integer codigo){
        Aluno aluno = service.consultar(codigo);
        AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(alunoResponse);

    }

    @DeleteMapping("{codigo}")
    public ResponseEntity excluir(@PathVariable("codigo") Integer codigo){
        service.excluir(codigo);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@RequestBody @Valid AlunoRequest request) {
        Aluno aluno = mapper.map(request, Aluno.class);
        aluno = service.salvar(aluno);
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp);
    }


    @PutMapping("{codigo}")
    public ResponseEntity<AlunoResponse> atualizarSituacao(@PathVariable("codigo")Integer codigo, @RequestBody @Valid SituacaoMatriculaRequest request){
        Aluno aluno = service.alterarSituacaoMatricula(codigo, SituacaoMatriculaAluno.valueOf(request.getSituacao()));
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(resp);

    }




}
