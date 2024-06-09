package com.swproject.tradein.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.swproject.tradein.entities.UserSystem;
import com.swproject.tradein.web.dto.UserSystemResponseDto;
import com.swproject.tradein.web.dto.form.UserSystemForm;

public class UserSystemMapper {

  public static UserSystem toUser(UserSystemForm createDto) {
    return new ModelMapper().map(createDto, UserSystem.class);

  }

  public static UserSystemResponseDto toDto(UserSystem user) {
    PropertyMap<UserSystem, UserSystemResponseDto> props = new PropertyMap<UserSystem, UserSystemResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setUsername(source.getUsername());
        map().setPerfilTipo(source.getPerfilTipo());
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(user, UserSystemResponseDto.class);
  }

  public static List<UserSystemResponseDto> toListDto(List<UserSystem> users) {
    return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
  }
}
