package com.persistencia.pratica13.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.repositories.UsuarioRepository;
import com.persistencia.pratica13.web.dto.UsuarioDto;

@Service
@Transactional(readOnly = false)
public class UsuarioDTOServiceImpl implements UsuarioDTOService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public List<UsuarioDto> listarUsuarios() {

    List<Usuario> usuarios = usuarioRepository.findAll();
    List<UsuarioDto> usuariosDTO = new ArrayList<>();

    for (Usuario usuario : usuarios) {
      usuariosDTO.add(new UsuarioDto(usuario));
    }
    return usuariosDTO;

  }

  @Override
  public List<UsuarioDto> buscarPorNome(String nome) {

    List<Usuario> usuarios;
    if (nome == null) {
      usuarios = usuarioRepository.findAll();

    } else {
      usuarios = usuarioRepository.findByNome(nome);
    }
    List<UsuarioDto> usuariosDTO = new ArrayList<>();

    for (Usuario usuario : usuarios) {
      usuariosDTO.add(new UsuarioDto(usuario));
    }

    return usuariosDTO;

  }

}