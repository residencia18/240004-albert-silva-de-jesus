package com.persistencia.pratica13.services;

import java.util.List;

import com.persistencia.pratica13.dto.UsuarioDTO;

public interface UsuarioDTOService {
  
  List<UsuarioDTO> buscarPorNome(String nome);

  List<UsuarioDTO> listarUsuarios();
}
