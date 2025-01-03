/*
• Faça um programa que pergunte ao usuário o nome de um arquivo − Crie o arquivo
• Depois peça ao usuário para digitar uma linha de texto − Crie a linha digitada dentro do arquivo
• Repita a criação de linhas até que o usuário digite uma linha vazia (string sem dado nenhum)
• Encerre o programa
• Vá ao diretório de seu programa e abra o arquivo que foi criado para certificar que está tudo certo. 
*/
package semana7.atvsala.arquivos;

import java.util.Scanner;

import semana7.atvsala.arquivos.entities.Arquivo;

public class Program {

    public static void main(String[] args) {

        limparTela();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo: ");
        String nomeArquivo = sc.nextLine();
        String caminhoArquivo = "projetos/src/semana7/atvsala/arquivos/bancodedados/";
        String conteudo = null;
        // String nomeArquivoConcatenado = caminhoArquivo.concat(nomeArquivo);

        // Forma simples de concatenar strings.
        // String caminhoArquivo = "projetos/src/semana7/atvsala/arquivos/" + nomeArquivo;

        Arquivo arquivo = new Arquivo(nomeArquivo, caminhoArquivo);
        arquivo.salvarEmArquivo(nomeArquivo, conteudo);
        arquivo.lerArquivo(nomeArquivo);

        sc.close();
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
