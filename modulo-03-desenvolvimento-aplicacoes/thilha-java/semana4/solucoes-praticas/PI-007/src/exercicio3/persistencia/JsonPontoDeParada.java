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

import exercicio3.entities.PontosDeParada;
import exercicio3.views.Views;

public class JsonPontoDeParada {

  public static List<PontosDeParada> carregarPontosDeParadaDeArquivoJSON(String nomeArquivo) {
    List<PontosDeParada> pontosDeParadas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
      StringBuilder jsonContent = new StringBuilder();
      String linha;

      while ((linha = reader.readLine()) != null) {
        jsonContent.append(linha);
      }

      JSONArray jsonArray = new JSONArray(jsonContent.toString());

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonPontoDeParada = jsonArray.getJSONObject(i);

        String embarque = jsonPontoDeParada.getString("Embarque");
        String desembarque = jsonPontoDeParada.getString("Desembarque");
        int distanciaEntreParadas = jsonPontoDeParada.getInt("DistanciaEntreParadas");

        PontosDeParada pontoDeParada = new PontosDeParada(embarque, desembarque, distanciaEntreParadas);
        pontosDeParadas.add(pontoDeParada);
      }

      Views.limparTela();
      System.out.println("\n\tPontos de Parada carregados do arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo JSON: " + e.getMessage());
    }

    return pontosDeParadas;
  }

  public static void salvarPontosDeParadaEmArquivoJSON(List<PontosDeParada> pontosDeParadas, String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
      JSONArray jsonArray = new JSONArray();

      for (PontosDeParada pontoDeParada : pontosDeParadas) {
        // Criando um objeto JSON para representar o ponto de parada
        JSONObject jsonPontoDeParada = new JSONObject();
        jsonPontoDeParada.put("Embarque", pontoDeParada.getEmbarque());
        jsonPontoDeParada.put("Desembarque", pontoDeParada.getDesembarque());
        jsonPontoDeParada.put("DistanciaEntreParadas", pontoDeParada.getDistanciaEntreParadas());

        // Adicionando o objeto ao JSONArray
        jsonArray.put(jsonPontoDeParada);
      }

      // Convertendo o JSONArray em uma string formatada e escrevendo no arquivo
      writer.write(jsonArray.toString(2)); // Indentação de 2 espaços

      Views.limparTela();
      System.out.println("\n\tPontos de Parada salvos com sucesso no arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo JSON: " + e.getMessage());
    }
  }
}