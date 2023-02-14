package tech.devinhouse.devgram.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devgram.model.Perfil;
import tech.devinhouse.devgram.service.PerfilService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequestMapping("api/v1/perfis")
@AllArgsConstructor
public class PerfilController {

    private PerfilService service;

    @GetMapping
    public ResponseEntity<List<Perfil>> listar() {
        List<Perfil> perfis = service.consultar();
        return ResponseEntity.ok(perfis);
    }

    @GetMapping("{nome}")
    public ResponseEntity<Perfil> listar(@PathVariable("nome") String nome) {
        Perfil perfil = service.consultar(nome);
        return ResponseEntity.ok(perfil);
    }

}



