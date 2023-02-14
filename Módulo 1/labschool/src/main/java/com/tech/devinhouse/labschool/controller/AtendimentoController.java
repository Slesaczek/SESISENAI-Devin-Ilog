package com.tech.devinhouse.labschool.controller;

import com.tech.devinhouse.labschool.dto.AlunoResponse;
import com.tech.devinhouse.labschool.dto.AtendimentoRequest;
import com.tech.devinhouse.labschool.dto.AtendimentoResponse;
import com.tech.devinhouse.labschool.dto.PedagogoResponse;
import com.tech.devinhouse.labschool.model.Aluno;
import com.tech.devinhouse.labschool.model.Pedagogo;
import com.tech.devinhouse.labschool.service.AlunoService;
import com.tech.devinhouse.labschool.service.AtendimentoService;
import com.tech.devinhouse.labschool.service.PedagogoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor
public class AtendimentoController {

    private AlunoService alunoService;

    private AtendimentoService service;

    private ModelMapper mapper;

    private PedagogoService pedagogoService;

    @PutMapping
    public ResponseEntity<AtendimentoResponse> atender(@RequestBody @Valid AtendimentoRequest request){
        service.atendimento(request.getCodigoAluno(), request.getCodigoPedagogo());
        Aluno aluno = alunoService.consultar(request.getCodigoAluno());
        Pedagogo pedagogo = pedagogoService.consultar(request.getCodigoPedagogo());
        AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
        PedagogoResponse pedagogosResponse = mapper.map(pedagogo, PedagogoResponse.class);
        AtendimentoResponse atendimentoResponse = new AtendimentoResponse(alunoResponse, pedagogosResponse);
        return ResponseEntity.ok(atendimentoResponse);

    }
}
