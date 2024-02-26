package atvemsala.redesocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaUsuarios {

  private List<Usuario> usuarios;

  public ListaUsuarios() 
  {
    this.usuarios = new ArrayList<>();
  }

  public List<Usuario> getUsuarios() 
  {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) 
  {
    this.usuarios = usuarios;
  }

  public void adicionarUsuario(Usuario usuario) 
  {
    usuarios.add(usuario);
  }

  public void novoUsuario(Scanner scan) 
  {

    Utils.limparTela();
    System.out.println("\n\t========== CADASTRAR ==========");

    String nome = Utils.validarNomeUsuario();

    String email = Utils.validarEmail();

    String senha = Utils.validarSenha();

    Usuario usuario = new Usuario(nome, email, senha);

    adicionarUsuario(usuario);

    System.out.println("\n\tUsuário cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public void listarUsuarios() 
  {

    Utils.limparTela();
    System.out.println("\n\t========== USUÁRIOS ==========");

    for (Usuario usuario : usuarios) {
      System.out.println("\tID: " + usuario.getId());
      System.out.println("\tNome: " + usuario.getNome());
      System.out.println("\tEmail: " + usuario.getEmail());
      System.out.println("\tSenha: " + usuario.getSenha());
      System.out.println("\t==============================");
    }
  }

  public void carregarDeArquivo(String nomeArquivo) 
  {
    List<Usuario> usuariosCarregados = ArquivoUsuarios.carregarDeArquivo(nomeArquivo);

    if (usuariosCarregados != null) {
      usuarios = usuariosCarregados;
    }
  }

  public void salvarEmArquivo(String nomeArquivo) 
  {
    ArquivoUsuarios.salvarEmArquivo(usuarios, nomeArquivo);
  }
}
