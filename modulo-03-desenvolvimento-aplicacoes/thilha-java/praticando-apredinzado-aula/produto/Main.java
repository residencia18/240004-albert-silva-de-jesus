package semana4.estudo.produto;

public class Main {

  public static void main(String[] args) throws Exception {
    crudProduto();
  }

  public static void crudProduto() {

    int opcao = 0;
    Produto produto = new Produto();
    produto.carregarDeArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");

    do {

      opcao = Utils.menu(Utils.scan);

      switch (opcao) {
        case 1:
          produto.cadastrar();
          produto.salvarEmArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");
          break;

        case 2:
          produto.listar();
          Utils.pausar(Utils.scan);
          break;

        case 3:
          produto.editar();
          produto.salvarEmArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");
          break;

        case 4:
          produto.excluir();
          produto.salvarEmArquivo("projetos/src/semana4/estudo/produto/bancodedados/produtos.txt");
          break;

        case 5:
          produto.pesquisarProduto();
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
