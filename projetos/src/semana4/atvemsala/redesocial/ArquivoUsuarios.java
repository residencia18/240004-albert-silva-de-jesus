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
      Utils.limparTela();
      System.out.println("\n\tUsuários carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Utils.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
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
      Utils.limparTela();
      System.out.println("\n\tUsuários salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Utils.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }
}
