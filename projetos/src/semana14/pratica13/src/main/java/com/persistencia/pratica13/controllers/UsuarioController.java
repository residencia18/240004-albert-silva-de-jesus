package com.persistencia.pratica13.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistencia.pratica13.dto.UsuarioDTO;
import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/cadastrar")
  public void cadastrar(Usuario usuario) {
    usuarioService.salvarUsuario(usuario);
  }

  @GetMapping("/listar")
  public List<Usuario> listar() {
    return usuarioService.buscarTodos();
  }

  // @GetMapping("/listarusuarios")
  // public List<UsuarioDTO> listarUsuarios() {
  // return usuarioService.listarUsuarios();
  // }

  @GetMapping("/listarusuarios/")
  public List<UsuarioDTO> listarUsuarios(String nome) {
   return usuarioService.buscarPorNome(nome);
  }

  @GetMapping("/editar/{id}")
  public Usuario editar(@PathVariable("id") Long id) {
    usuarioService.editar(id);
    return usuarioService.buscarPorId(id);
  }

  @GetMapping("/excluir/{id}")
  public String excluir(@PathVariable("id") Long id) {
    usuarioService.excluir(id);
    return "Usuário excluído com sucesso!";
  }

  @GetMapping("/buscar/{id}")
  public Usuario buscarPorId(@PathVariable("id") Long id) {
    return usuarioService.buscarPorId(id);
  }
}