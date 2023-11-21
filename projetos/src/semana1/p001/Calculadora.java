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

    while (x != 5) {

      switch (menuCalculadora(scan)) {

        case 1:
          limparTela();
          System.out.print("\n\t==========ADIÇÃO==========");

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
          System.out.print("\n\t==========SUBTRAÇÃO==========");

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
          System.out.print("\n\t==========MULTIPLICAÇÃO==========");

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
          System.out.print("\n\t==========DIVISÃO==========");

          System.out.print("\n\tDigite o primeiro número: ");
          x = scan.nextInt();

          System.out.print("\n\tDigite o segundo número: ");
          y = scan.nextInt();

          System.out.print("\n\tO resultado da divisão é: " + (x / y));
          System.out.print("\n\t============================");
          pausa(scan);

          break;

        case 5:
          System.out.print("\n\tSair");
          pausa(scan);
          x = 5;
          break;

        default:
          System.out.print("\n\tOpção inválida");
          break;
      }

    }

    scan.close();

  }

  public static int menuCalculadora(Scanner scan) {

    limparTela();
    int opcao = 0;

    /*
     * Obtendo a data e hora atual
     * LocalDateTime agora = LocalDateTime.now();
     * 
     * // Obtendo o dia da semana
     * String diaDaSemana = agora.getDayOfWeek().getDisplayName(TextStyle.FULL,
     * Locale.getDefault());
     * 
     * // Obtendo a data formatada
     * String dataFormatada =
     * agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
     * 
     * // Obtendo o horário formatado
     * String horarioFormatado =
     * agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
     * 
     * System.out.printf(diaDaSemana + ", " + dataFormatada + " - " +
     * horarioFormatado + "\n\n");
     */

    imprimirFormatado(LocalDateTime.now());
    calcularDiasRestantes(LocalDateTime.now());

    do {

      System.out.print("\n\t========================");
      System.out.print("\n\tESCOLHA UMA OPERAÇÃO: ");
      System.out.print("\n\t[1] - ADIÇÃO");
      System.out.print("\n\t[2] - SUBTRAÇÃO");
      System.out.print("\n\t[3] - MULTIPLICAÇÃO");
      System.out.print("\n\t[4] - DIVISÃO");
      System.out.print("\n\t[5] - SAIR");
      System.out.print("\n\tENTRADA -> ");
      opcao = scan.nextInt();

    } while (opcao > 5 || opcao < 1);

    return opcao;
  }

  static void imprimirFormatado(LocalDateTime dataHora) {
    System.out.println("\n\tHoje é " + dataHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));
  }

  static void calcularDiasRestantes(LocalDateTime dataHora) {
    LocalDate hoje = dataHora.toLocalDate();
    LocalDate ultimoDiaDoAno = LocalDate.of(hoje.getYear(), 12, 31);
    long diasRestantes = ChronoUnit.DAYS.between(hoje, ultimoDiaDoAno);
    System.out.println("\tFaltam " + diasRestantes + " dias para o final do ano.");
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