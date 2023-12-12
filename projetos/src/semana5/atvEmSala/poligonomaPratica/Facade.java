package semana5.atvEmSala.poligonomaPratica;

import java.util.Scanner;

public class Facade {

    public static void main(String[] args) {

        limparTela();
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o número de pontos do polígono: ");
        int n = teclado.nextInt();

        Poligono poli = new Poligono();

        for (int i = 0; i < n; i++) {

            Ponto p = Ponto.solicitaPonto(teclado);
            poli.inserePonto(p);
        }

        System.out.println("O perímetro do polígono é: " + poli.perimetro());
        teclado.close();
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
