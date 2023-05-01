package tech.devinhouse.veiculos.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.veiculos.exception.FalhaExclusaoVeiculoComMultasException;
import tech.devinhouse.veiculos.exception.RegistroExistenteException;
import tech.devinhouse.veiculos.exception.RegistroNaoEncontradoException;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    public Veiculo inserir(Veiculo veiculo) {
        boolean existe = repo.existsById(veiculo.getPlaca());
        if (existe) {
            log.error("Veículo com placa já cadastrada: {}", veiculo.getPlaca());
            throw new RegistroExistenteException();
        }
        veiculo = repo.save(veiculo);
        return veiculo;
    }

    public List<Veiculo> listar() {
        return repo.findAll();
    }

    public Veiculo obter(String placa) {
        Optional<Veiculo> veiculoOpt = repo.findById(placa);
        if (veiculoOpt.isEmpty()) {
            log.error("Veiculo de placa {} nao encontrado na base de dados!", placa);
            throw new RegistroNaoEncontradoException();
        }
        return veiculoOpt.get();
    }

    public void excluir(String placa) {
        Optional<Veiculo> veiculoOpt = repo.findById(placa);
        if (veiculoOpt.isEmpty()) {
            log.error("Veiculo de placa {} nao encontrado na base de dados!", placa);
            throw new RegistroNaoEncontradoException();
        }
        Veiculo veiculo = veiculoOpt.get();
        if (veiculo.getQtdMultas() != 0) {
            log.error("Veiculo com multas e portanto nao pode ser excluído!");
            throw new FalhaExclusaoVeiculoComMultasException();
        }
        repo.deleteById(placa);
    }

    public Veiculo adicionarMulta(String placa) {
        Optional<Veiculo> veiculoOpt = repo.findById(placa);
        if (veiculoOpt.isEmpty()) {
            log.error("Veiculo de placa {} nao encontrado na base de dados!", placa);
            throw new RegistroNaoEncontradoException();
        }
        Veiculo veiculo = veiculoOpt.get();
        int qtd = veiculo.getQtdMultas() + 1;
        veiculo.setQtdMultas(qtd);
        veiculo = repo.save(veiculo);
        return veiculo;
    }
}
