package semana8.p007.exercicio3.persistencia;

import org.json.JSONArray;
import org.json.JSONObject;

import semana8.p007.exercicio3.entities.Cobrador;
import semana8.p007.exercicio3.views.Views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonCobradores {

  public static List<Cobrador> carregarCobradoresDeArquivoJSON(String nomeArquivo) {

    List<Cobrador> cobradores = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      // Lê todo o conteúdo do arquivo em uma string
      StringBuilder jsonContent = new StringBuilder();
      String linha;
      while ((linha = reader.readLine()) != null) {
        jsonContent.append(linha);
      }

      // Converte a string para um JSONArray
      JSONArray jsonArray = new JSONArray(jsonContent.toString());

      // Itera sobre o JSONArray e adiciona os cobradores à lista
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonCobrador = jsonArray.getJSONObject(i);

        String nome = jsonCobrador.getString("Nome");
        String matricula = jsonCobrador.getString("Matricula");

        Cobrador cobrador = new Cobrador(nome, matricula);
        cobradores.add(cobrador);
      }

      Views.limparTela();
      System.out.println("\n\tCobradores carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return cobradores;
  }

  public static void salvarCobradoresEmArquivoJSON(List<Cobrador> cobradores, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      JSONArray jsonArray = new JSONArray();

      for (Cobrador cobrador : cobradores) {
        // Criando um objeto JSON para representar o cobrador
        JSONObject jsonCobrador = new JSONObject();
        jsonCobrador.put("Nome", cobrador.getNome());
        jsonCobrador.put("Matricula", cobrador.getMatricula());

        // Adicionando o objeto ao JSONArray
        jsonArray.put(jsonCobrador);
      }

      // Convertendo o JSONArray em uma string formatada e escrevendo no arquivo
      writer.write(jsonArray.toString(2)); // O método toString() retorna uma string formatada

      Views.limparTela();
      System.out.println("\n\tCobradores salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }

  public static void excluirCobradorJSON(String nomeArquivo, int indiceParaExcluir) {
    // Carrega a lista de cobradores do arquivo
    List<Cobrador> cobradores = carregarCobradoresDeArquivoJSON(nomeArquivo);

    // Verifica se o índice é válido
    if (indiceParaExcluir >= 0 && indiceParaExcluir < cobradores.size()) {
      // Remove o cobrador no índice especificado
      cobradores.remove(indiceParaExcluir);

      // Salva a lista atualizada no arquivo JSON
      salvarCobradoresEmArquivoJSON(cobradores, nomeArquivo);

      Views.limparTela();
      System.out.println("\n\tCobrador excluído com sucesso, do arquivo JSON!");
    } else {
      Views.limparTela();
      System.err.println("\n\tÍndice inválido para exclusão.");
    }
  }

  public static void alterarCobradorJSON(String nomeArquivo, int indiceParaAlterar, Cobrador novoCobrador) {
    // Carregar a lista de cobradores do arquivo
    List<Cobrador> cobradores = carregarCobradoresDeArquivoJSON(nomeArquivo);

    // Verificar se o índice é válido
    if (indiceParaAlterar >= 0 && indiceParaAlterar < cobradores.size()) {
      // Substituir o cobrador no índice especificado pelo novo objeto
      cobradores.set(indiceParaAlterar, novoCobrador);

      // Salvar a lista atualizada no arquivo JSON
      salvarCobradoresEmArquivoJSON(cobradores, nomeArquivo);

      Views.limparTela();
      System.out.println("\n\tCobrador alterado com sucesso, do arquivo JSON!");
    } else {
      Views.limparTela();
      System.err.println("\n\tÍndice inválido para alteração.");
    }
  }

}
