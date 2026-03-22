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
}</xai:function_call}



<xai:function_call name="create_file">
<parameter name="absolute_path">src/main/java/tutorel/projet/tutorel/repository/UserRepository.java
