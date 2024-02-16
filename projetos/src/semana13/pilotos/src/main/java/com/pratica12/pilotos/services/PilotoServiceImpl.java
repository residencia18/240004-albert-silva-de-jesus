package com.pratica12.pilotos.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pratica12.pilotos.entities.Piloto;

@Service
public class PilotoServiceImpl implements PilotoService {

  @Override
  public List<Piloto> carregarPilotos() {

    String path = "projetos\\src\\semana13\\pilotos\\pilotos.csv";
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

    String botao1 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/todos'\">Listar Todos</button>";
    String botao2 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vencedoresBrasileiros'\">Vencedores Brasileiros</button>";
    String botao3 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top5'\">Top 5</button>";
    String botao4 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top10'\">Top 10</button>";
    String botao5 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vitoriasPorPais'\">Vitórias por País</button>";
    String botao6 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/mediaVitoriasPorPais'\">Média de Vitórias por País</button>";

    List<Piloto> list = carregarPilotos();
    return botao1 + botao2 + botao3 + botao4 + botao5 + botao6 + list.toString();
  }

  @Override
  public String vencedoresBrasileiros() {

    String botao1 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/todos'\">Listar Todos</button>";
    String botao2 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vencedoresBrasileiros'\">Vencedores Brasileiros</button>";
    String botao3 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top5'\">Top 5</button>";
    String botao4 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top10'\">Top 10</button>";
    String botao5 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vitoriasPorPais'\">Vitórias por País</button>";
    String botao6 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/mediaVitoriasPorPais'\">Média de Vitórias por País</button>";

    List<Piloto> list = carregarPilotos();

    String resultado = list.stream()
        .filter(piloto -> "Brasil".equals(piloto.getPais()))
        .map(Piloto::toString) // Mapear cada piloto para sua representação em string usando o método toString()
        .collect(Collectors.joining("\n")); // Coleta as representações em string em uma única string separada por nova linha

    return botao1 + botao2 + botao3 + botao4 + botao5 + botao6 + resultado;
  }

  @Override
  public String top5Vencedores() {

    String botao1 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/todos'\">Listar Todos</button>";
    String botao2 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vencedoresBrasileiros'\">Vencedores Brasileiros</button>";
    String botao3 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top5'\">Top 5</button>";
    String botao4 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top10'\">Top 10</button>";
    String botao5 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vitoriasPorPais'\">Vitórias por País</button>";
    String botao6 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/mediaVitoriasPorPais'\">Média de Vitórias por País</button>";

    List<Piloto> list = carregarPilotos();

    String resultado = list.stream()
        .sorted((p1, p2) -> p2.getNumVitorias().compareTo(p1.getNumVitorias())) // Ordenar em ordem decrescente
        .limit(5) // Limitar a 5 elementos
        .map(Piloto::toString) // Mapear cada piloto para sua representação em string usando o método toString()
        .collect(Collectors.joining("\n")); // Coleta as representações em string em uma única string separada por nova linha

    return botao1 + botao2 + botao3 + botao4 + botao5 + botao6 + resultado;
  }

  @Override
  public String top10Vencedores() {

    String botao1 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/todos'\">Listar Todos</button>";
    String botao2 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vencedoresBrasileiros'\">Vencedores Brasileiros</button>";
    String botao3 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top5'\">Top 5</button>";
    String botao4 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/top10'\">Top 10</button>";
    String botao5 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; margin-right: 5px; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/vitoriasPorPais'\">Vitórias por País</button>";
    String botao6 = "<button style=\"background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer; border-radius: 20px;\" onclick=\"window.location.href='/pilotos/mediaVitoriasPorPais'\">Média de Vitórias por País</button>";

    List<Piloto> list = carregarPilotos();

    String resultado = list.stream()
        .sorted((p1, p2) -> p2.getNumVitorias().compareTo(p1.getNumVitorias()))
        .limit(10)
        .map(Piloto::toString)
        .collect(Collectors.joining("\n"));

    return botao1 + botao2 + botao3 + botao4 + botao5 + botao6 + resultado;
  }

  @Override
  public String numeroDeVitoriasPorPais() {
    throw new UnsupportedOperationException("Unimplemented method 'numeroDeVitoriasPorPais'");
  }

  @Override
  public String mediaDeVitoriasPorPais() {
    throw new UnsupportedOperationException("Unimplemented method 'mediaDeVitoriasPorPais'");
  }

}