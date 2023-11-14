package semana2.redesocial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.printf("\n\tDigite seu nome: ");
        String nome = scan.nextLine();

        System.out.printf("\n\tDigite seu email: ");
        String email = scan.nextLine();

        System.out.printf("\n\tDigite sua nacionalidade: ");
        String nacionalidade = scan.nextLine();

        Usuario usuario = new Usuario(nome, email, nacionalidade);

        for (int i = 0; i < 10; i++) {
            System.out.printf("\n\tDigite a %dº postagem: ", i + 1);
            String postagem = scan.nextLine();

            usuario.adicionaPostagem(postagem);
        }

        usuario.imprimePostagens();

    }
}
