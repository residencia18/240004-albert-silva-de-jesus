package semana8.p007.exercicio3.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.Trajeto;
import semana7.P006.exercicio4.entities.Trecho;
import semana7.P006.exercicio4.views.Views;

public class ArquivoTrajetos {

  public static List<Trajeto> carregarTrajetosDeArquivo(String nomeArquivo) {

    List<Trajeto> trajetos = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 4) {

          Trecho trecho = new Trecho(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]));

          Trajeto trajeto = new Trajeto(trecho);

          trajetos.add(trajeto);
        }
      }
      Views.limparTela();
      System.out.println("\n\tTrajetos carregados do arquivo: " + nomeArquivo);

    } catch (IOException | NumberFormatException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return trajetos;
  }

  public static void salvarTrajetosEmArquivo(List<Trajeto> trajetos, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (Trajeto trajeto : trajetos) {
        Trecho trecho = trajeto.getTrecho();

        writer.write(trecho.getOrigem() + ";" +
            trecho.getDestino() + ";" +
            trecho.getPontos() + ";" +
            trecho.getIntervaloEstimado());
        writer.newLine();
      }

      Views.limparTela();
      System.out.println("\n\tTrajetos salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }

}