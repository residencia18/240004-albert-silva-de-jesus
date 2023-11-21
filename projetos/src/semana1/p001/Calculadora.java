/*Calculadora Simples: 
Crie um programa que funcione como uma calculadora simples. O programa deve pedir ao usuário que insira dois números e depois escolha uma 
operação (adição, subtração, multiplicação ou divisão). Em seguida, o programa deve calcular o resultado e exibi-lo.  */

package p001;

import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Calculadora {

  public static void main(String[] argas) {

    Scanner scan = new Scanner(System.in);

    int x = 0;
    int y = 0;

    while (true) {

      switch (menuCalculadora(scan)) {

        case 1:
          limparTela();
          System.out.print("\n\t==========ADIÇÃO==========\n");

          System.out.print("\n\tDigite o primeiro número: ");
          x = scan.nextInt();

          System.out.print("\n\tDigite o segundo número: ");
          y = scan.nextInt();

          System.out.print("\n\tO resultado da soma é: " + (x + y));
          System.out.print("\n\t===========================");
          pausa(scan);

          break;

        case 2:
          limparTela();
          System.out.print("\n\t==========SUBTRAÇÃO==========\n");

          System.out.print("\n\tDigite o primeiro número: ");
          x = scan.nextInt();

          System.out.print("\n\tDigite o segundo número: ");
          y = scan.nextInt();

          System.out.print("\n\tO resultado da subtração é: " + (x - y));
          System.out.print("\n\t================================");
          pausa(scan);

          break;

        case 3:
          limparTela();
          System.out.print("\n\t==========MULTIPLICAÇÃO==========\n");

          System.out.print("\n\tDigite o primeiro número: ");
          x = scan.nextInt();

          System.out.print("\n\tDigite o segundo número: ");
          y = scan.nextInt();

          System.out.print("\n\tO resultado da multiplicação é: " + (x * y));
          System.out.print("\n\t============================");
          pausa(scan);

          break;

        case 4:
          limparTela();
          System.out.print("\n\t==========DIVISÃO==========\n");

          System.out.print("\n\tDigite o primeiro número: ");
          x = scan.nextInt();

          System.out.print("\n\tDigite o segundo número: ");
          y = scan.nextInt();

          System.out.print("\n\tO resultado da divisão é: " + (x / y));
          System.out.print("\n\t============================");
          pausa(scan);

          break;

        case 0:
          System.out.print("\n\tSair");
          pausa(scan);
          break;

        default:
          System.out.print("\n\tOpção inválida");
          break;
      }

      

    }

  }

  public static int menuCalculadora(Scanner scan) {

    limparTela();
    imprimirFormatado(LocalDateTime.now());
    calcularDiasRestantes(LocalDateTime.now());
    int opcao = 0;

    do {

      System.out.print("\n\t========================");
      System.out.print("\n\tESCOLHA UMA OPERAÇÃO: ");
      System.out.print("\n\t[1] - ADIÇÃO");
      System.out.print("\n\t[2] - SUBTRAÇÃO");
      System.out.print("\n\t[3] - MULTIPLICAÇÃO");
      System.out.print("\n\t[4] - DIVISÃO");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");
      opcao = scan.nextInt();

      if (opcao == 0) {
        System.out.println("\n\tSaindo...");
        scan.close();
        System.exit(opcao);

      } else {

        if (opcao > 4 || opcao < 0) {

          System.out.println("\n\tOps, opção inválida");
          pausa(scan);
          limparTela();

        }
      }

    } while (opcao > 4 || opcao < 0);

    return opcao;
  }

  static void imprimirFormatado(LocalDateTime dataHora) {
    System.out.println("\n\tHoje é " + dataHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));
  }

  static void calcularDiasRestantes(LocalDateTime dataHora) {

    LocalDate hoje = dataHora.toLocalDate();
    LocalDate ultimoDiaDoAno = LocalDate.of(hoje.getYear(), 12, 31);
    long diasRestantes = (ChronoUnit.DAYS.between(hoje, ultimoDiaDoAno)) + 1;
    System.out.println("\tJá se passaram " + ((dataHora.getDayOfYear()) - 1) + " dias, resta " + (diasRestantes)
        + " dias para o final do ano.");

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