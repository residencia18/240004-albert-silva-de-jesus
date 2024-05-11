package br.com.residenciatic18.avaliacao.api.ap002.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.residenciatic18.avaliacao.api.ap002.entity.Token;
import br.com.residenciatic18.avaliacao.api.ap002.entity.Usuario;
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

  public void emailDeConfirmacaoDeCadastro(String username) throws MessagingException {
    // Alguns servidores de e-mail aceitam caracteres especias que podem acabar
    // calsando problemas na URL por esse motivo é necessário codificar o username
    // para base64.
    String codigo = Base64.getEncoder().encodeToString(username.getBytes());
    emailService.enviarPedidoDeConfirmacaoDeCadastro(username, codigo);
  }

  @Transactional(readOnly = false)
  public Token pedidoRedefinicaoDeSenha(Usuario usuario) throws MessagingException {

    JwtToken token = jwtUserDetailsService.getTokenAuthenticated(usuario.getUsername());

    String verificador = token.getToken();
    LocalDateTime dataCriacao = LocalDateTime.now();
    usuario.setCodigoVerificador(verificador);
    Token tokenEntity = new Token(verificador, dataCriacao, usuario);
    tokenRepository.save(tokenEntity);

    emailService.enviarPedidoRedefinicaoSenha(usuario.getUsername(), verificador);
    log.info("Token criado para o usuário {}", usuario.getUsername());
    return tokenEntity;
  }

  @Transactional(readOnly = true)
  public Optional<Token> findByToken(String token) {
    return tokenRepository.findByToken(token);
  }

  public void deletarToken(Token token) {
    tokenRepository.delete(token);
  }

}