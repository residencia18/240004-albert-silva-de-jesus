package com.persistencia.pratica13.dto;

import com.persistencia.pratica13.entities.AbstractEntity;
import com.persistencia.pratica13.entities.Usuario;

public class UsuarioDTO extends AbstractEntity {

  private String nome;
  private String email;

  public UsuarioDTO(Usuario usuario) {
    setId(usuario.getId());
    this.nome = usuario.getNome();
    this.email = usuario.getEmail();
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

}