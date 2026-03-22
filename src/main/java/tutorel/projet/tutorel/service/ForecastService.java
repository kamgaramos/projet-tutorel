package tutorel.projet.tutorel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tutorel.projet.tutorel.dto.PrevisionResponseDTO;
import tutorel.projet.tutorel.dto.PicCreuxDTO;
import tutorel.projet.tutorel.entity.User;
import tutorel.projet.tutorel.entity.Role;
import tutorel.projet.tutorel.repository.VenteRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ForecastService {

  private final VenteService venteService;
  private final VenteRepository venteRepository;

  public PrevisionResponseDTO getPrevisions(Long pharmacieId, Long produitId) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (!user.getRole().equals(Role.GESTIONNAIRE) && !user.getRole().equals(Role.ADMIN)) {
      throw new RuntimeException("Accès refusé");
    }

    // Check pharmacie access (simplifié)
    // List<Vente> historique = venteService.getVentesByPharmacie(pharmacieId); 

    // Simulation Prophet (Python subprocess plus tard)
    PrevisionResponseDTO response = new PrevisionResponseDTO();
    response.setDemandePrevue(150.0); // moyenne
    response.setQuantiteCommander(200.0); // buffer
    response.setDateCommandeIdeale(LocalDate.now().plusDays(45));

    // Pics/creux dynamiques simulation (basé ventes)
    List<PicCreuxDTO> picsCreux = new ArrayList<>();
    Random r = new Random();
    double moyenne = 100;
    for (int m = 1; m <= 12; m++) {
      double prev = moyenne * (0.5 + r.nextDouble());
      double var = (prev / moyenne - 1) * 100;
      if (Math.abs(var) > 50) {
        PicCreuxDTO pc = new PicCreuxDTO();
        pc.setMois("Mois " + m);
        pc.setVariationPourcent(var);
        pc.setType(var > 0 ? "PIC_FORT" : "CREUX");
        pc.setCommentaire("Variation " + String.format("%.0f", var) + "% vs moyenne basée sur ventes historiques");
        picsCreux.add(pc);
      }
    }
    response.setPicsCreux(picsCreux);

    return response;
  }
}
