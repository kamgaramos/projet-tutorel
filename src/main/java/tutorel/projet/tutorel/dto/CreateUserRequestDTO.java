package tutorel.projet.tutorel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tutorel.projet.tutorel.entity.Role;

@Data
public class CreateUserRequestDTO {
  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String nom;

  @NotBlank
  private String password;

  @NotNull
  private Role role;

  private Long pharmacieId; // required for PHARMACIEN
}
