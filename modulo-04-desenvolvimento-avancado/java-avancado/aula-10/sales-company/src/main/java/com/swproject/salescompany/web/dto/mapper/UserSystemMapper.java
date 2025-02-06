package com.swproject.salescompany.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.swproject.salescompany.entities.UserSystem;
import com.swproject.salescompany.web.dto.UserSystemResponseDto;
import com.swproject.salescompany.web.dto.form.UserSystemForm;

public class UserSystemMapper {

  public static UserSystem toUsuario(UserSystemForm createDto) {
    return new ModelMapper().map(createDto, UserSystem.class);

  }

  public static UserSystemResponseDto toDto(UserSystem usuario) {
    String role = usuario.getRole().name().substring("ROLE_".length());

    PropertyMap<UserSystem, UserSystemResponseDto> props = new PropertyMap<UserSystem, UserSystemResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setUsername(source.getUsername());
        map().setRole(role);
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(usuario, UserSystemResponseDto.class);
  }

  public static List<UserSystemResponseDto> toListDto(List<UserSystem> usuarios) {
    return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());
  }
}
