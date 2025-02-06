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

import exercicio3.entities.Passageiro;
import exercicio3.views.Views;

public class JsonPassageiros {

  public static List<Passageiro> carregarPassageirosDeArquivoJSON(String nomeArquivo) {
    List<Passageiro> passageiros = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
      StringBuilder jsonContent = new StringBuilder();
      String linha;

      while ((linha = reader.readLine()) != null) {
        jsonContent.append(linha);
      }

      JSONArray jsonArray = new JSONArray(jsonContent.toString());

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonPassageiro = jsonArray.getJSONObject(i);

        String nome = jsonPassageiro.getString("Nome");
        String cpf = jsonPassageiro.getString("CPF");
        String tipoCartao = jsonPassageiro.getString("TipoCartao");
        String pontoEmbarque = jsonPassageiro.getString("PontoEmbarque");

        Passageiro passageiro = new Passageiro(nome, cpf, tipoCartao, pontoEmbarque);
        passageiros.add(passageiro);
      }

      Views.limparTela();
      System.out.println("\n\tPassageiros carregados do arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo JSON: " + e.getMessage());
    }

    return passageiros;
  }

  public static void salvarPassageirosEmArquivoJSON(List<Passageiro> passageiros, String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
      JSONArray jsonArray = new JSONArray();

      for (Passageiro passageiro : passageiros) {
        // Criando um objeto JSON para representar o passageiro
        JSONObject jsonPassageiro = new JSONObject();
        jsonPassageiro.put("Nome", passageiro.getNome());
        jsonPassageiro.put("CPF", passageiro.getCpf());
        jsonPassageiro.put("TipoCartao", passageiro.getTipoCartao());
        jsonPassageiro.put("PontoEmbarque", passageiro.getPontoEmbarque());

        // Adicionando o objeto ao JSONArray
        jsonArray.put(jsonPassageiro);
      }

      // Convertendo o JSONArray em uma string formatada e escrevendo no arquivo
      writer.write(jsonArray.toString(2)); // Indentação de 2 espaços

      Views.limparTela();
      System.out.println("\n\tPassageiros salvos com sucesso no arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo JSON: " + e.getMessage());
    }
  }
}