package semana8.p007.exercicio3.services;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import semana8.p007.exercicio3.entities.Cobrador;
import semana8.p007.exercicio3.persistencia.JsonCobradores;
import semana8.p007.exercicio3.repositories.CobradorRepository;
import semana8.p007.exercicio3.views.Views;

public class CobradorService implements CobradorRepository {

  public static List<Cobrador> cobradores = new ArrayList<>();

  @Override
  public void adicionar(Cobrador cobrador) {
    cobradores.add(cobrador);
  }

  @Override
  public List<Cobrador> getCobradores() {
    return cobradores;
  }

  @Override
  public void cadastrarCobrador() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRO DE COBRADOR =====");

    System.out.print("\n\tNome do Cobrador: ");
    String nome = Views.scan.nextLine();

    System.out.print("\tMatricula do Cobrador: ");
    String matricula = Views.scan.nextLine();

    Cobrador cobrador = new Cobrador(nome, matricula);
    adicionar(cobrador);

    // Escrever no arquivo JSON
    // escreverJson(cobrador);

    System.out.println("\n\tCobrador cadastrado com sucesso!");

    Views.pausar(Views.scan);
  }

  @Override
  public void listarCobradores() {

    Views.limparTela();
    System.out.print("\n\t===== LISTA DE COBRADORES =====");

    for (Cobrador cobrador : cobradores) {
      System.out.println(cobrador.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }

  @Override
  public void carregarArquivoJSON(String nomeArquivo) {
    cobradores = JsonCobradores.carregarCobradoresDeArquivoJSON(nomeArquivo);

    if (cobradores != null) {
      Views.limparTela();
      System.out.println("\n\tCobradores carregados do arquivo: " + nomeArquivo);
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void salvarArquivoJSON(String nomeArquivo) {
    JsonCobradores.salvarCobradoresEmArquivoJSON(cobradores, nomeArquivo);
  }

  private void escreverJson(Cobrador cobrador) {

    try {
      // Ler o arquivo JSON existente, se houver
      JSONArray jsonArray = lerJson();

      // Adicionar o novo cobrador ao JSONArray
      jsonArray.put(cobradorParaJsonObject(cobrador));

      // Escrever a lista atualizada no arquivo JSON
      String filePath = "projetos\\src\\semana8\\p007\\exercicio3\\json\\cobrador.json";
      try (FileWriter fileWriter = new FileWriter(filePath)) {
        fileWriter.write(jsonArray.toString()); // escreve no arquivo o toString do JSONArray
      }

    } catch (IOException e) {
      System.err.println(
          "Erro ao escrever no arquivo JSON. Verifique se o caminho é válido e se você tem permissão para escrever no diretório.");
      e.printStackTrace();
      Views.pausar(Views.scan);
    }
  }

  private JSONArray lerJson() {
    JSONArray jsonArray = new JSONArray();
    try {
      String filePath = "projetos\\src\\semana8\\p007\\exercicio3\\json\\cobrador.json";
      Path path = Paths.get(filePath);

      if (Files.exists(path)) {
        String content = new String(Files.readAllBytes(path));
        if (!content.isEmpty()) {
          jsonArray = new JSONArray(content);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return jsonArray;
  }

  private JSONObject cobradorParaJsonObject(Cobrador cobrador) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("Nome", cobrador.getNome());
    jsonObject.put("Matricula", cobrador.getMatricula());
    return jsonObject;
  }

}