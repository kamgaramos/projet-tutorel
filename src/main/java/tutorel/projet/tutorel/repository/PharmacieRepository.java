package tutorel.projet.tutorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorel.projet.tutorel.entity.Pharmacie;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
}
