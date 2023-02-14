package tech.devinhouse.m01s09ex.controllers;

import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s09ex.models.Cliente;
import tech.devinhouse.m01s09ex.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> get() {
        return clienteService.buscar();
    }

    @PostMapping
    public Cliente post(@RequestBody Cliente cliente) throws Exception {
        return clienteService.salvar(cliente);
    }

    @PutMapping
    public Cliente put(@RequestBody Cliente cliente) throws Exception {
        return clienteService.salvar(cliente);
    }

    @DeleteMapping
    public boolean delete(Integer id) {
        return clienteService.apagar(id);
    }

}
