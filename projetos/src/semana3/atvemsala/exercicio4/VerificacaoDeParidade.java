package semana3.atvemsala.exercicio4;

import java.util.Scanner;

public class VerificacaoDeParidade {

    public static void main(String[] args) {

        limparTela();
        Scanner scan = new Scanner(System.in);

        paridade(scan);
    }

    public static void paridade(Scanner scan) {

        System.out.print("\n\tInforme um número: ");
        int x = scan.nextInt();

        if (x % 2 == 0) {
            System.out.println("\n\tÉ Par!\n");

        } else {
            System.out.println("\n\tÉ Impar!\n");
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
}
