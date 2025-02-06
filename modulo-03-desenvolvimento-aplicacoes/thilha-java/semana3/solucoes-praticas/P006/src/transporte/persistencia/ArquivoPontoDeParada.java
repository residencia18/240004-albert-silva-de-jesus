package transporte.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import transporte.entities.PontosDeParada;
import transporte.views.Views;

public class ArquivoPontoDeParada {

  public static List<PontosDeParada> carregarPontosDeParadaDeArquivo(String nomeArquivo) {

    List<PontosDeParada> pontosDeParadas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 3) {
          String embarque = partes[0];
          String desembarque = partes[1];
          int distanciaEntreParadas = Integer.parseInt(partes[2]);

          PontosDeParada pontoDeParada = new PontosDeParada(embarque, desembarque, distanciaEntreParadas);
          pontosDeParadas.add(pontoDeParada);
        }
      }
      Views.limparTela();
      System.out.println("\n\tPontos de Parada carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return pontosDeParadas;
  }

  public static void salvarPontosDeParadaEmArquivo(List<PontosDeParada> pontosDeParadas, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (PontosDeParada pontoDeParada : pontosDeParadas) {
        writer.write(pontoDeParada.getEmbarque() + ";" +
            pontoDeParada.getDesembarque() + ";" +
            pontoDeParada.getDistanciaEntreParadas());
        writer.newLine();
      }
      Views.limparTela();
      System.out.println("\n\tPontos de Parada salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }

}
