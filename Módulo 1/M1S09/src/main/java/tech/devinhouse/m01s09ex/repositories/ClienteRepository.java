package tech.devinhouse.m01s09ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s09ex.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByCpfCnpj(String cpfCnpj);

    boolean existsByIdNotAndCpfCnpj(Integer id, String cpfCnpj);

}
