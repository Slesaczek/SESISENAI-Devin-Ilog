package tech.devinhouse.veiculos.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.devinhouse.veiculos.exception.FalhaExclusaoVeiculoComMultasException;
import tech.devinhouse.veiculos.exception.RegistroExistenteException;
import tech.devinhouse.veiculos.exception.RegistroNaoEncontradoException;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {

    @Mock
    private VeiculoRepository repo;

    @InjectMocks
    private VeiculoService service;

    @Test
    @DisplayName("Quando placa já cadastrada, deve retornar erro")
    void inserir_erro() {
        var veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        Mockito.when(repo.existsById(Mockito.anyString())).thenReturn(true);
        assertThrows(RegistroExistenteException.class, () -> service.inserir(veiculo));
    }

    @Test
    @DisplayName("Quando placa nao cadastrada, deve retornar veiculo cadastrado")
    void inserir_sucesso() {
        var veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        Mockito.when(repo.existsById(Mockito.anyString())).thenReturn(false);
        Mockito.when(repo.save(Mockito.any(Veiculo.class))).thenReturn(veiculo);
        var resultado = service.inserir(veiculo);
        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Quando sem registros cadastrados, deve retornar lista vazia")
    void listar_vazio() {
        List<Veiculo> resultado = service.listar();
        assertTrue(resultado.isEmpty());
    }

    @Test
    @DisplayName("Quando contem registros cadastrados, deve retornar lista com registros")
    void listar() {
        var registros = List.of(
                new Veiculo("ABC-123", "carro", "azul", 2020),
                new Veiculo("ZXC-456", "caminhao", "prata", 2022)
        );
        Mockito.when(repo.findAll()).thenReturn(registros);
        List<Veiculo> resultado = service.listar();
        assertFalse(resultado.isEmpty());
        assertEquals(registros.size(), resultado.size());
    }

    @Test
    @DisplayName("Quando nao tem a placa cadastrada, deve lancar excecao")
    void obter_erro() {
        Mockito.when(repo.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> service.obter("AAA2222"));
    }

    @Test
    @DisplayName("Quando tem a placa cadastrada, deve retornar o respectivo veiculo")
    void obter() {
        Mockito.when(repo.findById(Mockito.anyString())).thenReturn(Optional.of(new Veiculo()));
        var resultado = service.obter("AAA111");
        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Quando placa nao cadastrada, deve lancar excecao")
    void excluir_naoExistente() {
        Mockito.when(repo.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> service.excluir("AAA2222"));
    }

    @Test
    @DisplayName("Quando veiculo possui multas, deve lancar excecao")
    void excluir_multas() {
        var veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        veiculo.setQtdMultas(1);
        Mockito.when(repo.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        assertThrows(FalhaExclusaoVeiculoComMultasException.class, () -> service.excluir(veiculo.getPlaca()));
    }

    @Test
    @DisplayName("Quando placa cadastrada e sem multas, deve excluir veiculo")
    void excluir() {
        var veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        Mockito.when(repo.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        assertDoesNotThrow(() -> service.excluir(veiculo.getPlaca()));
    }

    @Test
    @DisplayName("Quando veiculo nao cadastrado, deve lancar excecao")
    void adicionarMulta_naoExistente() {
        Mockito.when(repo.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> service.adicionarMulta("AAA2222"));
    }

    @Test
    @DisplayName("Quando veiculo cadastrado, deve incrementar a quantidade de multas")
    void adicionarMulta() {
        var veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        Mockito.when(repo.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        var resultado = service.adicionarMulta(veiculo.getPlaca());
        assertEquals(1, veiculo.getQtdMultas());
    }

}