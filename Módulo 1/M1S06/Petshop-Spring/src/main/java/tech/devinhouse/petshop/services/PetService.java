package main.java.tech.devinhouse.petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.tech.devinhouse.petshop.models.Pet;
import main.java.tech.devinhouse.petshop.models.Tutor;
import main.java.tech.devinhouse.petshop.repositories.PetRepository;
import main.java.tech.devinhouse.petshop.repositories.TutorRepository;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public Pet save(Pet pet) {
        try {
            if (pet.getTutor().getId() != null) {
                Tutor tutor = tutorRepository.findById(pet.getTutor().getId());
                pet.setTutor(tutor);
            }
        } catch (Exception e) {
            pet.setTutor(null);
        }
        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public boolean delete(Integer id) {
        return petRepository.delete(id);
    }

}
