package tutorel.projet.tutorel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorel.projet.tutorel.dto.PrevisionResponseDTO;
import tutorel.projet.tutorel.service.ForecastService;

@RestController
@RequestMapping("/api/previsions")
@RequiredArgsConstructor
public class ForecastController {

  private final ForecastService forecastService;

  @GetMapping("/{pharmacieId}/{produitId}")
  @PreAuthorize("hasRole('GESTIONNAIRE') or hasRole('ADMIN')")
  public ResponseEntity<PrevisionResponseDTO> getPrevisions(@PathVariable Long pharmacieId, @PathVariable Long produitId) {
    return ResponseEntity.ok(forecastService.getPrevisions(pharmacieId, produitId));
  }
}
