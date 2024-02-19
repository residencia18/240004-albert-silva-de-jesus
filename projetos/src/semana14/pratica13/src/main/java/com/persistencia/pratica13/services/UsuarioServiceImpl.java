package com.persistencia.pratica13.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistencia.pratica13.dto.UsuarioDTO;
import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.repositories.UsuarioRepository;

@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public void salvar(Usuario usuario) {
    usuario = new Usuario("João", "joão@gmail.com", "12345678");
    usuarioRepository.save(usuario);
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
    return usuarioRepository.findAll().toString();
  }

  @Override
  public List<UsuarioDTO> listarUsuarios() {

    List<Usuario> usuarios = usuarioRepository.findAll();
    List<UsuarioDTO> usuariosDTO = new ArrayList<>();
    for (Usuario usuario : usuarios) {
      usuariosDTO.add(new UsuarioDTO(usuario));
    }
    return usuariosDTO;

  }

}