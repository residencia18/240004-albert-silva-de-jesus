package semana4.atvemsala.redesocial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

  public void adicionarPostagem(String postagem) {
    postagens.add(postagem);
  }

  public void logar() {

    Scanner scan = new Scanner(System.in);

    System.out.println("\n\t========== LOGIN ==========");

    System.out.print("\n\tEmail: ");
    String email = scan.nextLine();

    System.out.print("\n\tSenha: ");
    String senha = scan.nextLine();

    if (this.email.equals(email) && this.senha.equals(senha)) {

      System.out.println("\n\tLogin realizado com sucesso!");
      Utils.pausar(scan);
      Utils.limparTela();
    } else {
      System.out.println("\n\tOps, e-mail ou senha incorretos.");
      Utils.pausar(scan);
    }
  }

  @Override
  public String toString() {
    return "Usuario [email=" + email + ", id=" + id + ", nome=" + nome + ", postagens=" + postagens + ", senha="
        + senha + "]";
  }

}