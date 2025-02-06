/*Leitura de Arquivo: 
Crie um programa que leia um arquivo de texto chamado "entrada.txt". 
Exiba o conteúdo do arquivo na saída padrão (console). */
package exercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {

  public static void main(String[] args) {

    limparTela();
    // Caminho do arquivo
    String caminhoArquivo = "C:\\Users\\alber\\OneDrive\\Documentos\\ProjetosResidencia\\240004-albert-silva-de-jesus\\modulo-03-desenvolvimento-aplicacoes\\thilha-java\\semana3\\solucoes-praticas\\P006\\src\\exercicio1\\bancodedados\\entrada.txt";

    try {
      // Abre o arquivo para leitura
      FileReader fileReader = new FileReader(caminhoArquivo);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      // Lê e exibe o conteúdo do arquivo
      String linha;
      while ((linha = bufferedReader.readLine()) != null) {
        System.out.println(linha);
      }

      // Fecha os recursos
      bufferedReader.close();
    } catch (IOException e) {
      // Trata possíveis erros de leitura do arquivo
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