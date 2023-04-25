package tech.devinhouse.veiculos.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.veiculos.dto.VeiculoRequest;
import tech.devinhouse.veiculos.dto.VeiculoResponse;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.service.VeiculoService;
import java.util.*;

import java.net.URI;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculoService service;

    private ModelMapper modelMapper = new ModelMapper(); // criando instancia pq só será usado aquo

    @PostMapping
    public ResponseEntity<VeiculoResponse> adicionar(@RequestBody @Valid VeiculoRequest request) {
        Veiculo veiculo = modelMapper.map(request, Veiculo.class);
        veiculo = service.inserir(veiculo);
        var resp = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.created(URI.create(veiculo.getPlaca())).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> consultar() {
        List<Veiculo> veiculos = service.listar();
        List<VeiculoResponse> veiculosResp = veiculos.stream()
                .map(v -> modelMapper.map(v, VeiculoResponse.class)).toList();
        return ResponseEntity.ok(veiculosResp);
    }

    @GetMapping("{placa}")
    public ResponseEntity<VeiculoResponse> consultar(@PathVariable String placa) {
        Veiculo veiculo = service.obter(placa);
        VeiculoResponse resp = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("{placa}")
    public ResponseEntity excluir(@PathVariable String placa) {
        service.excluir(placa);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{placa}/multas")
    public ResponseEntity multar(@PathVariable String placa) {
        var veiculo = service.adicionarMulta(placa);
        var resp = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.ok(resp);
    }

}
