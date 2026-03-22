package tutorel.projet.tutorel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tutorel.projet.tutorel.dto.CreateUserRequestDTO;
import tutorel.projet.tutorel.dto.UserResponseDTO;
import tutorel.projet.tutorel.service.UserService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.findAll());
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody CreateUserRequestDTO dto) {
    return ResponseEntity.ok(userService.save(dto));
  }
}
