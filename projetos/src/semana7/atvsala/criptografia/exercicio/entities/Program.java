package semana7.atvsala.criptografia.exercicio.entities;

import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        limparTela();
        if (args.length != 3) {
            System.out.println("Por favor, forneça dois nomes de arquivos como argumentos.");
            return;
        }

        String file1 = args[0];
        String file2 = args[1];
        String senha = args[2];

        try {

            FileCopy.process(file1, file2, senha);
            System.out.println("Arquivo copiado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao copiar arquivo: " + e.getMessage());
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
