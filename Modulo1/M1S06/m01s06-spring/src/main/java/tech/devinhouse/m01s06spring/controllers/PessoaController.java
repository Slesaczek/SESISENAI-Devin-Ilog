package tech.devinhouse.m01s06spring.controllers;


import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s06spring.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "pessoa")
public class PessoaController {

    private static List<Pessoa> pessoas = new ArrayList<>();

    @GetMapping
    public List<Pessoa> get() {
        return pessoas;
    }

    @PostMapping
    public Pessoa post(@RequestBody Pessoa pessoa) {
        pessoas.add(pessoa);
        return pessoa;
    }

    @PutMapping(path = "{id}")
    public Pessoa put(@PathVariable Integer id,@RequestBody Pessoa pessoa){
        Pessoa pessoaEditada = null;
        for (Pessoa p: pessoas) {
            if(p.getId() == id){
                pessoaEditada = p;
                break;
            }
        }
        if(pessoaEditada != null){
            pessoaEditada.setNome(pessoa.getNome());
            pessoaEditada.setIdade(pessoa.getIdade());
        }
        return pessoaEditada;
    }
}