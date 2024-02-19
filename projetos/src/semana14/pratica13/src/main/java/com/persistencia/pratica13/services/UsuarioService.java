package com.persistencia.pratica13.services;

import com.persistencia.pratica13.entities.Usuario;

public interface UsuarioService {

  void salvar(Usuario usuario);

  void editar(Usuario usuario);

  void excluir(Long id);

  Usuario buscarPorId(Long id);

  String buscarTodos();

}