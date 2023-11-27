package semana4.atvemsala.redesocial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUsuarios {

  public static List<Usuario> carregarDeArquivo(String nomeArquivo) {
    List<Usuario> usuarios = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
      String linha;

      while ((linha = reader.readLine()) != null) {
        String[] partes = linha.split(";");

        if (partes.length == 4) {
          int id = Integer.parseInt(partes[0]);
          String nome = partes[1];
          String email = partes[2];
          String senha = partes[3];
          Usuario usuario = new Usuario(nome, email, senha);
          usuario.setId(id);
          usuarios.add(usuario);
        }
      }

      System.out.println("Usuários carregados do arquivo: " + nomeArquivo);
    } catch (IOException e) {
      System.err.println("Erro ao carregar do arquivo: " + e.getMessage());
    }

    return usuarios;
  }

  public static void salvarEmArquivo(List<Usuario> usuarios, String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
      for (Usuario usuario : usuarios) {
        writer.write(usuario.getId() + ";" +
            usuario.getNome() + ";" +
            usuario.getEmail() + ";" +
            usuario.getSenha());
        writer.newLine();
      }

      System.out.println("Usuários salvos com sucesso no arquivo: " + nomeArquivo);
    } catch (IOException e) {
      System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
    }
  }

  // public static void salvarEmArquivo(List<Usuario> usuarios, String
  // nomeArquivo) {

  // try (ObjectOutputStream oos = new ObjectOutputStream(new
  // FileOutputStream(nomeArquivo))) {

  // oos.writeObject(usuarios);
  // System.out.println("Usuários salvos com sucesso no arquivo: " + nomeArquivo);

  // } catch (IOException e) {
  // System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
  // }
  // }

  // public static List<Usuario> carregarDeArquivo(String nomeArquivo) {

  // List<Usuario> usuarios = new ArrayList<>();

  // try (ObjectInputStream ois = new ObjectInputStream(new
  // FileInputStream(nomeArquivo))) {
  // Object obj = ois.readObject();

  // if (obj instanceof List<?>) {
  // usuarios = (List<Usuario>) obj;
  // } else {
  // System.err.println("Objeto no arquivo não é do tipo esperado
  // (List<Usuario>).");
  // }

  // System.out.println("Usuários carregados do arquivo: " + nomeArquivo);
  // } catch (IOException | ClassNotFoundException e) {
  // System.err.println("Erro ao carregar do arquivo: " + e.getMessage());
  // }

  // return usuarios;
  // }

  // Outra forma de implementar o método carregarDeArquivo:
  /*
   * public static List<Usuario> carregarDeArquivo(String nomeArquivo) {
   * 
   * @SuppressWarnings("unchecked")
   * List<Usuario> usuarios = null;
   * 
   * try (ObjectInputStream ois = new ObjectInputStream(new
   * FileInputStream(nomeArquivo))) {
   * 
   * usuarios = (List<Usuario>) ois.readObject();
   * 
   * System.out.println("Usuários carregados do arquivo: " + nomeArquivo);
   * 
   * } catch (IOException | ClassNotFoundException e) {
   * System.err.println("Erro ao carregar do arquivo: " + e.getMessage());
   * }
   * 
   * return usuarios;
   * }
   */
}
