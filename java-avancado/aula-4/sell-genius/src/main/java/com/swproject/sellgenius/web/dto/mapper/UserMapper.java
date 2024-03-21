package com.swproject.sellgenius.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.swproject.sellgenius.entities.Usuario;
import com.swproject.sellgenius.web.dto.UserResponseDto;
import com.swproject.sellgenius.web.dto.form.UserForm;

public class UserMapper {

  public static Usuario toUser(UserForm createDto) {
    return new ModelMapper().map(createDto, Usuario.class);

  }

  public static UserResponseDto toDto(Usuario user) {
    PropertyMap<Usuario, UserResponseDto> props = new PropertyMap<Usuario, UserResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setUsername(source.getUsername());
        map().setPerfilTipo(source.getPerfilTipo());
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(user, UserResponseDto.class);
  }

  public static List<UserResponseDto> toListDto(List<Usuario> users) {
    return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
  }
}
