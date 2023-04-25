package tech.devinhouse.veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.veiculos.exception.FalhaExclusaoVeiculoComMultasException;
import tech.devinhouse.veiculos.exception.RegistroExistenteException;
import tech.devinhouse.veiculos.exception.RegistroNaoEncontradoException;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    public Veiculo inserir(Veiculo veiculo) {
        boolean existe = repo.existsById(veiculo.getPlaca());
        if (existe)
            throw new RegistroExistenteException();
        veiculo = repo.save(veiculo);
        return veiculo;
    }

    public List<Veiculo> listar() {
        return repo.findAll();
    }

    public Veiculo obter(String placa) {
        return repo.findById(placa)
                .orElseThrow(RegistroNaoEncontradoException::new);
    }

    public void excluir(String placa) {
        Veiculo veiculo = repo.findById(placa)
                .orElseThrow(RegistroNaoEncontradoException::new);
        if (veiculo.getQtdMultas() != 0)
            throw new FalhaExclusaoVeiculoComMultasException();
        repo.deleteById(placa);
    }

    public Veiculo adicionarMulta(String placa) {
        Veiculo veiculo = repo.findById(placa)
                .orElseThrow(RegistroNaoEncontradoException::new);
        int qtd = veiculo.getQtdMultas() + 1;
        veiculo.setQtdMultas(qtd);
        veiculo = repo.save(veiculo);
        return veiculo;
    }
}
