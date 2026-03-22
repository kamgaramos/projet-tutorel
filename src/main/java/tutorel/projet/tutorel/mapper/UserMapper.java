package tutorel.projet.tutorel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tutorel.projet.tutorel.dto.CreateUserRequestDTO;
import tutorel.projet.tutorel.dto.UserResponseDTO;
import tutorel.projet.tutorel.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User toEntity(CreateUserRequestDTO dto);
  UserResponseDTO toDto(User user);
  User updateEntityFromDto(CreateUserRequestDTO dto, @MappingTarget User user);
}
