package exercicio3.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import exercicio3.entities.Veiculo;
import exercicio3.views.Views;

public class JsonVeiculos {

  public static List<Veiculo> carregarVeiculosDeArquivoJSON(String nomeArquivo) {
    List<Veiculo> veiculos = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
      StringBuilder jsonContent = new StringBuilder();
      String linha;

      while ((linha = reader.readLine()) != null) {
        jsonContent.append(linha);
      }

      JSONArray jsonArray = new JSONArray(jsonContent.toString());

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonVeiculo = jsonArray.getJSONObject(i);

        String placa = jsonVeiculo.getString("Placa");
        String modelo = jsonVeiculo.getString("Modelo");

        Veiculo veiculo = new Veiculo(placa, modelo);
        veiculos.add(veiculo);
      }

      Views.limparTela();
      System.out.println("\n\tVeículos carregados do arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo JSON: " + e.getMessage());
    }

    return veiculos;
  }

  public static void salvarVeiculosEmArquivoJSON(List<Veiculo> veiculos, String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
      JSONArray jsonArray = new JSONArray();

      for (Veiculo veiculo : veiculos) {
        // Criando um objeto JSON para representar o veículo
        JSONObject jsonVeiculo = new JSONObject();
        jsonVeiculo.put("Placa", veiculo.getPlaca());
        jsonVeiculo.put("Modelo", veiculo.getModelo());

        // Adicionando o objeto ao JSONArray
        jsonArray.put(jsonVeiculo);
      }

      // Convertendo o JSONArray em uma string formatada e escrevendo no arquivo
      writer.write(jsonArray.toString(2)); // Indentação de 2 espaços

      Views.limparTela();
      System.out.println("\n\tVeículos salvos com sucesso no arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo JSON: " + e.getMessage());
    }
  }

}
