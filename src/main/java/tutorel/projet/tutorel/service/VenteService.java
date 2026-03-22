package tutorel.projet.tutorel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tutorel.projet.tutorel.dto.CreateVenteRequestDTO;
import tutorel.projet.tutorel.dto.VenteResponseDTO;
import tutorel.projet.tutorel.entity.User;
import tutorel.projet.tutorel.entity.Vente;
import tutorel.projet.tutorel.repository.ProduitRepository;
import tutorel.projet.tutorel.repository.UserRepository;
import tutorel.projet.tutorel.repository.VenteRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenteService {

  private final VenteRepository venteRepository;
  private final UserRepository userRepository;
  private final ProduitRepository produitRepository;

  public VenteResponseDTO createVente(CreateVenteRequestDTO dto) {
    // RBAC: Check user pharmacie_id
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (user.getPharmacieId() == null || !user.getRole().equals(Role.PHARMACIEN)) {
      throw new RuntimeException("Accès refusé: PHARMACIEN seulement");
    }

    // Check produit exists
    if (!produitRepository.existsById(dto.getProduitId())) {
      throw new RuntimeException("Produit introuvable");
    }

    Vente vente = Vente.builder()
      .produitId(dto.getProduitId())
      .pharmacieId(user.getPharmacieId())
      .quantite(dto.getQuantite())
      .dateVente(dto.getDateVente() != null ? dto.getDateVente() : LocalDate.now())
      .build();
    Vente saved = venteRepository.save(vente);
    return mapToDto(saved);
  }

  public List<VenteResponseDTO> getVentesByPharmacie(Long pharmacieId) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (!user.getPharmacieId().equals(pharmacieId)) {
      throw new RuntimeException("Accès refusé à cette pharmacie");
    }
    return venteRepository.findByPharmacieId(pharmacieId).stream()
      .map(this::mapToDto)
      .collect(Collectors.toList());
  }

  private VenteResponseDTO mapToDto(Vente vente) {
    VenteResponseDTO dto = new VenteResponseDTO();
    dto.setId(vente.getId());
    dto.setProduitId(vente.getProduitId());
    dto.setPharmacieId(vente.getPharmacieId());
    dto.setQuantite(vente.getQuantite());
    dto.setDateVente(vente.getDateVente());
    return dto;
  }
}
