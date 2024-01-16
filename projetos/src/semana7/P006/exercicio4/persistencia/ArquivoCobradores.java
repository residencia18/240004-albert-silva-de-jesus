package semana7.P006.exercicio4.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.Cobrador;
import semana7.P006.exercicio4.views.Views;

public class ArquivoCobradores {

  public static List<Cobrador> carregarDeArquivo(String nomeArquivo) {

    List<Cobrador> cobradores = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 2) {
          String nome = partes[0];
          String matricula = partes[1];

          Cobrador cobrador = new Cobrador(nome, matricula);
          cobradores.add(cobrador);
        }
      }
      Views.limparTela();
      System.out.println("\n\tCobradores carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return cobradores;
  }

  public static void salvarEmArquivo(List<Cobrador> cobradores, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (Cobrador cobrador : cobradores) {
        writer.write(cobrador.getNome() + ";" +
            cobrador.getMatricula());
        writer.newLine();
      }
      Views.limparTela();
      System.out.println("\n\tCobradores salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }
}
