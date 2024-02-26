package atvemsala.exercicio7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        limparTela();
        Scanner scan = new Scanner(System.in);

        System.out.print("\n\tInforme um número: ");
        int x = scan.nextInt();

        GeradorPrimos primo = new GeradorPrimos(x);

        primo.divisores(x);
        // primo.quantDivisores(x);

        System.out.printf(primo.ePrimo(x) ? "\n\tO número %d é primo" : "\n\tO número %d não é primo", x);

        primo.numerosPrimos(x);

        scan.close();
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
