/*1. Crie uma classe chamada Calculadora que contenha métodos para realizar operações matemáticas básicas, como soma, subtração, multiplicação e
divisão. Sobrecarregue os métodos para aceitar diferentes tipos de dados, como inteiros e float. Crie uma versão para receber listas de 
números (ArrayLists) e fazer operações em sequência. Certifique-se de fornecer exemplos de uso no método main */
package semana5.P006.exercicio1;

import java.util.ArrayList;
import java.util.Scanner;

import semana5.P006.exercicio1.entities.Calculator;

public class Main {

  public static void main(String[] args){
    escolherOperacao();
  }

  public static void escolherOperacao() 
  {

    int opcao = 0;
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    ArrayList<Float> numerosFloat = new ArrayList<Float>();

    do {

      limparTela();
      System.out.println("\n\t=== CALCULADORA ===");
      System.out.println("\t[1] - OPERAÇÕES COM INTEIROS");
      System.out.println("\t[2] - OPERAÇÕES COM FLOATS");
      System.out.println("\t[0] - SAIR");
      System.out.print("\tOPÇÃO: ");
      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {

        case 1:
          operacoesComInteiros(numeros);
          break;

        case 2:
          operacoesComFloats(numerosFloat);
          break;

        case 0:
          System.out.println("\n\tSaindo...");
          break;

        default:
          System.out.println("\n\tOPÇÃO INVÁLIDA!");
          break;
      }

    } while (opcao != 0);
  }

  public static void operacoesComInteiros(ArrayList<Integer> numeros) 
  {

    int opcao = 0;

    do {

      limparTela();
      System.out.println("\n\t=== CALCULADORA ===");
      System.out.println("\t[1] - SOMAR");
      System.out.println("\t[2] - SUBTRAIR");
      System.out.println("\t[3] - MULTIPLICAR");
      System.out.println("\t[4] - DIVIDIR");
      System.out.println("\t[0] - SAIR");
      System.out.print("\tOPÇÃO: ");
      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {

        case 1:

          System.out.print("\n\tDeseja digitar quantos números? ");
          int quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Integer.parseInt(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.somar(numeros));
          break;

        case 2:

          System.out.print("\n\tDeseja digitar quantos números? ");
          quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Integer.parseInt(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.subtrair(numeros));
          break;

        case 3:

          System.out.print("\n\tDeseja digitar quantos números? ");
          quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Integer.parseInt(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.multiplicar(numeros));
          break;

        case 4:

          System.out.print("\n\tDeseja digitar quantos números? ");
          quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Integer.parseInt(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.dividir(numeros));
          pausar(new Scanner(System.in));
          break;

        case 0:
          System.out.println("\n\tSaindo...");
          break;

        default:
          System.out.println("\n\tOPÇÃO INVÁLIDA!");
          break;
      }

    } while (opcao != 0);
  }

  public static void operacoesComFloats(ArrayList<Float> numeros) 
  {

    int opcao = 0;

    do {
      
      limparTela();
      System.out.println("\n\t=== CALCULADORA ===");
      System.out.println("\t[1] - SOMAR");
      System.out.println("\t[2] - SUBTRAIR");
      System.out.println("\t[3] - MULTIPLICAR");
      System.out.println("\t[4] - DIVIDIR");
      System.out.println("\t[0] - SAIR");
      System.out.print("\tOPÇÃO: ");
      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {

        case 1:

          System.out.print("\n\tDeseja digitar quantos números? ");
          int quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Float.parseFloat(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.somarFloat(numeros));
          break;

        case 2:

          System.out.print("\n\tDeseja digitar quantos números? ");
          quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Float.parseFloat(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.subtrairFloat(numeros));
          break;

        case 3:

          System.out.print("\n\tDeseja digitar quantos números? ");
          quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Float.parseFloat(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.multiplicarFloat(numeros));
          break;

        case 4:

          System.out.print("\n\tDeseja digitar quantos números? ");
          quantidade = Integer.parseInt(System.console().readLine());

          for (int i = 0; i < quantidade; i++) {
            System.out.print("\n\tDigite o " + (i + 1) + "º número: ");
            numeros.add(Float.parseFloat(System.console().readLine()));
          }

          System.out.println("\n\tRESULTADO: " + Calculator.dividirFloat(numeros));
          pausar(new Scanner(System.in));
          break;

        case 0:
          System.out.println("\n\tSaindo...");
          break;

        default:
          System.out.println("\n\tOPÇÃO INVÁLIDA!");
          break;

      }

    } while (opcao != 0);

  }

  public static void limparTela() 
  {

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

  public static void pausar(Scanner scan) 
  {
    System.out.print("\n\tPressione ENTER para continuar...");
    scan.nextLine();
  }
}
