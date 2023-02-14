package tech.devinhouse.m01s06spring.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String get(String nome) {
        if(StringUtils.isBlank(nome)) {
            return "Servidor rodando!";
        }
        return nome;

    }
}

