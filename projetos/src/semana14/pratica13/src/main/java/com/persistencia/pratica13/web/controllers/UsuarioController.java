package com.persistencia.pratica13.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.services.UsuarioService;
import com.persistencia.pratica13.web.dto.UsuarioDto;
import com.persistencia.pratica13.web.dto.UsuarioResponseDto;
import com.persistencia.pratica13.web.dto.UsuarioSenhaDto;
import com.persistencia.pratica13.web.dto.mapper.UsuarioMapper;

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

  @GetMapping("/listarusuarios/")
  public List<UsuarioDto> listarUsuarios(String nome) {
    return usuarioService.buscarPorNome(nome);
  }

  // @GetMapping("/editar/{id}")
  // public Usuario editar(@PathVariable("id") Long id) {
  // usuarioService.editar(id);
  // return usuarioService.buscarPorId(id);
  // }

  @PatchMapping("/editar/{id}")
  public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDto dto) {
    Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
    return ResponseEntity.noContent().build();
  }

  // @GetMapping("/excluir/{id}")
  // public String excluir(@PathVariable("id") Long id) {
  // usuarioService.excluir(id);
  // return "Usuário excluído com sucesso!";
  // }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {
    Usuario user = usuarioService.buscarPorId(id);
    return ResponseEntity.ok(UsuarioMapper.toDto(user));
  }

  @GetMapping("/buscar/{id}")
  public Usuario buscarPorId(@PathVariable("id") Long id) {
    return usuarioService.buscarPorId(id);
  }
}