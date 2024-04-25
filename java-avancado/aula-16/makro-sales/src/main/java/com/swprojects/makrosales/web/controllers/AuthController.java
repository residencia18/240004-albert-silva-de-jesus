package com.swprojects.makrosales.web.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swprojects.makrosales.services.AuthenticationService;
import com.swprojects.makrosales.web.dto.LoginRequestDto;
import com.swprojects.makrosales.web.dto.LoginResponseDto;
import com.swprojects.makrosales.web.dto.RegisterRequestDto;
import com.swprojects.makrosales.web.dto.RegisterResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public RegisterResponseDto register(@RequestBody RegisterRequestDto registerRequest) {
    authenticationService.register(registerRequest);
    return new RegisterResponseDto("User registered successfully");
  }

  @PostMapping("/login")
  public LoginResponseDto login(@RequestBody LoginRequestDto loginRequest) {
    return authenticationService.login(loginRequest);
  }
  
}
