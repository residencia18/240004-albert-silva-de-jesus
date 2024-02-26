/*. Conversor de Moedas: 
Crie um programa que converta uma quantidade em dólares para outra moeda (por exemplo, euros ou reais). 
Peça ao usuário que insira a taxa de câmbio e a quantidade em dólares. Em seguida, calcule e exiba o valor convertido.  */
package p002;

import java.util.Scanner;

public class ConversorDeMoeda {

  public static void main(String[] args) throws Exception {

    Scanner scan = new Scanner(System.in);

    limparTela();
    System.out.println("\n\t==========CONVERSOR DE MOEDA==========");
    System.out.print("\n\tInsira a taxa de câmbio para o dolar: ");
    double taxaCambio = scan.nextDouble();

    System.out.print("\n\tDigite a quantidade de dólares: ");
    double quantidadeDolares = scan.nextDouble();

    double reais = quantidadeDolares * taxaCambio;

    System.out.printf("\n\tO valor em reais é: R$ %.2f", reais);
    System.out.println("\n\t=======================================\n");

    scan.close();
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
