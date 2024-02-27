package com.persistencia.pratica13.web.dto.form;

import com.persistencia.pratica13.entities.Usuario;

public class UsuarioForm {

  private String nome;
  private String email;
  private String senha;

  public UsuarioForm() {
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Usuario toUsuario() {
    Usuario usuario = new Usuario();
    usuario.setNome(nome);
    usuario.setEmail(email);
    usuario.setSenha(senha);
    return usuario;
  }
}
