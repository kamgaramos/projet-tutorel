package tutorel.projet.tutorel.dto;

import lombok.Data;
import tutorel.projet.tutorel.entity.Role;

@Data
public class UserResponseDTO {
  private Long id;
  private String email;
  private String nom;
  private Role role;
  private Long pharmacieId;
}
