package tech.devinhouse.m01s06spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import tech.devinhouse.m01s06spring.models.Pessoa;
import tech.devinhouse.m01s06spring.repositories.PessoaRepository;

import java.util.List;

public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Integer id){
        return pessoaRepository.findById(id);
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }


}
