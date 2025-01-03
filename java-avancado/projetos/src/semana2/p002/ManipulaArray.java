/* Crie uma classe ManipulaArray 
Escreva um método que crie um array de números inteiros lidos do usuário. Outro que os crie aleatoriamente. 
Uma função que calcule a soma de todos os elementos no array. 
Uma função que encontre o maior valor do array. 
Outra que encontre o menor. Crie uma função main() para testar todas essas funcionalidades */
package semana2.p002;

import java.util.Random;
import java.util.Scanner;

public class ManipulaArray {

  public static void main(String[] args) throws Exception {

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    int[] vector1 = new int[5];
    int[] vector2 = new int[5];

    usuarioCriaArray(vector1, scan);

    limparTela();
    System.out.println("\n\t========================================");
    System.out.println("\tVetor criado pelo usuário:");
    imprimeArray(vector1);
    System.out.println("\n\t========================================");

    System.out.println("\tVetor criado aleatoriamente:");
    criaArrayAleatorio(vector2, random);
    imprimeArray(vector2);
    System.out.println("\n\t========================================");
    pausa(scan);
    scan.nextLine();
    limparTela();

    System.out.println("\n\tSoma dos elementos do vetor do usuário:");
    System.out.printf("\n\tSoma = %d", somaElementos(vector1));
    System.out.println("\n\t========================================");

    System.out.println("\tSoma dos elementos do vetor aleatório:");
    System.out.printf("\n\tSoma = %d", somaElementos(vector2));
    System.out.println("\n\t========================================");
    pausa(scan);
    limparTela();

    System.out.println("\tMaior elemento do vetor do usuário:");
    System.out.printf("\n\tMaior = %d", maiorElemento(vector1));
    System.out.println("\n\t========================================");

    System.out.println("\tMaior elemento do vetor aleatório:");
    System.out.printf("\n\tMaior = %d", maiorElemento(vector2));
    System.out.println("\n\t========================================");
    pausa(scan);
    limparTela();

    System.out.println("\tMenor elemento do vetor do usuário:");
    System.out.printf("\n\tMenor = %d", menorElemento(vector1));
    System.out.println("\n\t========================================");

    System.out.println("\tMenor elemento do vetor aleatório:");
    System.out.printf("\n\tMenor = %d", menorElemento(vector2));
    System.out.println("\n\t========================================");

    scan.close();
  }

  public static void usuarioCriaArray(int[] vetor, Scanner scan) {

    limparTela();
    System.out.printf("\n\tInforme %d números inteiros para o vetor:\n", vetor.length);
    for (int i = 0; i < vetor.length; i++) {
      System.out.printf("\n\tInforme o %dº elemento do vetor: ", (i + 1));
      vetor[i] = scan.nextInt();
    }
  }

  public static void criaArrayAleatorio(int[] vetor, Random random) {

    for (int i = 0; i < vetor.length; i++) {
      vetor[i] = random.nextInt(100) + 1;
    }
  }

  public static int somaElementos(int[] vetor) {

    int soma = 0;
    for (int elemento : vetor) {
      soma += elemento;
    }
    return soma;
  }

  public static int maiorElemento(int[] vetor) {

    int maior = vetor[0];
    for (int elemento : vetor) {
      if (elemento > maior) {
        maior = elemento;
      }
    }
    return maior;
  }

  public static int menorElemento(int[] vetor) {

    int menor = vetor[0];
    for (int elemento : vetor) {
      if (elemento < menor) {
        menor = elemento;
      }
    }
    return menor;
  }

  public static void imprimeArray(int[] vetor) {

    System.out.printf("\n\t");
    for (int elemento : vetor) {
      System.out.printf(",%d", elemento);

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

  public static void pausa(Scanner scan) {
    System.out.print("\n\tPressione ENTER para continuar...");
    scan.nextLine();
  }
}
