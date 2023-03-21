package tech.devinhouse.m01s09ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s09ex.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    boolean existsBySku(String sku);

    boolean existsByIdNotAndSku(Integer id, String sku);
}
