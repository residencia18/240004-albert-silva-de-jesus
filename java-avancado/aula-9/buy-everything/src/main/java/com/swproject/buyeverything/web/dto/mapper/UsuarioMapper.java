package com.swproject.buyeverything.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.swproject.buyeverything.entities.Usuario;
import com.swproject.buyeverything.web.dto.UsuarioResponseDto;
import com.swproject.buyeverything.web.dto.form.UsuarioForm;

public class UsuarioMapper {

  public static Usuario toUser(UsuarioForm createDto) {
    return new ModelMapper().map(createDto, Usuario.class);

  }

  public static UsuarioResponseDto toDto(Usuario user) {
    PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setUsername(source.getUsername());
        map().setPerfilTipo(source.getPerfilTipo());
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(user, UsuarioResponseDto.class);
  }

  public static List<UsuarioResponseDto> toListDto(List<Usuario> users) {
    return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
  }
}
