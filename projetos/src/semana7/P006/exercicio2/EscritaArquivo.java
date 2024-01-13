/*Escrita em Arquivo: 
Crie um programa que solicite ao usuário inserir várias linhas de texto. 
Grave essas linhas em um novo arquivo chamado "saida.txt". */
package semana7.P006.exercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscritaArquivo {
  public static void main(String[] args) {

    limparTela();
    // Caminho do arquivo de saída
    String caminhoArquivoSaida = "projetos/src/semana7/P006/exercicio2/bancodedados/saida.txt";

    try {

      // Cria o FileWriter com o caminho do arquivo de saída
      FileWriter fileWriter = new FileWriter(caminhoArquivoSaida);

      // Cria o BufferedWriter para escrever no arquivo
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      // Cria um Scanner para ler as linhas inseridas pelo usuário
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite as linhas de texto (digite 'fim' para encerrar):");

      // Loop para solicitar as linhas de texto
      String linha;
      while (!(linha = scanner.nextLine()).equalsIgnoreCase("fim")) {
        // Escreve a linha no arquivo
        bufferedWriter.write(linha);
        bufferedWriter.newLine(); // Adiciona uma nova linha
      }

      // Fecha os recursos
      bufferedWriter.close();
      fileWriter.close();
      scanner.close();

      System.out.println("As linhas foram gravadas no arquivo com sucesso.");
    } catch (IOException e) {
      // Trata possíveis erros de escrita no arquivo
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
