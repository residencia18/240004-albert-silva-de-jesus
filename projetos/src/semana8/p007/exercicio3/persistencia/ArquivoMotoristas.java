package semana8.p007.exercicio3.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.Motorista;
import semana7.P006.exercicio4.views.Views;

public class ArquivoMotoristas {

  public static List<Motorista> carregarMotoristasDeArquivo(String nomeArquivo) {

    List<Motorista> motoristas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 2) {
          String nome = partes[0];
          String cnh = partes[1];

          Motorista motorista = new Motorista(nome, cnh);
          motoristas.add(motorista);
        }
      }
      Views.limparTela();
      System.out.println("\n\tMotoristas carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return motoristas;
  }

  public static void salvarMotoristasEmArquivo(List<Motorista> motoristas, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (Motorista motorista : motoristas) {
        writer.write(motorista.getNome() + ";" +
            motorista.getCnh());
        writer.newLine();
      }
      Views.limparTela();
      System.out.println("\n\tMotoristas salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }

}
