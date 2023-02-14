package com.tech.devinhouse.labschool.service;

import com.tech.devinhouse.labschool.exception.RegistroExistenteException;
import com.tech.devinhouse.labschool.exception.RegistroNaoEncontradoException;
import com.tech.devinhouse.labschool.model.Pedagogo;
import com.tech.devinhouse.labschool.repository.PedagagoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedagogoService {

    private PedagagoRepository pedagagoRepository;
    public List<Pedagogo> consultar() {
        return pedagagoRepository.findAll();
    }

    public Pedagogo consultar(Integer codigo) {
        Optional<Pedagogo> pedagogoOpt = pedagagoRepository.findById(codigo);
        if (pedagogoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Pedagogo", String.valueOf(codigo));
        Pedagogo pedagogo = pedagogoOpt.get();
        return pedagogo;
    }

    public Pedagogo salvar(Pedagogo pedagogo) {
        Optional<Pedagogo> pedagogoOpt = pedagagoRepository.findByCpf(pedagogo.getCpf());
        if (!pedagogoOpt.isEmpty())
            throw new RegistroExistenteException(Pedagogo.class.getSimpleName(), pedagogo.getCodigo());
        pedagogo = pedagagoRepository.save(pedagogo);
        return pedagogo;
    }

}
