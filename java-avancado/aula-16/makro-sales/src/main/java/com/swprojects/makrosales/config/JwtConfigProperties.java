package com.swprojects.makrosales.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "jwt")
@EnableConfigurationProperties(JwtConfigProperties.class)
@Component
@Getter
@Setter
public class JwtConfigProperties {

  // @Value("${jwt.public.key}")
  private RSAPublicKey publicKey;

  // @Value("${jwt.private.key}")
  private RSAPrivateKey privateKey;
}