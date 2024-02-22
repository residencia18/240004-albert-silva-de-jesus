package com.persistencia.pratica13.web.dto;

import com.persistencia.pratica13.entities.AbstractEntity;
import com.persistencia.pratica13.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto extends AbstractEntity {

  private String nome;
  private String email;

  public UsuarioDto(Usuario usuario) {
    setId(usuario.getId());
    this.nome = usuario.getNome();
    this.email = usuario.getEmail();
  }

}