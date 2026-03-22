package tutorel.projet.tutorel.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tutorel.projet.tutorel.entity.Role;
import tutorel.projet.tutorel.entity.User;
import tutorel.projet.tutorel.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    if (userRepository.count() == 0) {
      // ADMIN
      User admin = User.builder()
        .email("admin@pharma.cm")
        .nom("Admin Réseau")
        .password(passwordEncoder.encode("admin123"))
        .role(Role.ADMIN)
        .build();
      userRepository.save(admin);

      // GESTIONNAIRE
      User gestionnaire = User.builder()
        .email("gestion@pharma.cm")
        .nom("Gestionnaire")
        .password(passwordEncoder.encode("gestion123"))
        .role(Role.GESTIONNAIRE)
        .build();
      userRepository.save(gestionnaire);

      // PHARMACIEN Pharma1
      User pharm1 = User.builder()
        .email("pharm1@pharma.cm")
        .nom("Pharm Akwa")
        .password(passwordEncoder.encode("pharm123"))
        .role(Role.PHARMACIEN)
        .pharmacieId(1L)
        .build();
      userRepository.save(pharm1);
    }
  }
}
