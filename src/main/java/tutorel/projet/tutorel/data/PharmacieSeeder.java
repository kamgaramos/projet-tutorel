package tutorel.projet.tutorel.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tutorel.projet.tutorel.entity.Pharmacie;
import tutorel.projet.tutorel.repository.PharmacieRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PharmacieSeeder implements CommandLineRunner {

  private final PharmacieRepository pharmacieRepository;

  @Override
  public void run(String... args) throws Exception {
    if (pharmacieRepository.count() == 0) {
      pharmacieRepository.save(Pharmacie.builder().nom("Pharma1_Akwa").build());
      pharmacieRepository.save(Pharmacie.builder().nom("Pharma2_Bonaberi").build());
      pharmacieRepository.save(Pharmacie.builder().nom("Pharma3_Centre").build());
      pharmacieRepository.save(Pharmacie.builder().nom("Pharma4_Deido").build());
    }
  }
}
