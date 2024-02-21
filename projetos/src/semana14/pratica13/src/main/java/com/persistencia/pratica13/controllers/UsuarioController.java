package com.persistencia.pratica13.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistencia.pratica13.dto.UsuarioDTO;
import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.services.UsuarioDTOService;
import com.persistencia.pratica13.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private UsuarioDTOService usuarioDTOService;

  @PostMapping("/cadastrar")
  public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
    Usuario user = usuarioService.salvar(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  // @GetMapping("/listar")
  // public List<Usuario> listar() {
  // return usuarioService.buscarTodos();
  // }

  // @GetMapping("/listarusuarios")
  // public List<UsuarioDTO> listarUsuarios() {
  // return usuarioService.listarUsuarios();
  // }

  @GetMapping("/listarusuarios/")
  public List<UsuarioDTO> listarUsuarios(String nome) {
    return usuarioDTOService.buscarPorNome(nome);
  }

  // @GetMapping("/editar/{id}")
  // public Usuario editar(@PathVariable("id") Long id) {
  // usuarioService.editar(id);
  // return usuarioService.buscarPorId(id);
  // }

  // @GetMapping("/excluir/{id}")
  // public String excluir(@PathVariable("id") Long id) {
  // usuarioService.excluir(id);
  // return "Usuário excluído com sucesso!";
  // }

  @GetMapping("/buscar/{id}")
  public Usuario buscarPorId(@PathVariable("id") Long id) {
    return usuarioService.buscarPorId(id);
  }
}