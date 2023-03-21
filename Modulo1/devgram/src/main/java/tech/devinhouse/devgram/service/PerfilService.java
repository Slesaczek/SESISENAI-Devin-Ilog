package tech.devinhouse.devgram.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devgram.model.Perfil;
import tech.devinhouse.devgram.repository.PerfilRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PerfilService {

    private PerfilRepository repo;

    public List<Perfil> consultar() {
        return repo.findAll();
    }

    public Perfil consultar(String nome) {
        Optional<Perfil> perfilOpt = repo.findById(nome);
        if (((Optional<?>) perfilOpt).isPresent())
            return perfilOpt.get();
        throw new IllegalArgumentException("Nao existe perfil com este nome");
//        return perfilOpt.orElseThrow(() -> new IllegalArgumentException("Nao existe perfil com este nome"));
    }


}




