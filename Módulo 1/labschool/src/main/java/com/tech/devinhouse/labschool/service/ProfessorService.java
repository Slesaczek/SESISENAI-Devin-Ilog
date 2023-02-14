package com.tech.devinhouse.labschool.service;

import com.tech.devinhouse.labschool.exception.RegistroExistenteException;
import com.tech.devinhouse.labschool.model.Professor;
import com.tech.devinhouse.labschool.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {

    public ProfessorRepository professorRepository;

    public List<Professor> consultar() {
        return professorRepository.findAll();
    }

    public Professor salvar(Professor professor) {
        Optional<Professor> professorOpt = professorRepository.findById(professor.getCodigo());
        if (!professorOpt.isEmpty())
            throw new RegistroExistenteException(Professor.class.getSimpleName(), professor.getCodigo());
        professor = professorRepository.save(professor);
        return professor;
    }

}
