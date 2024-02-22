package com.persistencia.pratica13.services;

import java.util.List;

import com.persistencia.pratica13.web.dto.UsuarioDto;

public interface UsuarioDTOService {
  
  List<UsuarioDto> buscarPorNome(String nome);

  List<UsuarioDto> listarUsuarios();
}
