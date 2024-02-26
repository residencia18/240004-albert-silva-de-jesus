/*Jogo de Adivinhação: 
Crie um jogo em que o programa gera um número aleatório entre 1 e 100, e o usuário tenta adivinhar qual é o número. 
O programa deve fornecer dicas para o usuário, como "muito alto" ou "muito baixo", até que o usuário adivinhe corretamente. */
package p002; 

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhacao {

  public static void main(String[] args) throws Exception {

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    int num = 0;
    int numAleatorio = random.nextInt(100) + 1;

    do {

      limparTela();
      System.out.println("\n\tBem-vindo ao Jogo de Adivinhação!");
      System.out.print("\n\tInforme um número, para adivinhar: ");
      num = scan.nextInt();

      if (num > numAleatorio) {
        limparTela();
        System.out.print("\n\tOps, número informado muito alto!...\n");
        pausa(scan);

      } else {

        if (num < numAleatorio) {
          limparTela();
          System.out.print("\n\tOps, número informado é menor!...\n");
          pausa(scan);

        } else {

          if (num == numAleatorio) {
            limparTela();
            System.out.print("\n\tVocê acertou, parabens!...\n");
            pausa(scan);
            scan.close();
            System.exit(0);
          }
        }
      }
    } while (num != numAleatorio);
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

  public static void pausa(Scanner scan) {
    System.out.print("\n\tPressione ENTER para continuar...");
    scan.nextLine();
    scan.nextLine();
  }
}
