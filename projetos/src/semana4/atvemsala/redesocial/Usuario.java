package semana4.atvemsala.redesocial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Usuario implements Serializable {

  private static final AtomicLong contadorGlobal = new AtomicLong(1);
  private int id;
  private String nome;
  private String email;
  private String senha;
  private List<String> postagens;

  public Usuario() {
    this.postagens = new ArrayList<>();
  }

  public Usuario(String nome, String email, String senha) {
    this.id = (int) contadorGlobal.getAndIncrement();
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public List<String> getPostagens() {
    return postagens;
  }

  public void setPostagens(List<String> postagens) {
    this.postagens = postagens;
  }

}