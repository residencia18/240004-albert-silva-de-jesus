package semana4.estudo.produto;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);

    crudProduto(sc);

    sc.close();
  }

  public static void crudProduto(Scanner scan) {

    int opcao = 0;
    Produto produto = new Produto();
    produto.carregarDeArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");

    do {

      opcao = Utils.menu(scan);

      switch (opcao) {
        case 1:
          produto.cadastrar(scan);
          produto.salvarEmArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");
          break;

        case 2:
          produto.listar();
          Utils.pausar(scan);
          break;

        case 3:
          produto.editar(scan);
          produto.salvarEmArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");
          break;

        case 4:
          produto.excluir(scan);
          produto.salvarEmArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");
          break;

        case 5:
          produto.pesquisarProduto(scan);
          break;

        case 0:
          System.out.println("\n\tSaindo...");
          System.out.println("\tObrigado por usar o sistema!");
          System.exit(opcao);
          break;
      }

    } while (opcao != 0);

  }
}
