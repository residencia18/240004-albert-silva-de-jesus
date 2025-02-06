package com.authentication.user.mapper;

import org.springframework.stereotype.Service;

import com.authentication.user.dto.RegisterRequest;
import com.authentication.user.entity.User;

@Service
public class UserMapper {

  public User fromRegisterRequest(RegisterRequest registerRequest) {
    return User.builder()
        .email(registerRequest.email())
        .username(registerRequest.username())
        .password(registerRequest.password())
        .role("ROLE_USER")
        .build();
  }
}