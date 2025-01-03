package semana3.atvemsala.exercicio6;

import java.util.Scanner;

public class MainRetangulo {

    public static void main(String[] args) throws Exception {

        limparTela();
        Scanner scan = new Scanner(System.in);

        solicitaAlturaLargura(scan);

    }

    public static void solicitaAlturaLargura(Scanner scan) {

        System.out.print("\n\tInforme a altura do retangulo: ");
        int x = scan.nextInt();

        System.out.print("\n\tInforme a largura do triangulo: ");
        int y = scan.nextInt();

        System.out.println("\n\tResultado da área de um retangulo: " + calcularAreaRetangulo(x, y));
    }

    public static int calcularAreaRetangulo(int x, int y) {

        return x * y;
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
