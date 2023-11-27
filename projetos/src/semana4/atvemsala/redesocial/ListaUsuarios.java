package semana4.atvemsala.redesocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaUsuarios {

  private List<Usuario> usuarios;

  public ListaUsuarios() {
    this.usuarios = new ArrayList<>();
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public void adicionarUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }

  public void novoUsuario() {

    Scanner scan = new Scanner(System.in);
    Utils.limparTela();
    System.out.println("\n\t========== CADASTRAR ==========");

    String nome = Utils.validarNomeUsuario();

    String email = Utils.validarEmail();

    String senha = Utils.validarSenha();

    Usuario usuario = new Usuario(nome, email, senha);

    adicionarUsuario(usuario);

    System.out.println("\n\tUsuário cadastrado com sucesso!");
    Utils.pausar(scan);
  }

  public void listarUsuarios() {

    Utils.limparTela();
    System.out.println("\n\t========== USUÁRIOS ==========");

    for (Usuario usuario : usuarios) {
      System.out.println("\tID: " + usuario.getId());
      System.out.println("\tNome: " + usuario.getNome());
      System.out.println("\tEmail: " + usuario.getEmail());
      System.out.println("\tSenha: " + usuario.getSenha());
      System.out.println("\tPostagens: " + usuario.getPostagens());
      System.out.println("\t==============================");
    }
  }

  public void carregarDeArquivo(String nomeArquivo) {

    List<Usuario> usuariosCarregados = ArquivoUsuarios.carregarDeArquivo(nomeArquivo);

    if (usuariosCarregados != null) {
      usuarios = usuariosCarregados;
    }
  }

  public void salvarEmArquivo(String nomeArquivo) {
    ArquivoUsuarios.salvarEmArquivo(usuarios, nomeArquivo);
  }

  // public void carregarDeArquivo(String nomeArquivo) {

  // try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo)))
  // {

  // String linha;

  // while ((linha = reader.readLine()) != null) {

  // String[] partes = linha.split(";");

  // if (partes.length == 5) {
  // int id = Integer.parseInt(partes[0]);
  // String nome = partes[1];
  // String email = partes[2];
  // String senha = partes[3];

  // Usuario usuario = new Usuario(nome, email, senha);
  // usuario.setId(id);
  // usuarios.add(usuario);
  // }
  // }
  // System.out.println("Produtos carregados do arquivo: " + nomeArquivo);

  // } catch (IOException e) {
  // System.err.println("Erro ao carregar do arquivo: " + e.getMessage());
  // }
  // }

  // public void salvarEmArquivo(String nomeArquivo) {

  // try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo)))
  // {

  // for (Usuario usuario : usuarios) {
  // writer.write(usuario.getId() + ";" +
  // usuario.getNome() + ";" +
  // usuario.getEmail() + ";" +
  // usuario.getSenha() + ";" );
  // writer.newLine();
  // }
  // System.out.println("Produtos salvos com sucesso no arquivo: " + nomeArquivo);

  // } catch (IOException e) {
  // System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
  // }
  // }
}
