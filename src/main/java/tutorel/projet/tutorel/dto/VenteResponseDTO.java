package tutorel.projet.tutorel.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class VenteResponseDTO {
  private Long id;
  private Long produitId;
  private Long pharmacieId;
  private Integer quantite;
  private LocalDate dateVente;
}
