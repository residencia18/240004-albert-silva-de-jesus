package semana8.p007.exercicio2;

import org.json.JSONArray;
import org.json.JSONObject;

import semana8.p007.exercicio1.entities.Estudante;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeituraDeArquivo {

  public static void main(String[] args) {

    limparTela();
    // Reconstrui a lista de estudantes a partir do arquivo "estudantes.json"
    List<Estudante> estudantes = lerArquivo("projetos\\src\\semana8\\p007\\exercicio1\\json\\estudantes.json");

    // Exibir o conteúdo da lista de estudantes
    for (Estudante estudante : estudantes) {
      System.out.println("Nome: " + estudante.getNome());
      System.out.println("CPF: " + estudante.getCpf());
      System.out.println("CRA: " + estudante.getCra());
      System.out.println("Ano de Admissão: " + estudante.getAnoDeAdmissao());
      System.out.println();
    }
  }

  private static List<Estudante> lerArquivo(String caminhoArquivo) {
    List<Estudante> estudantes = new ArrayList<>();

    try {
      // Ler todo o conteúdo do arquivo em uma string
      Path path = Paths.get(caminhoArquivo);
      String conteudo = Files.readString(path, StandardCharsets.UTF_8);

      // Converter o conteúdo do arquivo em um array JSON
      JSONArray jsonArray = new JSONArray(conteudo);

      // Iterar sobre o array JSON e reconstruir a lista de estudantes
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject estudanteJson = jsonArray.getJSONObject(i);

        Estudante estudante = new Estudante();
        estudante.setNome(estudanteJson.getString("Nome"));
        estudante.setCpf(estudanteJson.getString("CPF"));
        estudante.setCra((float) estudanteJson.getDouble("CRA"));
        estudante.setAnoDeAdmissao(estudanteJson.getInt("AnoDeAdmissao"));

        estudantes.add(estudante);
      }
    } catch (IOException e) {
      System.err.println("Erro ao ler o arquivo.");
      e.printStackTrace();
    }

    return estudantes;
  }

  public static void limparTela() {
    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (final Exception e) {
      // Trata exceções (pode ser uma exceção de interrupção)
      e.printStackTrace();
    }
  }
}
