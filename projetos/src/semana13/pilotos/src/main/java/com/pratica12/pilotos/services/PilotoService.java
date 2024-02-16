package com.pratica12.pilotos.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pratica12.pilotos.entities.Piloto;

@Service
public class PilotoService {

  public List<Piloto> getPilotos() {

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

    } 
    finally {
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
}
