package semana8.p007.exercicio3.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import semana8.p007.exercicio3.entities.Cobrador;
import semana8.p007.exercicio3.entities.Jornada;
import semana8.p007.exercicio3.entities.Motorista;
import semana8.p007.exercicio3.entities.Trajeto;
import semana8.p007.exercicio3.entities.Trecho;
import semana8.p007.exercicio3.entities.Veiculo;
import semana8.p007.exercicio3.views.Views;

public class JsonJornadas {

  public static List<Jornada> carregarDeArquivoJSON(String nomeArquivo) {
    List<Jornada> jornadas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
      StringBuilder jsonContent = new StringBuilder();
      String linha;

      while ((linha = reader.readLine()) != null) {
        jsonContent.append(linha);
      }

      JSONArray jsonArray = new JSONArray(jsonContent.toString());

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonJornada = jsonArray.getJSONObject(i);

        // Dependendo da estrutura exata do seu JSON, pode ser necessário ajustar as
        // chaves
        JSONObject jsonTrecho = jsonJornada.getJSONObject("Trecho");
        String origem = jsonTrecho.getString("Origem");
        String destino = jsonTrecho.getString("Destino");
        String pontos = jsonTrecho.getString("Pontos");
        int intervaloEstimado = jsonTrecho.getInt("IntervaloEstimado");

        Trecho trecho = new Trecho(origem, destino, pontos, intervaloEstimado);
        Trajeto trajeto = new Trajeto(trecho);

        JSONObject jsonVeiculo = jsonJornada.getJSONObject("Veiculo");
        String placaVeiculo = jsonVeiculo.getString("Placa");
        String modeloVeiculo = jsonVeiculo.getString("Modelo");
        Veiculo veiculo = new Veiculo(placaVeiculo, modeloVeiculo);

        JSONObject jsonMotorista = jsonJornada.getJSONObject("Motorista");
        String nomeMotorista = jsonMotorista.getString("Nome");
        String cnhMotorista = jsonMotorista.getString("Cnh");
        Motorista motorista = new Motorista(nomeMotorista, cnhMotorista);

        JSONObject jsonCobrador = jsonJornada.getJSONObject("Cobrador");
        String nomeCobrador = jsonCobrador.getString("Nome");
        String matriculaCobrador = jsonCobrador.getString("Matricula");
        Cobrador cobrador = new Cobrador(nomeCobrador, matriculaCobrador);

        Jornada jornada = new Jornada(trajeto, veiculo, motorista, cobrador);
        jornadas.add(jornada);
      }

      Views.limparTela();
      System.out.println("\n\tJornadas carregadas do arquivo JSON: " + nomeArquivo);

    } catch (IOException | NumberFormatException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo JSON: " + e.getMessage());
    }

    return jornadas;
  }

  public static void salvarEmArquivoJSON(List<Jornada> jornadas, String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
      JSONArray jsonArray = new JSONArray();

      for (Jornada jornada : jornadas) {
        // Criando um objeto JSON para representar a jornada
        JSONObject jsonJornada = new JSONObject();

        // Adicionando o objeto "Trecho" ao JSON
        Trecho trecho = jornada.getTrajeto().getTrecho();
        JSONObject jsonTrecho = new JSONObject();
        jsonTrecho.put("Origem", trecho.getOrigem());
        jsonTrecho.put("Destino", trecho.getDestino());
        jsonTrecho.put("Pontos", trecho.getPontos());
        jsonTrecho.put("IntervaloEstimado", trecho.getIntervaloEstimado());
        jsonJornada.put("Trecho", jsonTrecho);

        // Adicionando o objeto "Veiculo" ao JSON
        Veiculo veiculo = jornada.getVeiculo();
        JSONObject jsonVeiculo = new JSONObject();
        jsonVeiculo.put("Placa", veiculo.getPlaca());
        jsonVeiculo.put("Modelo", veiculo.getModelo());
        jsonJornada.put("Veiculo", jsonVeiculo);

        // Adicionando o objeto "Motorista" ao JSON
        Motorista motorista = jornada.getMotorista();
        JSONObject jsonMotorista = new JSONObject();
        jsonMotorista.put("Nome", motorista.getNome());
        jsonMotorista.put("Cnh", motorista.getCnh());
        jsonJornada.put("Motorista", jsonMotorista);

        // Adicionando o objeto "Cobrador" ao JSON
        Cobrador cobrador = jornada.getCobrador();
        JSONObject jsonCobrador = new JSONObject();
        jsonCobrador.put("Nome", cobrador.getNome());
        jsonCobrador.put("Matricula", cobrador.getMatricula());
        jsonJornada.put("Cobrador", jsonCobrador);

        // Adicionando o objeto jornada ao JSONArray
        jsonArray.put(jsonJornada);
      }

      // Convertendo o JSONArray em uma string formatada e escrevendo no arquivo
      writer.write(jsonArray.toString(2)); // Indentação de 2 espaços

      Views.limparTela();
      System.out.println("\n\tJornadas salvas com sucesso no arquivo JSON: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo JSON: " + e.getMessage());
    }
  }

}
