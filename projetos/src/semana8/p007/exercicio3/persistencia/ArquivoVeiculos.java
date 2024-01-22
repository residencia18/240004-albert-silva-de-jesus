package semana8.p007.exercicio3.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import semana8.p007.exercicio3.entities.Veiculo;
import semana8.p007.exercicio3.views.Views;

public class ArquivoVeiculos {

  public static List<Veiculo> carregarVeiculosDeArquivo(String nomeArquivo) {

    List<Veiculo> veiculos = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 2) {
          String placa = partes[0];
          String modelo = partes[1];

          Veiculo veiculo = new Veiculo(placa, modelo);
          veiculos.add(veiculo);
        }
      }
      Views.limparTela();
      System.out.println("\n\tVeículos carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return veiculos;
  }

  public static void salvarVeiculosEmArquivo(List<Veiculo> veiculos, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (Veiculo veiculo : veiculos) {
        writer.write(veiculo.getPlaca() + ";" +
            veiculo.getModelo());
        writer.newLine();
      }
      Views.limparTela();
      System.out.println("\n\tVeículos salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }

}
