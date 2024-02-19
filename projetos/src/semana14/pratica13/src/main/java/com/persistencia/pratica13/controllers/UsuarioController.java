package com.persistencia.pratica13.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  public void cadastrar(Usuario usuario){
    usuarioService.salvar(usuario);
  }

  @GetMapping("/listar")
  public String listar(){
    return usuarioService.buscarTodos();
  }

  @GetMapping("/listarusuarios")
  public List<UsuarioDTO> listarUsuarios(){
    return usuarioService.listarUsuarios();
  }

  public String salvar(Usuario usuario){
    return null;
  }

  public String editar(Usuario usuario){
    return null;
  }

  public String excluir(Long id){
    return null;
  }

  public String buscarPorId(Long id){
    return null;
  }
}