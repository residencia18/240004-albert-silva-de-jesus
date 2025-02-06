package com.authentication.user.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authentication.user.dto.LoginRequest;
import com.authentication.user.dto.LoginResponse;
import com.authentication.user.dto.RegisterRequest;
import com.authentication.user.entity.User;
import com.authentication.user.mapper.UserMapper;
import com.authentication.user.repository.UserRepository;
import com.authentication.user.security.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtProvider jwtProvider;
  private final UserMapper userMapper;

  public void register(RegisterRequest registerRequest) {
    User user = userMapper.fromRegisterRequest(registerRequest);// Usando o UserMapper para criar o objeto User
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.saveUser(user);
  }

  public LoginResponse login(LoginRequest loginRequest) {
    Authentication authenticate = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),
            loginRequest.password()));
    String token = jwtProvider.generateToken(authenticate);
    return new LoginResponse(token);
  }
}
