package com.persistencia.pratica13.services;

import java.util.List;

import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.web.dto.UsuarioDto;

public interface UsuarioService {

  Usuario salvar(Usuario usuario);

  public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha);

  void editar(Long id);

  void excluir(Long id);

  Usuario buscarPorId(Long id);

  List<Usuario> buscarTodos();

  List<UsuarioDto> buscarPorNome(String nome);

  List<UsuarioDto> listarUsuarios();

  public Boolean isExisteId(Long id);

}