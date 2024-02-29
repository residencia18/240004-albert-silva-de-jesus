/*Conversor de Temperatura: 
Escreva um programa que converta a temperatura de graus Celsius para Fahrenheit ou vice-versa, dependendo da escolha do usuário. 
O programa deve solicitar ao usuário que insira a temperatura e a unidade de origem (Celsius ou Fahrenheit) e, em seguida, realizar 
a conversão e exibir o resultado. A fórmula para a conversão de Celsius para Fahrenheit é: F = (C * 9/5) + 32, onde F é a temperatura em 
Fahrenheit e C é a temperatura em Celsius.  */
package semana3.atvemsala.exercicio5;

import java.util.Scanner;

public class ConversorDeTemperatura {

  public static void main(String[] args) throws Exception {

    Scanner scan = new Scanner(System.in);

    do {

      limparTela();
      System.out.print("\n\t==========CONVERSOR DE TEMPERATURA==========");
      System.out.print("\n\n\tDigite a temperatura: ");
      double temperatura = scan.nextDouble();

      System.out.print("\n\tDigite a unidade de origem, [f] Fahrenheit ou [c] Celsius: ");
      String unidade = scan.next();

      limparTela();
      if (unidade.equalsIgnoreCase("c")) {

        double fahrenheit = celsiusParaFahrenheit(temperatura);
        System.out.printf("\n\tTemperatura em Fahrenheit: %.0fºC\n", fahrenheit);
        pausa(scan);

      } else if (unidade.equalsIgnoreCase("f")) {

        double celsius = fahrenheitParaCelsius(temperatura);
        System.out.printf("\n\tTemperatura em Celsius: %.0fºF\n", celsius);
        pausa(scan);

      } else {
        System.out.println("\n\tUnidade de origem inválida.");
        pausa(scan);
      }

      limparTela();
      System.out.print("\n\tDeseja continuar? [s] Sim ou [n] Não: ");
      char continuar = scan.next().charAt(0);

      if (continuar == 'n') {
        System.out.println("\n\tOps, programa finalizado!...");
        System.exit(0);
      }

    } while (true);

  }

  public static double celsiusParaFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
  }

  public static double fahrenheitParaCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
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
