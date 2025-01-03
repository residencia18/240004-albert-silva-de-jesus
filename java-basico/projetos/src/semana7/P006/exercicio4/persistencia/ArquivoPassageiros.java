package semana7.P006.exercicio4.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.Passageiro;
import semana7.P006.exercicio4.views.Views;

public class ArquivoPassageiros {

  public static List<Passageiro> carregarPassageirosDeArquivo(String nomeArquivo) {

    List<Passageiro> passageiros = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 4) {
          String nome = partes[0];
          String cpf = partes[1];
          String tipoCartao = partes[2];
          String pontoEmbarque = partes[3];

          Passageiro passageiro = new Passageiro(nome, cpf, tipoCartao, pontoEmbarque);
          passageiros.add(passageiro);
        }
      }
      Views.limparTela();
      System.out.println("\n\tPassageiros carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return passageiros;
  }

  public static void salvarPassageirosEmArquivo(List<Passageiro> passageiros, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (Passageiro passageiro : passageiros) {
        writer.write(passageiro.getNome() + ";" +
            passageiro.getCpf() + ";" +
            passageiro.getTipoCartao() + ";" +
            passageiro.getPontoEmbarque());
        writer.newLine();
      }
      Views.limparTela();
      System.out.println("\n\tPassageiros salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }

}
