package tutorel.projet.tutorel.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tutorel.projet.tutorel.entity.Vente;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Long> {
  List<Vente> findByPharmacieId(Long pharmacieId);
  
  @Query("SELECT v FROM Vente v WHERE v.pharmacieId = :pharmacieId AND v.dateVente >= :debut AND v.dateVente <= :fin")
  List<Vente> findHistoriqueByPharmacieId(@Param("pharmacieId") Long pharmacieId, @Param("debut") LocalDate debut, @Param("fin") LocalDate fin);
}
</xai:function_call >

<xai:function_call name="create_file">
<parameter name="absolute_path">src/main/java/tutorel/projet/tutorel/dto/CreatePharmacieRequestDTO.java
