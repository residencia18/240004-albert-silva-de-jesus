package com.persistencia.pratica13.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.web.dto.UsuarioResponseDto;
import com.persistencia.pratica13.web.dto.form.UsuarioForm;

public class UsuarioMapper {

  public static Usuario toUsuario(UsuarioForm createDto) {
    return new ModelMapper().map(createDto, Usuario.class);
  }

  public static UsuarioResponseDto toDto(Usuario usuario) {
    String role = usuario.getRole().name().substring("ROLE_".length());
    PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
      @Override
      protected void configure() {
        map().setRole(role);
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(usuario, UsuarioResponseDto.class);
  }

  public static List<UsuarioResponseDto> toListDto(List<Usuario> usuarios) {
    return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());
  }
}