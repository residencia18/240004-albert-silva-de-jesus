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

import exercicio3.entities.Motorista;
import exercicio3.views.Views;

public class JsonMotoristas {

  public static List<Motorista> carregarMotoristasDeArquivoJSON(String nomeArquivo) {
    List<Motorista> motoristas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
      StringBuilder jsonContent = new StringBuilder();
      String linha;

      while ((linha = reader.readLine()) != null) {
        jsonContent.append(linha);
      }

      JSONArray jsonArray = new JSONArray(jsonContent.toString());

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonMotorista = jsonArray.getJSONObject(i);

        String nome = jsonMotorista.getString("Nome");
        String cnh = jsonMotorista.getString("CNH");

        Motorista motorista = new Motorista(nome, cnh);
        motoristas.add(motorista);
      }

      Views.limparTela();
      System.out.println("\n\tMotoristas carregados do arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo JSON: " + e.getMessage());
    }

    return motoristas;
  }

  public static void salvarMotoristasEmArquivoJSON(List<Motorista> motoristas, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
      JSONArray jsonArray = new JSONArray();

      for (Motorista motorista : motoristas) {
        // Criando um objeto JSON para representar o motorista
        JSONObject jsonMotorista = new JSONObject();
        jsonMotorista.put("Nome", motorista.getNome());
        jsonMotorista.put("CNH", motorista.getCnh());

        // Adicionando o objeto ao JSONArray
        jsonArray.put(jsonMotorista);
      }

      // Convertendo o JSONArray em uma string formatada e escrevendo no arquivo
      writer.write(jsonArray.toString(2)); // Indentação de 2 espaços

      Views.limparTela();
      System.out.println("\n\tMotoristas salvos com sucesso no arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo JSON: " + e.getMessage());
    }
  }

}
