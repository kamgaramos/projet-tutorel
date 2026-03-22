package tutorel.projet.tutorel.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class PrevisionResponseDTO {
  private List<Double> previsionsMensuelles;
  private List<PicCreuxDTO> picsCreux;
  private Double demandePrevue;
  private Double quantiteCommander;
  private LocalDate dateCommandeIdeale;
}
