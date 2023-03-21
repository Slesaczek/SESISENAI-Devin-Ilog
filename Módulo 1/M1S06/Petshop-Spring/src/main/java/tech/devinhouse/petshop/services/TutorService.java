package main.java.tech.devinhouse.petshop.services;

import main.java.tech.devinhouse.petshop.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.tech.devinhouse.petshop.models.*;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }

    public boolean delete(Integer id) {
        return tutorRepository.delete(id);
    }

}
