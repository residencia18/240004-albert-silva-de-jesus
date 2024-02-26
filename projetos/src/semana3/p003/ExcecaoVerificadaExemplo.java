package p003;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExcecaoVerificadaExemplo {
  public static void main(String[] args) {

    try {

      BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
      String linha = reader.readLine();
      System.out.println("Conteúdo do arquivo: " + linha);
      reader.close();

    } catch (IOException e) {
      System.out.println("Erro de leitura: " + e.getMessage());
    }
  }
}