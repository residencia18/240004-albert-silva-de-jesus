package com.swprojects.salesforce.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swprojects.salesforce.entities.User;
import com.swprojects.salesforce.repositories.UserRepository;
import com.swprojects.salesforce.security.JwtProvider;
import com.swprojects.salesforce.web.dto.LoginRequestDto;
import com.swprojects.salesforce.web.dto.LoginResponseDto;
import com.swprojects.salesforce.web.dto.RegisterRequestDto;
import com.swprojects.salesforce.web.dto.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtProvider jwtProvider;
  private final UserMapper userMapper;

  public void register(RegisterRequestDto registerRequest) {
    User user = userMapper.fromRegisterRequest(registerRequest);// Usando o UserMapper para criar o objeto User
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.saveUser(user);
  }

  public LoginResponseDto login(LoginRequestDto loginRequest) {
    Authentication authenticate = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),
            loginRequest.password()));
    String token = jwtProvider.generateToken(authenticate);
    return new LoginResponseDto(token);
  }
}
