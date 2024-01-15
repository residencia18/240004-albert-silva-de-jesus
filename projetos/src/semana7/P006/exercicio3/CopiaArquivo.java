/*Crie um programa que copie o conteúdo de um arquivo chamado "origem.txt" 
para um novo arquivo chamado "destino.txt". */
package semana7.P006.exercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;

public class CopiaArquivo {
  public static void main(String[] args) {
    
    limparTela();
    // Caminho dos arquivos de origem e destino
    String caminhoOrigem = "projetos/src/semana7/P006/exercicio3/bancodedados/origem.txt";
    String caminhoDestino = "projetos/src/semana7/P006/exercicio3/bancodedados/destino.txt";

    // Solicita ao usuário para escrever no arquivo de origem
    escreverNoArquivo(caminhoOrigem);

    try {
      
      // Verifica se o arquivo de destino existe, se não, cria-o
      Path pathDestino = Paths.get(caminhoDestino);
      if (!Files.exists(pathDestino)) {
        Files.createFile(pathDestino);
      }

      // Abre o arquivo de origem para leitura
      FileReader fileReaderOrigem = new FileReader(caminhoOrigem);
      BufferedReader bufferedReaderOrigem = new BufferedReader(fileReaderOrigem);

      // Abre o arquivo de destino para escrita
      FileWriter fileWriterDestino = new FileWriter(caminhoDestino);
      BufferedWriter bufferedWriterDestino = new BufferedWriter(fileWriterDestino);

      // Copia linha por linha da origem para o destino
      String linha;
      while ((linha = bufferedReaderOrigem.readLine()) != null) {
        bufferedWriterDestino.write(linha);
        bufferedWriterDestino.newLine(); // Adiciona uma nova linha
      }

      // Fecha os recursos
      bufferedReaderOrigem.close();
      bufferedWriterDestino.close();

      System.out.println("Conteúdo copiado de origem.txt para destino.txt com sucesso.");
    } catch (IOException e) {
      // Trata possíveis erros de leitura ou escrita
      e.printStackTrace();
    }
  }

  // Solicita ao usuário para escrever no arquivo
  private static void escreverNoArquivo(String caminhoArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {

      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite as linhas de texto para o arquivo (digite 'fim' para encerrar):");

      String linha;
      while (!(linha = scanner.nextLine()).equalsIgnoreCase("fim")) {
        writer.write(linha);
        writer.newLine();
      }

      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
