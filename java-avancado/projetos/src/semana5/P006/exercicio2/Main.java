/*2. Considere um sistema de gerenciamento de pedidos em uma loja online.Crie uma classe chamada Pedido que represente um pedido de compra. 
A classe deve ter atributos como número do pedido, cpf do cliente e uma lista de itens do pedido. Implemente métodos para adicionar itens
ao pedido, calcular o total do pedido e exibir as informações do pedido.Sobrecarregue o método de adicionar ítens para ele receber uma 
lista de itens ao invés de um único. Sobrecarregue o método calcular o total do pedido para que ele informe o valor à vista (um percentual
de desconto é passado como parâmetro) ou o valor total a prazo (o número de prestações e o juro é passado como parâmetro)Além disso, 
forneça exemplos no método main para demonstrar a sobrecarga de métodos em diferentes situações, como um pedido com desconto e outro 
sem desconto. */

package semana5.P006.exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

import semana5.P006.exercicio2.entities.ItemPedido;
import semana5.P006.exercicio2.entities.Pedido;

public class Main {

  public static void main(String[] args) {

    limparTela();
    // Cria itens de pedido
    ItemPedido item1 = new ItemPedido("Produto A", 20.0, 2);
    ItemPedido item2 = new ItemPedido("Produto B", 30.0, 1);

    // Cria uma lista de itens de pedido
    ArrayList<ItemPedido> itensPedido = new ArrayList<>();
    itensPedido.add(item1);
    itensPedido.add(item2);

    // Cria um pedido e adiciona os itens
    Pedido pedido = new Pedido("123456", "123.456.789-10");
    pedido.adicionarItemPedido(itensPedido);

    // Exibi os itens do pedido
    pedido.exibirInformacoes();

    // Calcula o total do pedido
    System.out.println("\n\tTotal do pedido: " + pedido.calcularTotalPedido());

    // Calcula o total do pedido com desconto
    System.out.println("\tTotal do pedido com desconto: " + pedido.calcularTotalPedido(10));

    // Calcula o total do pedido com juros
    System.out.printf("\tValor de cada Pretação: %.2f ", pedido.calcularTotalPedido(3, 10));
    System.out.println("\n\tTotal Parcelado: " + pedido.calcularTotalPedido(3, 10) * 3);
    System.out
        .print("\tTotal de juros: " + (pedido.calcularTotalPedido(3, 10) * 3 - pedido.calcularTotalPedido()) + "\n");
    System.out.print("\t==================================");

    // Pausa a execução para permitir a leitura dos resultados
    pausar(new Scanner(System.in));

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

  public static void pausar(Scanner scan) {
    System.out.print("\n\tPressione ENTER para continuar...");
    scan.nextLine();
  }
}
