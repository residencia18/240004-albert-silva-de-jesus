package semana5.atvEmSala.exDegas.poligono;

import java.util.Scanner;

public class Facade {

    public static void main(String[] args) {

        limparTela();
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\tPoligono de quantos pontos? ");
        int n = sc.nextInt();

        Poligono poli = new Poligono();
		for (int i=0; i< n; i++) {
			System.out.print("\n\tPonto " + i + ": ");
			float x = sc.nextFloat(); 
			float y = sc.nextFloat(); 
			poli.inserePonto(x, y);
		}

        System.out.println("\n\tPerimetro: " + poli.perimeter());

        sc.close();
    }

    public static void limparTela() 
    {
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
