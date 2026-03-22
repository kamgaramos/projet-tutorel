package tutorel.projet.tutorel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tutorel.projet.tutorel.dto.CreateUserRequestDTO;
import tutorel.projet.tutorel.dto.UserResponseDTO;
import tutorel.projet.tutorel.entity.User;
import tutorel.projet.tutorel.mapper.UserMapper;
import tutorel.projet.tutorel.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  public UserResponseDTO save(CreateUserRequestDTO dto) {
    User user = userMapper.toEntity(dto);
    user.setPassword(passwordEncoder.encode(dto.getPassword()));
    User saved = userRepository.save(user);
    return userMapper.toDto(saved);
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public List<UserResponseDTO> findAll() {
    return userRepository.findAll().stream()
        .map(userMapper::toDto)
        .collect(Collectors.toList());
  }
}</xai:function_call?>

<xai:function_call name="create_file">
<parameter name="absolute_path">src/main/java/tutorel/projet/tutorel/controller/AuthController.java
