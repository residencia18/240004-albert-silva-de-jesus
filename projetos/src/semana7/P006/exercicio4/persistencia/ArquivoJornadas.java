package semana7.P006.exercicio4.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.Cobrador;
import semana7.P006.exercicio4.entities.Jornada;
import semana7.P006.exercicio4.entities.Motorista;
import semana7.P006.exercicio4.entities.Trajeto;
import semana7.P006.exercicio4.entities.Trecho;
import semana7.P006.exercicio4.entities.Veiculo;
import semana7.P006.exercicio4.views.Views;

public class ArquivoJornadas {

  public static List<Jornada> carregarDeArquivo(String nomeArquivo) {

    List<Jornada> jornadas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 10) {

          Trecho trecho = new Trecho(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]));
          Trajeto trajeto = new Trajeto(trecho);
          Veiculo veiculo = new Veiculo(partes[4], partes[5]);
          Motorista motorista = new Motorista(partes[6], partes[7]);
          Cobrador cobrador = new Cobrador(partes[8], partes[9]);

          Jornada jornada = new Jornada(trajeto, veiculo, motorista, cobrador);

          jornadas.add(jornada);
        }
      }
      Views.limparTela();
      System.out.println("\n\tJornadas carregadas do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
    }

    return jornadas;
  }

  // public static List<Jornada> carregarDeArquivo(String nomeArquivo) {

  // List<Jornada> jornadas = new ArrayList<>();

  // try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo)))
  // {

  // String linha;

  // while ((linha = reader.readLine()) != null) {

  // String[] partes = linha.split(";");

  // if (partes.length == 10) {
  // // Atribuindo valores a variáveis intermediárias
  // String origem = partes[0];
  // String destino = partes[1];
  // String pontos = partes[2];
  // int intervaloEstimado = Integer.parseInt(partes[3]);
  // String veiculoPlaca = partes[4];
  // String veiculoModelo = partes[5];
  // String motoristaNome = partes[6];
  // String motoristaCnh = partes[7];
  // String cobradorNome = partes[8];
  // String cobradorMatricula = partes[9];

  // // Criando instâncias das classes
  // Trecho trecho = new Trecho(origem, destino, pontos, intervaloEstimado);
  // Trajeto trajeto = new Trajeto(trecho);
  // Veiculo veiculo = new Veiculo(veiculoPlaca, veiculoModelo);
  // Motorista motorista = new Motorista(motoristaNome, motoristaCnh);
  // Cobrador cobrador = new Cobrador(cobradorNome, cobradorMatricula);

  // // Criando instância de Jornada
  // Jornada jornada = new Jornada(trajeto, veiculo, motorista, cobrador);

  // // Adicionando a jornada à lista
  // jornadas.add(jornada);
  // }
  // }
  // Views.limparTela();
  // System.out.println("\n\tJornadas carregadas do arquivo: " + nomeArquivo);

  // } catch (IOException e) {
  // Views.limparTela();
  // System.err.println("\n\tErro ao carregar do arquivo: " + e.getMessage());
  // }

  // return jornadas;
  // }

  public static void salvarEmArquivo(List<Jornada> jornadas, String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (Jornada jornada : jornadas) {
        Trecho trecho = jornada.getTrajeto().getTrecho();
        Veiculo veiculo = jornada.getVeiculo();
        Motorista motorista = jornada.getMotorista();
        Cobrador cobrador = jornada.getCobrador();

        writer.write(trecho.getOrigem() + ";" +
            trecho.getDestino() + ";" +
            trecho.getPontos() + ";" +
            trecho.getIntervaloEstimado() + ";" +
            veiculo.getPlaca() + ";" +
            veiculo.getModelo() + ";" +
            motorista.getNome() + ";" +
            motorista.getCnh() + ";" +
            cobrador.getNome() + ";" +
            cobrador.getMatricula());
        writer.newLine();
      }

      Views.limparTela();
      System.out.println("\n\tJornadas salvas com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      Views.limparTela();
      System.err.println("\n\nErro ao salvar no arquivo: " + e.getMessage());
    }
  }

}
