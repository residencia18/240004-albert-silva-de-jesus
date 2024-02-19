package com.persistencia.pratica13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.repositories.UsuarioRepository;

@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public void salvar(Usuario usuario) {

  }

  @Override
  public void editar(Usuario usuario) {

  }

  @Override
  public void excluir(Long id) {

  }

  @Override
  @Transactional(readOnly = true)
  public Usuario buscarPorId(Long id) {

    throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
  }

  @Override
  @Transactional(readOnly = true)
  public String buscarTodos() {
    List<Usuario> usuarios = usuarioRepository.findAll();
    return usuarios.toString();
  }

}