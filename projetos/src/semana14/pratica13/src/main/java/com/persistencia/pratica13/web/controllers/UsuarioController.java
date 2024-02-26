package com.persistencia.pratica13.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.services.UsuarioService;
import com.persistencia.pratica13.web.dto.UsuarioDto;
import com.persistencia.pratica13.web.dto.UsuarioResponseDto;
import com.persistencia.pratica13.web.dto.UsuarioSenhaDto;
import com.persistencia.pratica13.web.dto.mapper.UsuarioMapper;
import com.persistencia.pratica13.web.form.UsuarioForm;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @PostMapping("/cadastrar")
  public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
    Usuario user = usuarioService.salvar(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  // Forma de cadastrar usuário com DTO diferente do primeiro método de
  // cadastro(create) acima.
  /*
   * @PostMapping("/cadastrar")
   * public ResponseEntity<UsuarioResponseDto> create(@RequestBody
   * UsuarioCreateDto createDto) {
   * Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
   * return
   * ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
   * }
   */

  // Forma de cadastrar usuário com DTO diferente do primeiro método de
  // cadastro(create) acima.
  @PostMapping("/cadastrarusuario/")
  public ResponseEntity<UsuarioDto> insert(@RequestBody UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
    Usuario usuario = usuarioForm.toUsuario();
    usuario = usuarioService.salvar(usuario);
    UsuarioDto usuarioDto = new UsuarioDto(usuario);
    uriBuilder.path("/usuarios/cadastrarusuario/{id}");
    URI uri = uriBuilder.buildAndExpand(usuario.getId()).toUri();
    return ResponseEntity.created(uri).body(usuarioDto);
  }

  @GetMapping("/listarusuarios/")
  public List<UsuarioDto> listarUsuarios(String nome) {
    return usuarioService.buscarPorNome(nome);
  }

  @GetMapping("/role")
  public ResponseEntity<List<UsuarioResponseDto>> getAll() {
    // List<Usuario> users = usuarioService.buscarTodos();
    return ResponseEntity.ok(UsuarioMapper.toListDto(usuarioService.buscarTodos()));
  }

  // @PatchMapping("/editar/{id}")
  // public Usuario editar(@PathVariable("id") Long id) {
  // usuarioService.editar(id);
  // return usuarioService.buscarPorId(id);
  // }

  @PatchMapping("/editar/{id}")
  public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDto dto) {
    Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UsuarioForm usuarioForm) {
    try {
      Usuario usuario = usuarioService.buscarPorId(id);
      usuario.setNome(usuarioForm.getNome());
      usuario.setEmail(usuarioForm.getEmail());
      usuario.setSenha(usuarioForm.getSenha());
      UsuarioDto usuarioDto = new UsuarioDto(usuario);
      usuarioService.salvar(usuario);
      return ResponseEntity.ok(usuarioDto);

    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/excluir/{id}")
  public String excluir(@PathVariable("id") Long id) {
    usuarioService.excluir(id);
    return "Usuário excluído com sucesso!";
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {

    // Usuario user = usuarioService.buscarPorId(id);
    // return ResponseEntity.ok(UsuarioMapper.toDto(user));

    try {
      Usuario user = usuarioService.buscarPorId(id);
      return ResponseEntity.ok(UsuarioMapper.toDto(user));

    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/buscar/{id}")
  public Usuario buscarPorId(@PathVariable("id") Long id) {
    return usuarioService.buscarPorId(id);
  }
}