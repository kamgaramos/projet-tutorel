package tutorel.projet.tutorel.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;\nimport java.util.List;\nimport tutorel.projet.tutorel.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

  @Query("SELECT u FROM User u WHERE u.pharmacieId = :pharmacieId")
  List<User> findByPharmacieId(@Param("pharmacieId") Long pharmacieId);
}
