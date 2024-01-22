package semana8.p007.exercicio1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import semana8.p007.exercicio1.entities.Estudante;

public class Program {

  public static void main(String[] args) {

    limparTela();
    List<Estudante> estudantes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Solicita ao usuário inserir dados de vários estudantes
    while (true) {
      Estudante estudante = new Estudante();

      System.out.println("Inserir dados do estudante:");

      System.out.print("Nome: ");
      estudante.setNome(scanner.nextLine());

      System.out.print("CPF: ");
      estudante.setCpf(scanner.nextLine());

      System.out.print("CRA: ");
      estudante.setCra(Float.parseFloat(scanner.nextLine()));

      System.out.print("Ano de Admissão: ");
      estudante.setAnoDeAdmissao(Integer.parseInt(scanner.nextLine()));

      estudantes.add(estudante);

      System.out.print("Deseja inserir outro estudante? (s/n): ");
      String resposta = scanner.nextLine().toLowerCase();

      if (!resposta.equals("s")) {
        break;
      }
    }

    // Converte a lista de estudantes para um JSONArray
    JSONArray jsonArray = new JSONArray();
    for (Estudante estudante : estudantes) {

      JSONObject estudanteJson = new JSONObject();
      estudanteJson.put("Nome", estudante.getNome());
      estudanteJson.put("CPF", estudante.getCpf());
      estudanteJson.put("CRA", estudante.getCra());
      estudanteJson.put("AnoDeAdmissao", estudante.getAnoDeAdmissao());
      jsonArray.put(estudanteJson);
    }

    // Grava os dados no arquivo "estudantes.json"
    try (FileWriter writer = new FileWriter("projetos\\src\\semana8\\p007\\exercicio1\\json\\estudantes.json")) {

      writer.write(jsonArray.toString());
      System.out.println("Dados dos estudantes foram gravados em estudantes.json.");

    } catch (IOException e) {
      System.err.println("Erro ao gravar no arquivo.");
      e.printStackTrace();
    }

    scanner.close();
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
