package com.example.crud_user.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.example.crud_user.entities.User;
import com.example.crud_user.web.dto.UserResponseDto;
import com.example.crud_user.web.dto.form.UserForm;

public class UserMapper {

  public static User toLeilao(UserForm createDto) {
    return new ModelMapper().map(createDto, User.class);
  }

  public static UserResponseDto toDto(User user) {
    PropertyMap<User, UserResponseDto> props = new PropertyMap<User, UserResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setName(source.getName());
        map().setEmail(source.getEmail());
        map().setPhone(source.getPhone());
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(user, UserResponseDto.class);
  }

  public static List<UserResponseDto> toListDto(List<User> users) {
    return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
  }
}
