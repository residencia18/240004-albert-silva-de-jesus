package br.com.residenciatic18.avaliacao.api.ap002.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.residenciatic18.avaliacao.api.ap002.entity.Token;
import br.com.residenciatic18.avaliacao.api.ap002.entity.UserSystem;
import br.com.residenciatic18.avaliacao.api.ap002.jwt.JwtToken;
import br.com.residenciatic18.avaliacao.api.ap002.jwt.JwtUserDetailsService;
import br.com.residenciatic18.avaliacao.api.ap002.repository.TokenRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TokenService {

  @Autowired
  private TokenRepository tokenRepository;

  @Autowired
  JwtUserDetailsService jwtUserDetailsService;

  @Autowired
  private EmailService emailService;

  @Transactional(readOnly = false)
  public Token requestPasswordReset(UserSystem usuario) throws MessagingException {

    JwtToken token = jwtUserDetailsService.getTokenAuthenticated(usuario.getUsername());

    String verificador = token.getToken();
    LocalDateTime dataCriacao = LocalDateTime.now();
    usuario.setCodeverifier(verificador);
    Token tokenEntity = new Token(verificador, dataCriacao, usuario);
    tokenRepository.save(tokenEntity);

    emailService.sendOrderResetPassword(usuario.getUsername(), verificador);
    log.info("Token criado para o usuário {}", usuario.getUsername());
    return tokenEntity;
  }

  @Transactional(readOnly = true)
  public Optional<Token> findByToken(String token) {
    return tokenRepository.findByToken(token);
  }

  public void deleteToken(Token token) {
    tokenRepository.delete(token);
  }

}