package atvemsala.redesocial;

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
  private ListaSessoes listaSessoes;
  private List<String> postagens;
  private List<String> amigos;

  public Usuario() {
    this.postagens = new ArrayList<>();
    this.listaSessoes = new ListaSessoes();
  }

  public Usuario(String nome, String email, String senha) {
    this.id = (int) contadorGlobal.getAndIncrement();
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.postagens = new ArrayList<>();
    this.listaSessoes = new ListaSessoes();
    this.amigos = new ArrayList<>();
  }

  public int getId() 
  {
    return id;
  }

  public void setId(int id) 
  {
    this.id = id;
  }

  public String getNome() 
  {
    return nome;
  }

  public void setNome(String nome) 
  {
    this.nome = nome;
  }

  public String getEmail() 
  {
    return email;
  }

  public void setEmail(String email) 
  {
    this.email = email;
  }

  public String getSenha() 
  {
    return senha;
  }

  public void setSenha(String senha) 
  {
    this.senha = senha;
  }

  public List<String> getPostagens() 
  {
    return postagens;
  }

  public ListaSessoes getListSessoes() 
  {
    return listaSessoes;
  }

  public List<String> getAmigos() 
  {
    return amigos;
  }
  
  public void adicionarPostagem(String postagem) 
  {
    postagens.add(postagem);
  }

  public void adicionarAmigo(String amigo) 
  {
    amigos.add(amigo);
  }

  public Sessao logar() 
  {

    Sessao sessao = new Sessao();
    listaSessoes.adicionarSessao(sessao);
    System.out.println("\n\tUsuário logado com sucesso, na " + sessao.getDataHoraInicio().format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));
    Utils.pausar(Utils.scan);
    return sessao;
  }

  public boolean solicitarAutenticacao(String email, String senha) 
  {

    return (this.getEmail().equals(email) && this.getSenha().equals(senha));
  }

  public void deslogar(Sessao sessao) 
  {
    sessao.setDataHoraFim();
  }

}