package tutorel.projet.tutorel.dto;

import lombok.Data;
import tutorel.projet.tutorel.entity.Role;

@Data
public class AuthResponseDTO {
  private String token;
  private String email;
  private Role role;
  private Long pharmacieId;
}
