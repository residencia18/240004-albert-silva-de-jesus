package com.swprojets.productsales.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swprojets.productsales.entities.Usuario;
import com.swprojets.productsales.services.UsuarioService;
import com.swprojets.productsales.web.dto.UsuarioResponseDto;
import com.swprojets.productsales.web.dto.UsuarioSenhaDto;
import com.swprojets.productsales.web.dto.form.UsuarioForm;
import com.swprojets.productsales.web.dto.mapper.UsuarioMapper;
import com.swprojets.productsales.web.exceptions.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Usuarios", description = "Contém todas as operações aos recursos para cadastro, edição e leitura de um usuário.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService userService;

  @Operation(summary = "Cria um novo usuário", description = "Recurso para criar um novo usuário no sistema.", responses = {
      @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponseDto.class))),
      @ApiResponse(responseCode = "409", description = "Usuário e-mail já cadastrado no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "422", description = "Recursos não processados por dados de entrada invalidos.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
  })
  @PostMapping
  public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioForm createDto) {
    Usuario user = userService.create(UsuarioMapper.toUsuario(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).body(UsuarioMapper.toDto(user));
  }

  @Operation(summary = "Recuperar um usuário pelo id", description = "Recurso para recuperar um usuário pelo id.", responses = {
      @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/{id}")
  public ResponseEntity<UsuarioResponseDto> getById(@PathVariable @NonNull Long id) {
    Usuario user = userService.findById(id);
    return ResponseEntity.ok(UsuarioMapper.toDto(user));
  }

  // Método criado para atender ao teste automatizado porque o método findById não
  // retorna um Optional e sim um Usuario
  @GetMapping("/searchbyId/{id}")
  public ResponseEntity<UsuarioResponseDto> searchbyId(@PathVariable @NonNull Long id) {
    return userService.searchbyId(id)
        .map(usuario -> ResponseEntity.ok().body(UsuarioMapper.toDto(usuario)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Operation(summary = "Listar todos os usuarios", description = "Listar todos os usuarios cadastrados", responses = {
      @ApiResponse(responseCode = "200", description = "Lista com todos os usuarios cadastrados", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioResponseDto.class))))
  })
  @GetMapping("/")
  public ResponseEntity<List<UsuarioResponseDto>> getAll() {
    List<UsuarioResponseDto> users = UsuarioMapper.toListDto(userService.findAll());
    return ResponseEntity.ok().body(users);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioResponseDto> update(@PathVariable @NonNull Long id, @RequestBody UsuarioForm createDto) {
    return ResponseEntity.ok(UsuarioMapper.toDto(userService.update(id, createDto)));
  }

  @PutMapping("/toEdit/{id}")
  public ResponseEntity<UsuarioResponseDto> toEdit(@PathVariable @NonNull Long id, @RequestBody UsuarioForm createDto) {
    return userService.toEdit(id, createDto)
        .map(usuario -> ResponseEntity.ok().body(UsuarioMapper.toDto(usuario)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Operation(summary = "Atualizar senha", description = "Recurso para atualizar a senha do usuário.", responses = {
      @ApiResponse(responseCode = "204", description = "Senha atualizada com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class))),
      @ApiResponse(responseCode = "400", description = "Senha não confere.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "422", description = "Campos invalidos ou formatados incorretamente.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @PatchMapping("/{id}")
  public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto) {
    Usuario user = userService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
