package semana2.exercicios.redesocial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        limparTela();
        System.out.printf("\n\tDigite seu nome: ");
        String nome = scan.nextLine();

        System.out.printf("\n\tDigite seu email: ");
        String email = scan.nextLine();

        System.out.printf("\n\tDigite sua nacionalidade: ");
        String nacionalidade = scan.nextLine();

        Usuario usuario = new Usuario(nome, email, nacionalidade);

        limparTela();
        System.out.println(usuario.toString());

        pausa(scan);
        limparTela();
        for (int i = 0; i < 5; i++) {
            System.out.printf("\n\tDigite a %dº postagem: ", i + 1);
            String postagem = scan.nextLine();

            usuario.adicionaPostagem(postagem);
        }

        limparTela();
        usuario.imprimePostagens();

        System.out.println(usuario.toString());

        usuario.alteraPontuacao(10);
        System.out.println(usuario.toString());

        usuario.alteraPontuacao(-10);
        System.out.println(usuario.toString());

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

    public static void pausa(Scanner scan) {
        System.out.print("\n\tPressione ENTER para continuar...");
        scan.nextLine();
    }
}
