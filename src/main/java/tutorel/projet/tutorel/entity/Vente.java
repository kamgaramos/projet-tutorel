package tutorel.projet.tutorel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventes")
public class Vente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "produit_id", nullable = false)
  private Long produitId;

  @Column(name = "pharmacie_id", nullable = false)
  private Long pharmacieId;

  private Integer quantite;

  private LocalDate dateVente = LocalDate.now();

  // JPA auto create tables
}
