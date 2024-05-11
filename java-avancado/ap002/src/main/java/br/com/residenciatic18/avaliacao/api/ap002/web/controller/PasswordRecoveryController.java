package br.com.residenciatic18.avaliacao.api.ap002.web.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.residenciatic18.avaliacao.api.ap002.entity.Token;
import br.com.residenciatic18.avaliacao.api.ap002.entity.Usuario;
import br.com.residenciatic18.avaliacao.api.ap002.service.TokenService;
import br.com.residenciatic18.avaliacao.api.ap002.service.UsuarioService;
import br.com.residenciatic18.avaliacao.api.ap002.web.dto.TokenResponseDto;
import br.com.residenciatic18.avaliacao.api.ap002.web.dto.UsuarioResponseDto;
import br.com.residenciatic18.avaliacao.api.ap002.web.dto.mapper.TokenMapper;
import br.com.residenciatic18.avaliacao.api.ap002.web.exceptions.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Passwords Recovery", description = "Contém todas as operações aos recursos para receber um e-mail de recuperação de senha.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/password-recovery")
public class PasswordRecoveryController {

  private final TokenService tokenService;
  private final UsuarioService usuarioService;

  @Operation(summary = "Redefinir senha pelo username", description = "Recurso para redefinir senha pelo username", responses = {
      @ApiResponse(responseCode = "204", description = "Pedido de redefinição de senha enviado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "401", description = "Usuário não autorizado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping
  public ResponseEntity<TokenResponseDto> redefinirSenha(@RequestParam("username") String username)
      throws MessagingException {

    Usuario usuario = usuarioService.buscarPorUsername(username);
    Optional<Token> tokenExistenteOptional = tokenService.findByToken(usuario.getCodigoVerificador());
    tokenExistenteOptional.ifPresent(token -> tokenService.deletarToken(token));

    Token token = tokenService.pedidoRedefinicaoDeSenha(usuario);
    log.info("Token criado para o usuário {}", username);
    return ResponseEntity.ok(TokenMapper.toDto(token));
  }

}