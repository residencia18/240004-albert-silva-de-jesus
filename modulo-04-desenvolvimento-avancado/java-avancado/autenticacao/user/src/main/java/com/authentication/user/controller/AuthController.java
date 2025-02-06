package com.authentication.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.user.dto.LoginRequest;
import com.authentication.user.dto.LoginResponse;
import com.authentication.user.dto.RegisterRequest;
import com.authentication.user.dto.RegisterResponse;
import com.authentication.user.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
    authenticationService.register(registerRequest);
    return new RegisterResponse("User registered successfully");
  }

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    return authenticationService.login(loginRequest);
  }
}
