package semana5.P006.exercicio2.entities;

public class ItemPedido {

  private String nome;
  private double preco;
  private int quantidade;

  public ItemPedido() {

  }

  public ItemPedido(String nome, double preco, int quantidade) {
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  public String getNome() {
    return this.nome;
  }

  public double getPreco() {
    return this.preco;
  }

  public int getQuantidade() {
    return this.quantidade;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getValorTotal() {
    return this.preco * this.quantidade;
  }

  public String toString() {
    return "\n\tNome: " + this.nome + "\n\tPreço: " + this.preco + "\n\tQuantidade: " + this.quantidade
        + "\n\tValor Total: " + this.getValorTotal();
  }
}
