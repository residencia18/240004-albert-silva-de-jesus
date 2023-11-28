package semana4.atvemsala.redesocial;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Usuario implements Serializable {

  private static final AtomicLong contadorGlobal = new AtomicLong(1);
  private int id;
  private String nome;
  private String email;
  private String senha;
  private Sessao sessao;
  private List<String> postagens;

  public Usuario() {
    this.postagens = new ArrayList<>();
  }

  public Usuario(String nome, String email, String senha) {
    this.id = (int) contadorGlobal.getAndIncrement();
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.postagens = new ArrayList<>();
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

  public Sessao getSessao() {
    return sessao;
  }

  public void setSessao(Sessao sessao) {
    this.sessao = sessao;
  }

  public void adicionarPostagem(String postagem) {
    postagens.add(postagem);
  }

  public void logar() {

    if (this.sessao == null) {

      ListaSessoes listaSessoes = new ListaSessoes();
      this.sessao = new Sessao();
      sessao.setIdUsuario(this.id);
      this.sessao.setDataHoraInicio(this.sessao.getDataHoraInicio());
      listaSessoes.adicionarSessao(this.sessao);
      System.out.println("\n\tUsuário logado em "
          + sessao.getDataHoraInicio().format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));

    } else {
      System.out.println("Usuário já está logado.");

    }
  }

  public void deslogar() {

    if (sessao != null) {

      sessao.setDataHoraFim(sessao.getDataHoraFim());
      System.out.println("Usuário " + nome + " deslogado em " + sessao.getDataHoraFim());
      sessao = null;

    } else {
      System.out.println("Usuário não está logado.");
    }
  }

}