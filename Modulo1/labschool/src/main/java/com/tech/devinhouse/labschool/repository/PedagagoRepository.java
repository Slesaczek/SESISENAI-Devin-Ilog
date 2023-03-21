package com.tech.devinhouse.labschool.repository;

import com.tech.devinhouse.labschool.model.Pedagogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedagagoRepository extends JpaRepository<Pedagogo, Integer> {
    Optional<Pedagogo> findByCpf(long cpf);

}
