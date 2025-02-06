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

import exercicio3.entities.Trajeto;
import exercicio3.entities.Trecho;
import exercicio3.views.Views;

public class JsonTrajetos {

  public static List<Trajeto> carregarTrajetosDeArquivoJSON(String nomeArquivo) {
    List<Trajeto> trajetos = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
      StringBuilder jsonContent = new StringBuilder();
      String linha;

      while ((linha = reader.readLine()) != null) {
        jsonContent.append(linha);
      }

      JSONArray jsonArray = new JSONArray(jsonContent.toString());

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonTrajeto = jsonArray.getJSONObject(i);

        // Aqui, dependendo da estrutura exata do seu JSON, pode ser necessário ajustar
        // as chaves
        String origem = jsonTrajeto.getString("Origem");
        String destino = jsonTrajeto.getString("Destino");
        String pontos = jsonTrajeto.getString("Pontos");
        int intervaloEstimado = jsonTrajeto.getInt("IntervaloEstimado");

        Trecho trecho = new Trecho(origem, destino, pontos, intervaloEstimado);
        Trajeto trajeto = new Trajeto(trecho);
        trajetos.add(trajeto);
      }

      Views.limparTela();
      System.out.println("\n\tTrajetos carregados do arquivo JSON: " + nomeArquivo);

    } catch (IOException | NumberFormatException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo JSON: " + e.getMessage());
    }

    return trajetos;
  }

  public static void salvarTrajetosEmArquivoJSON(List<Trajeto> trajetos, String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
      JSONArray jsonArray = new JSONArray();

      for (Trajeto trajeto : trajetos) {
        Trecho trecho = trajeto.getTrecho();

        // Criando um objeto JSON para representar o trajeto
        JSONObject jsonTrajeto = new JSONObject();
        jsonTrajeto.put("Origem", trecho.getOrigem());
        jsonTrajeto.put("Destino", trecho.getDestino());
        jsonTrajeto.put("Pontos", trecho.getPontos());
        jsonTrajeto.put("IntervaloEstimado", trecho.getIntervaloEstimado());

        // Adicionando o objeto ao JSONArray
        jsonArray.put(jsonTrajeto);
      }

      // Convertendo o JSONArray em uma string formatada e escrevendo no arquivo
      writer.write(jsonArray.toString(2)); // Indentação de 2 espaços

      Views.limparTela();
      System.out.println("\n\tTrajetos salvos com sucesso no arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo JSON: " + e.getMessage());
    }
  }

}