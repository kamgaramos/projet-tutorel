package tutorel.projet.tutorel.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateVenteRequestDTO {
  @NotNull
  private Long produitId;

  @Min(1)
  private Integer quantite = 1;

  private LocalDate dateVente;
}
