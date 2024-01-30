package jdbc.redesocial.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String login;
  private String senha;
  private String email;

  public Usuario() {
  }

  public Usuario(Integer id, String login, String senha, String email) {
    this.id = id;
    this.login = login;
    this.senha = senha;
    this.email = email;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", email=" + email + "]";
  }

}