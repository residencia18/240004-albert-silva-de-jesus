package semana3.atvemsala.exercicio3;

import java.util.Scanner;

public class ConcatenacaoDeString {

    public static void main(String[] args) {

        limparTela();
        Scanner scan = new Scanner(System.in);

        solicitarString(scan);
    }

    public static void solicitarString(Scanner scan) {

        System.out.print("\n\tDigite a 1° String: ");
        String x = scan.nextLine();

        System.out.print("\n\tDigite a  2° String: ");
        String y = scan.nextLine();

        System.out.println("\n\tResultado da concatenação: " +concaternarString(x, y));
    }

    public static String concaternarString(String x, String y) {

        String stringConcatenada = x.concat(y);
        return stringConcatenada;
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
