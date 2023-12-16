package entities;

import java.util.Scanner;

import exception.DivisionByZeroException;

public class Calculadora {

  public static Scanner scan = new Scanner(System.in);

  public static int adicao(int num1, int num2) {
    return num1 + num2;
  }

  public static int subtracao(int num1, int num2) {
    return num1 - num2;
  }

  public static int multiplicacao(int num1, int num2) {
    return num1 * num2;
  }

  public static double divisao(int num1, int num2) throws DivisionByZeroException {

    if (num2 == 0) {
      throw new DivisionByZeroException("\n\tOps, não é possível dividir por zero!");
    }

    return ((double) num1) / num2;
  }

  public static double divisao(double num1, double num2) throws DivisionByZeroException {

    if (num2 == 0) {
      throw new DivisionByZeroException("\n\tOps, não é possível dividir por zero!");
    }

    return num1 / num2;
  }

  public static void executar() {

    do {

      limparTela();
      System.out.println("\n\t====== Calculadora ======");
      System.out.print("\n\tDigite o primeiro número: ");
      int num1 = scan.nextInt();

      System.out.print("\n\tDigite o segundo número: ");
      int num2 = scan.nextInt();
      scan.nextLine();

      limparTela();
      System.out.print(
          "\n\tDigite a operação desejada:\n\t+ para adição\n\t- para subtração\n\t* para multiplicação\n\t/ para divisão\n\tEscolha: ");
      String operacao = scan.next();

      limparTela();
      double resultado = 0;

      switch (operacao) {
        case "+":
          resultado = adicao(num1, num2);
          break;

        case "-":
          resultado = subtracao(num1, num2);
          break;

        case "*":
          resultado = multiplicacao(num1, num2);
          break;

        case "/":
          try {
            resultado = divisao(num1, num2);

          } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
          }
          break;

        default:
          System.out.println("\n\tOps, operação inválida!\n");
          break;
      }

      do {

        if (resultado != 0) {
          System.out.printf("\n\tResultado: %.1f", resultado);

        }

        System.out.print("\n\tDeseja realizar outra operação? (s/n): ");
        String opcao = scan.next();
        scan.nextLine();

        if (opcao.equals("n")) {
          System.out.println("\n\tAté mais!n\n");
          return;

        } else {
          if (opcao.equals("s")) {
            System.out.println("\n\tOk, vamos lá!\n");
            break;

          } else {
            System.out.println("\n\tOpção inválida!\n");
          }
        }

      } while (true);

    } while (true);

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