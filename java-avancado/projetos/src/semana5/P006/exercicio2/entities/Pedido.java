/*2. Considere um sistema de gerenciamento de pedidos em uma loja online.Crie uma classe chamada Pedido que represente um pedido de compra. 
A classe deve ter atributos como número do pedido, cpf do cliente e uma lista de itens do pedido. Implemente métodos para adicionar itens
ao pedido, calcular o total do pedido e exibir as informações do pedido.Sobrecarregue o método de adicionar ítens para ele receber uma 
lista de itens ao invés de um único. Sobrecarregue o método calcular o total do pedido para que ele informe o valor à vista (um percentual
de desconto é passado como parâmetro) ou o valor total a prazo (o número de prestações e o juro é passado como parâmetro)Além disso, 
forneça exemplos no método main para demonstrar a sobrecarga de métodos em diferentes situações, como um pedido com desconto e outro 
sem desconto. */

package semana5.P006.exercicio2.entities;

import java.util.ArrayList;

public class Pedido {

  private String numeroPedido;
  private String cpfCliente;
  private ArrayList<ItemPedido> itensPedido;

  public Pedido() {
  }

  public Pedido(String numeroPedido, String cpfCliente) {
    this.numeroPedido = numeroPedido;
    this.cpfCliente = cpfCliente;
    itensPedido = new ArrayList<ItemPedido>();
  }

  public String getNumeroPedido() {
    return this.numeroPedido;
  }

  public String getCpfCliente() {
    return this.cpfCliente;
  }

  public void setNumeroPedido(String numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public void setCpfCliente(String cpfCliente) {
    this.cpfCliente = cpfCliente;
  }

  public void adicionarItem(String nome, double preco, int quantidade) {
    itensPedido.add(new ItemPedido(nome, preco, quantidade));
  }

  public void adicionarItemPedido(ItemPedido itemPedido) {
    this.itensPedido.add(itemPedido);
  }

  public void adicionarItemPedido(ArrayList<ItemPedido> itensPedido) {
    this.itensPedido.addAll(itensPedido);
  }

  public double calcularTotalPedido() {
    double total = 0;

    for (ItemPedido itemPedido : itensPedido) {
      total += itemPedido.getValorTotal();
    }

    return total;
  }

  public double calcularTotalPedido(double percentualDesconto) {
    double totalSemDesconto = calcularTotalPedido();
    double desconto = totalSemDesconto * (percentualDesconto / 100);
    return totalSemDesconto - desconto;
  }

  public double calcularTotalPedido(int numeroPrestacoes, double juros) {
    double totalSemJuros = calcularTotalPedido();
    double totalComJuros = totalSemJuros * (1 + (juros / 100));
    return totalComJuros / numeroPrestacoes;
  }

  public void exibirInformacoes() {

    System.out.print("\n\t      INFORMAÇÕES DO PEDIDO         \n");
    System.out.println("\n\tNúmero do Pedido: " + numeroPedido);
    System.out.println("\tCPF do Cliente: " + cpfCliente);

    System.out.print("\t======== ITENS DO PEDIDO ========");
    for (ItemPedido item : itensPedido) {
      System.out.println(item.toString());
      System.out.print("\t================================");
    }
  }

  public String toString() {
    return "\tNúmero do Pedido: " + this.numeroPedido + "\tCPF do Cliente: " + this.cpfCliente + "\tItens do Pedido: "
        + this.itensPedido;
  }
}
