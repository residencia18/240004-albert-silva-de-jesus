/*
• Faça um programa que pergunte ao usuário o nome de um arquivo − Crie o arquivo
• Depois peça ao usuário para digitar uma linha de texto − Crie a linha digitada dentro do arquivo
• Repita a criação de linhas até que o usuário digite uma linha vazia (string sem dado nenhum)
• Encerre o programa
• Vá ao diretório de seu programa e abra o arquivo que foi criado para certificar que está tudo certo. 
*/
package semana7.atvsala.arquivos.entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arquivo {

    Scanner sc = new Scanner(System.in);
    private String nome;
    private String caminho;
    private String conteudo;

    public Arquivo() {
    }

    public Arquivo(String nome, String caminho, String conteudo) {
        this.nome = nome;
        this.caminho = caminho;
        this.conteudo = conteudo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCaminho() {
        return this.caminho;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String toString() {
        return "Arquivo [nome=" + nome + ", caminho=" + caminho + ", conteudo=" + conteudo + "]";
    }

    public String concatenarCaminhoNome() {
        return this.caminho.concat(this.nome);
    }

    public void salvarEmArquivo(String nomeArquivo, String conteudo) {

        try {
            // Abre o arquivo em modo de escrita
            PrintWriter writer = new PrintWriter(new FileWriter(concatenarCaminhoNome()));

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
    }
}
