package tech.devinhouse.veiculos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import tech.devinhouse.veiculos.dto.VeiculoRequest;
import tech.devinhouse.veiculos.exception.FalhaExclusaoVeiculoComMultasException;
import tech.devinhouse.veiculos.exception.RegistroExistenteException;
import tech.devinhouse.veiculos.exception.RegistroNaoEncontradoException;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.service.VeiculoService;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class VeiculosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // classe que serializa/des-serializa objetos JSON

    private ModelMapper modelMapper = new ModelMapper();

    @MockBean  // mock para dependencias da classe de controller
    private VeiculoService service;

    @Test
    @DisplayName("Quando inclusao com placa jah existente, deve retornar erro")
    void incluir_jaCadastrado() throws Exception {
        Mockito.when(service.inserir(Mockito.any(Veiculo.class))).thenThrow(RegistroExistenteException.class);
        var req = new VeiculoRequest("ABC-123", "carro", "azul", 2020);
        String requestJson = objectMapper.writeValueAsString(req);
        mockMvc.perform(post("/api/veiculos")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())  // 409
                .andExpect(jsonPath("$.erro", containsStringIgnoringCase("Registro já cadastrado!")));
    }

    @Test
    @DisplayName("Quando inclusao com placa ainda nao cadastrada, deve retornar sucesso")
    void incluir_sucesso() throws Exception {
        VeiculoRequest req = new VeiculoRequest("ABC-123", "carro", "azul", 2020);
        Veiculo veiculo = modelMapper.map(req, Veiculo.class);
        String requestJson = objectMapper.writeValueAsString(req);
        Mockito.when(service.inserir(Mockito.any(Veiculo.class))).thenReturn(veiculo);
        mockMvc.perform(post("/api/veiculos")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())  // 201
                .andExpect(jsonPath("$.placa", is(notNullValue())))
                .andExpect(jsonPath("$.placa", is(veiculo.getPlaca())));
    }

    @Test
    @DisplayName("Quando nao tem registros, deve retornar lista vazia")
    void consultar_vazio() throws Exception {
        mockMvc.perform(get("/api/veiculos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    @DisplayName("Quando tem registros, deve retornar lista com veiculos")
    void consultar() throws Exception {
        var registros = List.of(
                new Veiculo("ABC-123", "carro", "azul", 2020),
                new Veiculo("ZXC-456", "caminhao", "prata", 2022)
        );
        Mockito.when(service.listar()).thenReturn(registros);
        mockMvc.perform(get("/api/veiculos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("Quando placa nao cadastrada, deve retornar erro")
    void consultarPorPlaca_naoEncontrada() throws Exception {
        Mockito.when(service.obter(Mockito.anyString())).thenThrow(RegistroNaoEncontradoException.class);
        mockMvc.perform(get("/api/veiculos/{placa}", "ABC123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Quando existe veiculo com a placa informada, deve retornar o veiculo")
    void consultarPorPlaca() throws Exception {
        var veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        Mockito.when(service.obter(Mockito.anyString())).thenReturn(veiculo);
        mockMvc.perform(get("/api/veiculos/{placa}", veiculo.getPlaca())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa", is(veiculo.getPlaca())));
    }

    @Test
    @DisplayName("Quando placa nao cadastrada, deve retornar erro")
    void excluir_naoEncontrado() throws Exception {
        Mockito.doThrow(RegistroNaoEncontradoException.class).when(service).excluir(Mockito.anyString());
        mockMvc.perform(delete("/api/veiculos/{placa}", "ABC123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Quando veiculo tem multa, deve retornar erro")
    void excluir_temMulta() throws Exception {
        Mockito.doThrow(FalhaExclusaoVeiculoComMultasException.class).when(service).excluir(Mockito.anyString());
        mockMvc.perform(delete("/api/veiculos/{placa}", "ABC123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Quando veiculo sem multas, deve excluir")
    void excluir() throws Exception {
        mockMvc.perform(delete("/api/veiculos/{placa}", "ABC123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Quando multa em placa nao cadastrada, deve retornar erro")
    void multar_naoEncontrado() throws Exception {
        Mockito.when(service.adicionarMulta(Mockito.anyString())).thenThrow(RegistroNaoEncontradoException.class);
        mockMvc.perform(put("/api/veiculos/{placa}/multas", "ABC123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Quando multa em placa cadastrada, deve retornar sucesso")
    void multar() throws Exception {
        var veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        veiculo.setQtdMultas(2);
        final int qtdMultasOriginal = veiculo.getQtdMultas();
        veiculo.setQtdMultas(veiculo.getQtdMultas() + 1 );
        Mockito.when(service.adicionarMulta(Mockito.anyString())).thenReturn(veiculo);
        mockMvc.perform(put("/api/veiculos/{placa}/multas", veiculo.getPlaca())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa", is(notNullValue())))
                .andExpect(jsonPath("$.qtdMultas", is(qtdMultasOriginal + 1)));
    }
}