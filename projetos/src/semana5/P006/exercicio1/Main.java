/*1. Crie uma classe chamada Calculadora que contenha métodos para realizar operações matemáticas básicas, como soma, subtração, multiplicação e
divisão. Sobrecarregue os métodos para aceitar diferentes tipos de dados, como inteiros e float. Crie uma versão para receber listas de 
números (ArrayLists) e fazer operações em sequência. Certifique-se de fornecer exemplos de uso no método main */
package semana5.P006.exercicio1;

import java.util.ArrayList;

import semana5.P006.exercicio1.entities.Calculator;

public class Main {

  public static void main(String[] args) throws Exception {

    ArrayList<Integer> numeros = new ArrayList<Integer>();
    ArrayList<Float> numerosFloat = new ArrayList<Float>();

    operacoesComInteiros(numeros);
  }

  public static void operacoesComInteiros(ArrayList<Integer> numeros) {

    int opcao = 0;

    do {

      System.out.println("\n\t=== CALCULADORA ===");
      System.out.println("\n\t[1] - SOMAR");
      System.out.println("\t[2] - SUBTRAIR");
      System.out.println("\t[3] - MULTIPLICAR");
      System.out.println("\t[4] - DIVIDIR");
      System.out.println("\t[0] - SAIR");
      System.out.print("\n\tOPÇÃO: ");
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
      }

    } while (opcao != 0);
  }
}
