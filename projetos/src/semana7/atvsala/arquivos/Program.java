/*
• Faça um programa que pergunte ao usuário o nome de um arquivo − Crie o arquivo
• Depois peça ao usuário para digitar uma linha de texto − Crie a linha digitada dentro do arquivo
• Repita a criação de linhas até que o usuário digite uma linha vazia (string sem dado nenhum)
• Encerre o programa
• Vá ao diretório de seu programa e abra o arquivo que foi criado para certificar que está tudo certo. 
*/
package semana7.atvsala.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        limparTela();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo: ");
        String nomeArquivo = sc.nextLine();
        String caminhoArquivo = "projetos/src/semana7/atvsala/arquivos/bancodedados/";
        String nomeArquivoConcatenado = caminhoArquivo.concat(nomeArquivo);

        // Forma simples de concatenar strings.
        // String caminhoArquivo = "projetos/src/semana7/atvsala/arquivos/" + nomeArquivo;

        try {
            // Abre o arquivo em modo de escrita
            PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivoConcatenado));

            // Loop para receber linhas de texto até que uma linha vazia seja inserida
            while (true) {
                System.out.print("Digite uma linha de texto (ou pressione Enter para sair): ");
                String linha = sc.nextLine();

                // Verifica se a linha está vazia
                if (linha.isEmpty()) {
                    break;
                }

                // Escreve a linha no arquivo
                writer.println(linha);
            }

            System.out.println("Arquivo '" + nomeArquivo + "' criado com sucesso!");

            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        } finally {
            sc.close();
        }

        try {
            // Abre o arquivo em modo de leitura
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoConcatenado));

            // Lê e imprime cada linha do arquivo
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

            // Fecha o leitor
            reader.close();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
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
