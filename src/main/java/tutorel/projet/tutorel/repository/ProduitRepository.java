package tutorel.projet.tutorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorel.projet.tutorel.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
