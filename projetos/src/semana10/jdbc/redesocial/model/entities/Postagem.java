package semana10.jdbc.redesocial.model.entities;

import java.io.Serializable;

public class Postagem implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String login;
  private String texto;

  public Postagem() {
  }

  public Postagem(Integer id, String login, String texto) {
    this.id = id;
    this.login = login;
    this.texto = texto;
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

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
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
    Postagem other = (Postagem) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "\n\tPostagem:" + "\tId: " + id + "\n\tLogin: " + login + "\n\tTexto: " + texto + "\n";
  }

}
