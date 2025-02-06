package com.pratica12.pilotos.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pratica12.pilotos.entities.Piloto;

@Service
public class PilotoServiceImpl implements PilotoService {

  @Override
  public List<Piloto> carregarPilotos() {

    String path = "C:\\Users\\alber\\OneDrive\\Documentos\\ProjetosResidencia\\240004-albert-silva-de-jesus\\modulo-03-desenvolvimento-aplicacoes\\thilha-java\\semana7\\solucoes-praticas\\PI-012\\pilotos\\pilotos.csv";
    List<Piloto> list = new ArrayList<>();
    BufferedReader br = null;

    try {

      br = new BufferedReader(new FileReader(path));

      String line; // Declarado aqui para que a leitura do cabeçalho seja descartada
      br.readLine(); // Ler o cabeçalho do arquivo e descartá-lo

      while ((line = br.readLine()) != null) {
        String[] fields = line.split(";");

        // Verificar se há dados suficientes na linha
        if (fields.length >= 3) {
          String pais = fields[0];
          String nome = fields[1];
          Integer numVitorias = Integer.parseInt(fields[2]);
          list.add(new Piloto(pais, nome, numVitorias));

        } else {
          // Tratar o caso de uma linha com formato inválido
          System.out.println("Formato de linha inválido: " + line);
        }
      }
    } catch (IOException e) {
      // Lidar com exceções de E/S
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());

    } catch (NumberFormatException e) {
      // Lidar com exceções de conversão de número
      System.out.println("Erro ao converter número: " + e.getMessage());

    } finally {
      try {
        if (br != null) {
          br.close();
        }

      } catch (IOException e) {
        System.out.println("Erro ao fechar o BufferedReader: " + e.getMessage());
      }
    }

    return list;
  }

  @Override
  public String findAll() {

    List<Piloto> list = carregarPilotos();
    for (int i = 0; i < list.size(); i++) {
      list.get(i).setNumero(i + 1);
    }

    return botoes("Todos os Pilotos") + list.toString();
  }

  @Override
  public String vencedoresBrasileiros() {

    List<Piloto> list = carregarPilotos();
    Integer count = 0;
    for (Piloto piloto : list) {
      if ("Brasil".equals(piloto.getPais())) {
        piloto.setNumero(++count);
      }
    }

    String resultado = list.stream()
        .filter(piloto -> "Brasil".equals(piloto.getPais()))
        .map(Piloto::toString) // Mapear cada piloto para sua representação em string usando o método
                               // toString()
        .collect(Collectors.joining("\n")); // Coleta as representações em string em uma única string separada por nova
                                            // linha

    return botoes("Vencedores Brazileiros") + resultado;
  }

  @Override
  public String top5Vencedores() {

    List<Piloto> list = carregarPilotos();
    Integer count = 0;
    for (Piloto piloto : list) {
      piloto.setNumero(++count);
    }

    String resultado = list.stream()
        .sorted((p1, p2) -> p2.getNumVitorias().compareTo(p1.getNumVitorias())) // Ordenar em ordem decrescente
        .limit(5) // Limitar a 5 elementos
        .map(Piloto::toString) // Mapear cada piloto para sua representação em string usando o método
                               // toString()
        .collect(Collectors.joining("\n")); // Coleta as representações em string em uma única string separada por nova
                                            // linha

    return botoes("Top 5 Vencedores") + resultado;
  }

  @Override
  public String top10Vencedores() {

    List<Piloto> list = carregarPilotos();
    Integer count = 0;
    for (Piloto piloto : list) {
      piloto.setNumero(++count);
    }

    String resultado = list.stream().sorted((p1, p2) -> p2.getNumVitorias().compareTo(p1.getNumVitorias()))
        .limit(10)
        .map(Piloto::toString)
        .collect(Collectors.joining("\n"));

    return botoes("Top 10 Vencedores") + resultado;
  }

  @Override
  public String numeroDeVitoriasPorPais() {

    List<Piloto> list = carregarPilotos();

    // Agrupar por país e somar o número de vitórias
    Map<String, Integer> vitoriasPorPais = calcularVitoriasPorPais(list);

    // Construir a representação em string formatada
    StringBuilder sb = new StringBuilder();

    sb.append(formatarVitoriasPorPais(vitoriasPorPais));

    return botoes("Número de Vitórias por País") + sb.toString();
  }

  @Override
  public String mediaDeVitoriasPorPais() {

    List<Piloto> list = carregarPilotos();

    // Agrupar por país e calcular a média de vitórias
    Map<String, Double> mediaVitoriasPorPais = calcularMediaVitoriasPorPais(list);

    // Construir a representação em string formatada
    StringBuilder sb = new StringBuilder();

    sb.append(formatarMediaVitoriasPorPais(mediaVitoriasPorPais));

    return botoes("Média de Vitórias por País") + sb.toString();
  }

  private Map<String, Integer> calcularVitoriasPorPais(List<Piloto> pilotos) {
    return pilotos.stream()
        .collect(Collectors.groupingBy(Piloto::getPais, Collectors.summingInt(Piloto::getNumVitorias)));
  }

  private String formatarVitoriasPorPais(Map<String, Integer> vitoriasPorPais) {

    Integer count = 0;
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Integer> entry : vitoriasPorPais.entrySet()) {
      count++;
      sb.append(
          "<div style=\"padding: 10px; border: 1px solid #ccc; margin-bottom: 10px; background-color:#cecece;\">");
      sb.append("<p><strong>Número:</strong> ").append(count + "º").append("</p>");
      sb.append("<p><strong>País:</strong> ").append(entry.getKey()).append("</p>");
      sb.append(String.format("<p><strong>Número de Vitórias:</strong> %.2f</p>", (double) entry.getValue()));
      sb.append("</div>");
    }
    return sb.toString();
  }

  private Map<String, Double> calcularMediaVitoriasPorPais(List<Piloto> pilotos) {
    return pilotos.stream()
        .collect(Collectors.groupingBy(Piloto::getPais, Collectors.averagingDouble(Piloto::getNumVitorias)));
  }

  private String formatarMediaVitoriasPorPais(Map<String, Double> mediaVitoriasPorPais) {

    Integer count = 0;
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Double> entry : mediaVitoriasPorPais.entrySet()) {
      count++;
      sb.append(
          "<div style=\"padding: 10px; border: 1px solid #ccc; margin-bottom: 10px; background-color:#cecece;\">");
      sb.append("<p><strong>Número:</strong> ").append(count + "º").append("</p>");
      sb.append("<p><strong>País:</strong> ").append(entry.getKey()).append("</p>");
      sb.append(String.format("<p><strong>Média de Vitórias:</strong> %.2f </p>", ((Double) entry.getValue())));
      sb.append("</div>");
    }
    return sb.toString();
  }

  public String botoes(String tituloDaPagina) {
    String titulo = "<h1 style=\"text-align: center;\">" + tituloDaPagina + "</h1>";
    String botao1 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/todos'\">Listar Todos</button>";
    String botao2 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vencedoresBrasileiros'\">Vencedores Brasileiros</button>";
    String botao3 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top5'\">Top 5</button>";
    String botao4 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top10'\">Top 10</button>";
    String botao5 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vitoriasPorPais'\">Vitórias por País</button>";
    String botao6 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/mediaVitoriasPorPais'\">Média de Vitórias por País</button>";
    String br = "<br><br>";

    return titulo + botao1 + botao2 + botao3 + botao4 + botao5 + botao6 + br;
  }

}