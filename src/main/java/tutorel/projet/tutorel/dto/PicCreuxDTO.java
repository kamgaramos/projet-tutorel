package tutorel.projet.tutorel.dto;

import lombok.Data;

@Data
public class PicCreuxDTO {
  private String mois;
  private Double variationPourcent;
  private String type; // PIC_FORT / CREUX
  private String commentaire;
}
