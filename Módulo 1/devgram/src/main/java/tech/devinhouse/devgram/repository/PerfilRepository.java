package tech.devinhouse.devgram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devgram.model.Perfil;


@Repository
public interface PerfilRepository extends JpaRepository<Perfil, String> {
}

