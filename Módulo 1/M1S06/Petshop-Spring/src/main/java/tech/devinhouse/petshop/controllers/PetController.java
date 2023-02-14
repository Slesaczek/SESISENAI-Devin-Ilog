package main.java.tech.devinhouse.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.java.tech.devinhouse.petshop.models.Pet;
import main.java.tech.devinhouse.petshop.services.PetService;

import java.util.List;

@RestController
@RequestMapping(value = "pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> get() {
        return petService.findAll();
    }

    @PostMapping
    public Pet post(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @PutMapping
    public Pet put(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @DeleteMapping
    public boolean delete(Integer id) {
        return petService.delete(id);
    }

}
