package br.com.residenciatic18.avaliacao.api.ap002.web.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residenciatic18.avaliacao.api.ap002.entity.Token;
import br.com.residenciatic18.avaliacao.api.ap002.jwt.JwtUtils;
import br.com.residenciatic18.avaliacao.api.ap002.service.TokenService;
import br.com.residenciatic18.avaliacao.api.ap002.service.UsuarioService;
import br.com.residenciatic18.avaliacao.api.ap002.web.dto.UsuarioAlterarSenhaDto;
import br.com.residenciatic18.avaliacao.api.ap002.web.exceptions.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Passwords Reset", description = "Contém todas as operações aos recursos para resetar a senha do usuário.")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/password-reset")
public class PasswordResetController {

  private final UsuarioService usuarioService;
  private final TokenService tokenService;

  @Operation(summary = "Atualizar senha pelo token", description = "Recurso para atualizar a senha do usuário com token.", responses = {
      @ApiResponse(responseCode = "204", description = "Senha atualizada com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class))),
      @ApiResponse(responseCode = "400", description = "Senha não confere.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "422", description = "Campos invalidos ou formatados incorretamente.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @PatchMapping("/{token}")
  public ResponseEntity<Void> confirmacaoDeRedefinicaoDeSenha(@PathVariable String token,
      @Valid @RequestBody UsuarioAlterarSenhaDto dto) {

    if (!JwtUtils.isTokenValid(token)) {
      log.error("Token inválido" + token);
      return ResponseEntity.badRequest().build();
    }

    Optional<Token> tokenDoUsuario = tokenService.findByToken(token);
    if (tokenDoUsuario.isEmpty()) {
      log.error("Token não encontrado para o token {}", token);
      return ResponseEntity.notFound().build();
    }

    Token tokenEncontrado = tokenDoUsuario.get();
    if (!dto.getCodigoVerificador().equals(tokenEncontrado.getToken())) {
      log.error("Código de verificação inválido para o token {}", tokenEncontrado);
      return ResponseEntity.badRequest().build();
    }

    usuarioService.alterarSenha(tokenEncontrado, dto.getNovaSenha(), dto.getConfirmaSenha());
    tokenService.deletarToken(tokenEncontrado);
    return ResponseEntity.noContent().build();

  }

}