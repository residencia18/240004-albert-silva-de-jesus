package com.persistencia.pratica13.dto;

import java.util.List;

import com.persistencia.pratica13.entities.AbstractEntity;
import com.persistencia.pratica13.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO extends AbstractEntity {

  private String nome;
  private String email;
  private String mensagem;
  private List<Usuario> usuarios;

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

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

}