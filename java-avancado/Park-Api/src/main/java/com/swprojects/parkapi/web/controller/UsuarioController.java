package com.swprojects.parkapi.web.controller;

import com.swprojects.parkapi.entity.Usuario;
import com.swprojects.parkapi.service.UsuarioService;
import com.swprojects.parkapi.web.dto.UsuarioCreateDto;
import com.swprojects.parkapi.web.dto.UsuarioResponseDto;
import com.swprojects.parkapi.web.dto.UsuarioSenhaDto;
import com.swprojects.parkapi.web.dto.mapper.UsuarioMapper;
import com.swprojects.parkapi.web.exceptions.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Usuarios", description = "Contém todas as operações aos recursos para cadastro, edição e leitura de um usuário.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

        private final UsuarioService usuarioService;

        @Operation(summary = "Cria um novo usuário", description = "Recurso para criar um novo usuário no sistema.", responses = {
                        @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponseDto.class))),
                        @ApiResponse(responseCode = "409", description = "Usuário e-mail já cadastrado no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "422", description = "Recursos não processados por dados de entrada invalidos.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        })
        @PostMapping
        public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto)
                        throws MessagingException {
                Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
                return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
        }

        @Operation(summary = "Recuperar um usuário pelo id", description = "Recurso para recuperar um usuário pelo id.", responses = {
                        @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponseDto.class))),
                        @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
        })
        @GetMapping("/{id}")
        @PreAuthorize("hasRole('ADMIN') OR ( hasRole('CLIENTE') AND #id == authentication.principal.id )")
        public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {
                Usuario user = usuarioService.buscarPorId(id);
                return ResponseEntity.ok(UsuarioMapper.toDto(user));
        }

        @Operation(summary = "Atualizar senha", description = "Recurso para atualizar a senha do usuário.", responses = {
                        @ApiResponse(responseCode = "204", description = "Senha atualizada com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class))),
                        @ApiResponse(responseCode = "400", description = "Senha não confere.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "422", description = "Campos invalidos ou formatados incorretamente.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
        })
        @PatchMapping("/{id}")
        public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto) {
                Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(),
                                dto.getConfirmaSenha());
                return ResponseEntity.noContent().build();
        }

        @GetMapping
        public ResponseEntity<List<UsuarioResponseDto>> getAll() {
                List<Usuario> users = usuarioService.buscaTodos();
                return ResponseEntity.ok(UsuarioMapper.toListDto(users));
        }

        @GetMapping("/confirmacao/cadastro")
        @PreAuthorize("hasRole('ADMIN') OR hasRole('CLIENTE')")
        public ResponseEntity<Void> respostaConfirmacaoCadastroUsuario(@RequestParam("codigo") String codigo) {
                usuarioService.ativarCadastroUsuario(codigo);
                return ResponseEntity.noContent().build();
        }

        @GetMapping("/redefinicao/senha")
        public ResponseEntity<Void> redefinicaoSenhaUsuario(@RequestParam("username") String username)
                        throws MessagingException {
                usuarioService.pedidoRedefinicaoDeSenha(username);
                return ResponseEntity.noContent().build();
        }

        @GetMapping("/confirmacao/senha")
        @PreAuthorize("hasRole('ADMIN') OR hasRole('CLIENTE')")
        public ResponseEntity<Void> confirmacaoRedefinicaoSenhaUsuario(Usuario usuario) {
                Usuario obj = usuarioService.buscarPorUsername(usuario.getUsername());
                log.info("Verificando código de verificação do usuário {}", obj.getUsername());
                if (!usuario.getCodigoVerificador().equals(obj.getCodigoVerificador())) {
                        return ResponseEntity.badRequest().build();
                }
                obj.setCodigoVerificador(null);
                return ResponseEntity.noContent().build();
        }

}