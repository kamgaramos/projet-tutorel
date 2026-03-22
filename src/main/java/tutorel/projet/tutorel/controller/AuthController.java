package tutorel.projet.tutorel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import tutorel.projet.tutorel.dto.AuthRequestDTO;
import tutorel.projet.tutorel.dto.AuthResponseDTO;
import tutorel.projet.tutorel.config.JwtService;
import tutorel.projet.tutorel.mapper.UserMapper;
import tutorel.projet.tutorel.security.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;
  private final UserDetailsServiceImpl userDetailsService;
  private final UserMapper userMapper;

  @PostMapping("/login")
  public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    var user = userDetailsService.loadUserByUsername(request.getEmail()); // User entity
    var jwtToken = jwtService.generateToken(userDetails);
    AuthResponseDTO response = new AuthResponseDTO();
    response.setToken(jwtToken);
    response.setEmail(user.getEmail());
    response.setRole(user.getRole());
    response.setPharmacieId(user.getPharmacieId());
    return ResponseEntity.ok(response);
  }
}
