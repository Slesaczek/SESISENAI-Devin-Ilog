package com.tech.devinhouse.labschool.controller;

import com.tech.devinhouse.labschool.dto.ProfessorResponse;
import com.tech.devinhouse.labschool.model.Professor;
import com.tech.devinhouse.labschool.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/professores")
@AllArgsConstructor
public class ProfessorController {

    private ModelMapper mapper;
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> listar() {
        List<Professor> professores = service.consultar();
        List<ProfessorResponse> resp = new ArrayList<>();
        for (Professor professor : professores) {
            ProfessorResponse professorResponse = mapper.map(professor, ProfessorResponse.class);
            resp.add(professorResponse);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> criar(@RequestBody @Valid ProfessorResponse request) {
        Professor professor = mapper.map(request, Professor.class);
        professor = service.salvar(professor);
        ProfessorResponse resp = mapper.map(professor, ProfessorResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp);
    }


}
