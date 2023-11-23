package semana4.estudo.produto;

import java.util.ArrayList;
import java.util.Scanner;

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

  public void cadastrar(Scanner scan ) {

    Utils.limparTela();
    System.out.println("\n\t========== CADASTRAR ==========");

    System.out.print("\n\tInforme o nome do Produto: ");
    String nome = scan.nextLine();

    System.out.print("\n\tInforme o preço do Produto: ");
    double preco = scan.nextDouble();
    scan.nextLine();

    System.out.print("\n\tInforme a quantidade do Produto: ");
    int quantidade = scan.nextInt();
    scan.nextLine();

    Produto produto = new Produto(nome, preco, quantidade);

    cadastrarProduto(produto);

    Utils.limparTela();
    System.out.println("\n\tProduto cadastrado com sucesso!");
    Utils.pausar(scan);
  }

  public void listar() {

    Utils.limparTela();
    System.out.println("\n\t========== LISTAR ==========");

    if (this.produtos.size() > 0) {

      for (Produto produto : this.produtos) {
        System.out.println("\tID: " + produto.getId());
        System.out.println("\tNome: " + produto.getNome());
        System.out.println("\tPreço: " + produto.getPreco());
        System.out.println("\tQuantidade: " + produto.getQuantidade());
        System.out.println("\tDisponível: " + (produto.isDisponivel() ? "Sim" : "Não"));
        System.out.println("\t============================");
      }

    } else {
      System.out.println("\n\tNão há produtos cadastrados!");
      Utils.pausar(new Scanner(System.in));
    }
  }

}