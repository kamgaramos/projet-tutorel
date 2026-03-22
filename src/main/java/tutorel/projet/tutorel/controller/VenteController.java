package tutorel.projet.tutorel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tutorel.projet.tutorel.dto.CreateVenteRequestDTO;
import tutorel.projet.tutorel.dto.VenteResponseDTO;
import tutorel.projet.tutorel.service.VenteService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ventes")
@RequiredArgsConstructor
public class VenteController {

  private final VenteService venteService;

  @PostMapping
  @PreAuthorize("hasRole('PHARMACIEN')")
  public ResponseEntity<VenteResponseDTO> createVente(@Valid @RequestBody CreateVenteRequestDTO dto) {
    return ResponseEntity.ok(venteService.createVente(dto));
  }

  @GetMapping("/historique/{pharmacieId}")
  @PreAuthorize("hasRole('PHARMACIEN') or hasRole('GESTIONNAIRE') or hasRole('ADMIN')")
  public ResponseEntity<List<VenteResponseDTO>> getHistorique(@PathVariable Long pharmacieId) {
    return ResponseEntity.ok(venteService.getVentesByPharmacie(pharmacieId));
  }
}
