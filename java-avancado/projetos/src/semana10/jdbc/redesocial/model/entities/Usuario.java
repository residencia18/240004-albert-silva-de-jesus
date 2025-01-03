package semana10.jdbc.redesocial.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String login;
  private String senha;
  private String email;
  private List<Postagem> postagens;

  public Usuario() {
    this.postagens = new ArrayList<>();
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

  public void addPostagem(Postagem postagem) {
    postagens.add(postagem);
  }

  public List<Postagem> getPostagens() {
    return postagens;
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
    StringBuilder sb = new StringBuilder();
    sb.append("\n\tUsuario:\n");
    sb.append("\tId: ").append(id).append("\n");
    sb.append("\tLogin: ").append(login).append("\n");
    sb.append("\tSenha: ").append(senha).append("\n");
    sb.append("\tEmail: ").append(email).append("\n\n");

    sb.append("\tPostagens do Usuario:\n");
    for (Postagem postagem : postagens) {
      sb.append("\tId: ").append(postagem.getId()).append("\n");
      sb.append("\tLogin: ").append(postagem.getLogin()).append("\n");
      sb.append("\tTexto: ").append(postagem.getTexto()).append("\n\n");
    }

    return sb.toString();
  }

}