package semana3.atvemsala.exercicio1;

import java.util.Scanner;

public class Main {
  
    public static void main(String[] args) throws Exception{

        limparTela();
        int x = 10;
        int y = 90;

        Soma calcular = new Soma(x, y);
        System.out.println("X: " + calcular.adicao(x, y) + "\n\n");
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
