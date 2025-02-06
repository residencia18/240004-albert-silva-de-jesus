package exercicio2;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        limparTela();
        Scanner scan = new Scanner(System.in);

        System.out.print("\n\tInforme a 1º nota: ");
        float nota1 = scan.nextFloat();

        System.out.print("\n\tInforme a 2º nota: ");
        float nota2 = scan.nextFloat();

        System.out.print("\n\tInforme a 3º nota: ");
        float nota3 = scan.nextFloat();

        limparTela();
        System.out.print("\n\tInforme o peso da 1° nota: ");
        float peso1 = scan.nextFloat();

        System.out.print("\n\tInforme o peso da 2° nota: ");
        float peso2 = scan.nextFloat();

        System.out.print("\n\tInforme o peso da 3º nota: ");
        float peso3 = scan.nextFloat();

        limparTela();
        MediaPonderada media = new MediaPonderada(nota1, nota2, nota3, peso1, peso2, peso3);

        System.out.printf("Resultado da media ponderada: %.2f",
                media.calcularMediaPonderada(nota1, nota2, nota3, peso1, peso2, peso3));

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
