package tutorel.projet.tutorel.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pharmacies")
public class Pharmacie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nom;

  // Exemples: Pharma1_Akwa, Pharma2_Bonaberi, etc.
}
