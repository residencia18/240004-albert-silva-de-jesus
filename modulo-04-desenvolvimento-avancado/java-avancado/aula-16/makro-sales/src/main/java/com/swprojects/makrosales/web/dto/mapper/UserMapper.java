package com.swprojects.makrosales.web.dto.mapper;

import org.springframework.stereotype.Service;

import com.swprojects.makrosales.entities.User;
import com.swprojects.makrosales.web.dto.RegisterRequestDto;

@Service
public class UserMapper {

  public User fromRegisterRequest(RegisterRequestDto registerRequest) {
    return User.builder()
        .email(registerRequest.email())
        .username(registerRequest.username())
        .password(registerRequest.password())
        .role("ROLE_USER")
        .build();
  }
}