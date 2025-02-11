package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Utils;
import validation.Validation;

public class Produto {

  private static int contador = 0;
  private int id;
  private String nome;
  private double preco;
  private int quantidade;
  private boolean disponivel;
  private ArrayList<Produto> produtos;

  public Produto() {
    this.produtos = new ArrayList<Produto>();
  }

  public Produto(String nome, double preco, int quantidade) {
    this.id = ++contador;
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.disponivel = true;
  }

  public static int getContador() {
    return contador;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
  }

  public ArrayList<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(ArrayList<Produto> produtos) {
    this.produtos = produtos;
  }

  public void cadastrarProduto(Produto produto) {
    this.produtos.add(produto);
  }

  public void cadastrar() {

    Utils.limparTela();
    System.out.println("\n\t========== CADASTRAR ==========");

    String nome = Validation.validarNome();

    double preco = Validation.validarNumero();

    int quantidade = Validation.validarQuantidade();

    Produto produto = new Produto(nome, preco, quantidade);

    cadastrarProduto(produto);

    Utils.limparTela();
    listar();
    System.out.print("\n\tProduto cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public void listar() {

    Utils.limparTela();
    System.out.println("\n\t========== LISTAR ==========");

    if (this.produtos.size() > 0) {

      for (Produto produto : this.produtos) {
        System.out.println("\tID: " + produto.getId());
        System.out.println("\tNome: " + produto.getNome());
        System.out.printf("\tPreço: R$ %.2f", produto.getPreco());
        System.out.println("\n\tQuantidade: " + produto.getQuantidade());
        System.out.println("\tDisponível: " + (produto.isDisponivel() ? "Sim" : "Não"));
        System.out.println("\t============================");
      }

    } else {
      System.out.println("\n\tNão há produtos cadastrados!");
      Utils.pausar(new Scanner(System.in));
    }
  }

  public void editar() {

    Utils.limparTela();
    System.out.println("\n\t========== EDITAR ==========");

    if (this.produtos.size() > 0) {

      System.out.printf("\n\tDigite o ID do produto que deseja editar: ");
      int id = Utils.scan.nextInt();
      Utils.scan.nextLine();

      for (Produto produto : this.produtos) {

        if (produto.getId() == id) {

          System.out.printf("\n\tNOME: ");
          String nome = Validation.validarNome();

          System.out.printf("\n\tPREÇO: ");
          double preco = Validation.validarNumero();

          System.out.printf("\n\tQUANTIDADE: ");
          int quantidade = Validation.validarQuantidade();

          produto.setNome(nome);
          produto.setPreco(preco);
          produto.setQuantidade(quantidade);

          Utils.limparTela();
          listar();
          System.out.println("\n\tProduto editado com sucesso!");
          Utils.pausar(Utils.scan);
          break;
        }
      }

    } else {
      System.out.println("\n\tNão há produtos cadastrados!");
      Utils.pausar(Utils.scan);
    }
  }

  public void excluir() {

    Utils.limparTela();
    System.out.println("\n\t========== EXCLUIR ==========");

    if (this.produtos.size() > 0) {

      System.out.printf("\n\tDigite o ID do produto que deseja excluir: ");
      int id = Utils.scan.nextInt();
      Utils.scan.nextLine();

      for (Produto produto : this.produtos) {

        if (produto.getId() == id) {

          this.produtos.remove(produto);

          Utils.limparTela();
          listar();
          System.out.println("\n\tProduto excluído com sucesso!");
          Utils.pausar(Utils.scan);
          break;
        }
      }

    } else {
      System.out.println("\n\tNão há produtos cadastrados!");
      Utils.pausar(Utils.scan);
    }
  }

  public void pesquisarProduto() {

    Utils.limparTela();
    System.out.println("\n\t========== PESQUISAR ==========");

    if (this.produtos.size() > 0) {

      System.out.printf("\n\tDigite o ID do produto que deseja pesquisar: ");
      int id = Utils.scan.nextInt();
      Utils.scan.nextLine();

      for (Produto produto : this.produtos) {

        if (produto.getId() == id) {

          Utils.limparTela();
          System.out.println("\n\t========== PRODUTO ENCONTRADO ==========");
          System.out.println("\tID: " + produto.getId());
          System.out.println("\tNome: " + produto.getNome());
          System.out.printf("\tPreço: R$ %.2f", produto.getPreco());
          System.out.println("\n\tQuantidade: " + produto.getQuantidade());
          System.out.println("\tDisponível: " + (produto.isDisponivel() ? "Sim" : "Não"));
          System.out.println("\t========================================");
          Utils.pausar(Utils.scan);
          break;
        }
      }

    } else {
      System.out.println("\n\tNão há produtos cadastrados!");
      Utils.pausar(Utils.scan);
    }

    System.out.println("\n\tProduto não encontrado!");
    Utils.pausar(Utils.scan);
  }

  public void carregarDeArquivo(String nomeArquivo) {

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

      String linha;

      while ((linha = reader.readLine()) != null) {

        String[] partes = linha.split(";");

        if (partes.length == 5) {
          int id = Integer.parseInt(partes[0]);
          String nome = partes[1];
          double preco = Double.parseDouble(partes[2]);
          int quantidade = Integer.parseInt(partes[3]);
          boolean disponivel = Boolean.parseBoolean(partes[4]);
          Produto produto = new Produto(nome, preco, quantidade);
          produto.setId(id);
          produto.setDisponivel(disponivel);
          produtos.add(produto);
        }
      }
      System.out.println("Produtos carregados do arquivo: " + nomeArquivo);

    } catch (IOException e) {
      System.err.println("Erro ao carregar do arquivo: " + e.getMessage());
    }
  }

  public void salvarEmArquivo(String nomeArquivo) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

      for (Produto produto : produtos) {
        writer.write(produto.getId() + ";" +
            produto.getNome() + ";" +
            produto.getPreco() + ";" +
            produto.getQuantidade() + ";" +
            produto.isDisponivel());
        writer.newLine();
      }
      System.out.println("Produtos salvos com sucesso no arquivo: " + nomeArquivo);

    } catch (IOException e) {
      System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
    }
  }

}