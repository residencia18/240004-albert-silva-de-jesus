package semana4.estudo.produto;

import java.util.Scanner;

public class Validation {

  public static String validarNome(Scanner scan) {

    String nome = "";

    while (true) {

      System.out.print("\n\tInforme o nome do Produto: ");
      nome = scan.nextLine();

      if (nome.length() >= 3) {
        break; // Sai do loop se o nome tiver 3 ou mais caracteres

      } else {
        System.out.println("\n\tOps, o nome do produto deve ter 3 ou mais caracteres.");
        Utils.pausar(scan);
        Utils.limparTela();
      }
    }

    return nome;
  }

  public static double validarNumero(Scanner scan) {
    double preco = 0;

    while (true) {

      System.out.print("\n\tInforme o preço do Produto: ");
      String precoStr = scan.nextLine();

      try {
        preco = Double.parseDouble(precoStr);

        if (preco > 0) {
          break; // Sai do loop se a conversão for bem-sucedida e o valor for maior que 0

        } else {
          System.out.println("\n\tOps, preço do produto deve ser maior que zero.");
          Utils.pausar(scan);
          Utils.limparTela();
        }
      } catch (NumberFormatException e) {
        System.out.println("\n\tOps, entrada inválida! O preço deve ser um número.");
        Utils.pausar(scan);
        Utils.limparTela(); 
      }
    }

    return preco;
  }

  public static int validarQuantidade(Scanner scan) {

    int quantidade = 0;

    while (true) {

      System.out.print("\n\tInforme a quantidade do Produto: ");
      String quantidadeStr = scan.nextLine();

      try {

        quantidade = Integer.parseInt(quantidadeStr);

        if (quantidade > 0) {
          break; // Sai do loop se a conversão for bem-sucedida e a quantidade for maior que 0

        } else {
          System.out.println("\n\tOps, a quantidade do produto deve ser maior que zero.");
          Utils.pausar(scan);
          Utils.limparTela();
        }
      } catch (NumberFormatException e) {
        System.out.println("\n\tOps, entrada inválida! A quantidade deve ser um número inteiro.");
        Utils.pausar(scan);
        Utils.limparTela();
      }
    }

    return quantidade;
  }

}