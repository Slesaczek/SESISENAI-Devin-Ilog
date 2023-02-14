package com.tech.devinhouse.labschool.repository;

import com.tech.devinhouse.labschool.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    boolean existsAlunoByCpf(long cpf);

    Optional<Aluno> findByCpf(long cpf);


}
