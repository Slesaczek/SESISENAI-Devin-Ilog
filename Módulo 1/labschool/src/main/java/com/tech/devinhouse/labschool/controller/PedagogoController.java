package com.tech.devinhouse.labschool.controller;

import com.tech.devinhouse.labschool.dto.PedagogoResponse;
import com.tech.devinhouse.labschool.model.Pedagogo;
import com.tech.devinhouse.labschool.service.PedagogoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pedagogos")
@AllArgsConstructor
public class PedagogoController {

    private ModelMapper mapper;
    private PedagogoService service;

    @GetMapping
    public ResponseEntity<List<PedagogoResponse>> listar() {
        List<Pedagogo> pedagogos = service.consultar();
        List<PedagogoResponse> resp = new ArrayList<>();
        for (Pedagogo pedagogo : pedagogos) {
            PedagogoResponse pedagogosResponse = mapper.map(pedagogo, PedagogoResponse.class);
            resp.add(pedagogosResponse);
        }
        return ResponseEntity.ok(resp);
    }

}
