package semana8.p007.exercicio3.services;

import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.PontosDeParada;
import semana7.P006.exercicio4.persistencia.ArquivoPontoDeParada;
import semana7.P006.exercicio4.repositories.PontoDeParadaRepository;
import semana7.P006.exercicio4.views.Views;

public class PontoDeParadaService implements PontoDeParadaRepository {

  public static List<PontosDeParada> pontosDeParadas = new ArrayList<PontosDeParada>();

  @Override
  public void adicionar(PontosDeParada pontoDeParada) {
    pontosDeParadas.add(pontoDeParada);
  }

  public List<PontosDeParada> getPontosDeParada() {
    return pontosDeParadas;
  }

  public void cadastrarPontoDeParada() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRAR PONTO DE PARADA =====\n");

    System.out.print("\tInforme o ponto de embarque: ");
    String pontoEmbarque = Views.scan.nextLine();

    System.out.print("\tInforme o ponto de desembarque: ");
    String pontoDesembarque = Views.scan.nextLine();

    System.out.print("\tInforme a distância entre os pontos: ");
    int distancia = Views.scan.nextInt();

    adicionar(new PontosDeParada(pontoEmbarque, pontoDesembarque, distancia));

  }

  public void listarPontosDeParada() {

    Views.limparTela();
    System.out.println("\n\t===== LISTAR PONTOS DE PARADA =====");

    for (PontosDeParada pontoDeParada : pontosDeParadas) {
      System.out.println(pontoDeParada.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }

  public String trajetoEmbarque() {

    if (getPontosDeParada().isEmpty()) {
      System.out.println("\tNão há pontos de parada cadastrados!");
      Views.pausar(Views.scan);
      return null;
    }

    int index = 1;
    int pontoEmbarque;

    do {
      System.out.println("\tInforme o Embarque: ");

      for (PontosDeParada ponto : getPontosDeParada()) {
        System.out.println("\t[" + (index++) + "] - " + ponto.getEmbarque());
      }
      System.out.print("\tOpção: ");
      pontoEmbarque = Views.scan.nextInt();
      Views.scan.nextLine(); // Consumir a quebra de linha pendente

      if (pontoEmbarque < 1 || pontoEmbarque > getPontosDeParada().size()) {
        System.out.println("\tOpção inválida. Digite um número entre 1 e " + getPontosDeParada().size());
        index = 1; // Reiniciar o índice
      }

    } while (pontoEmbarque < 1 || pontoEmbarque > getPontosDeParada().size());

    return getPontosDeParada().get(pontoEmbarque - 1).getEmbarque();
  }

  public String trajetoDesembarque() {

    if (getPontosDeParada().isEmpty()) {
      System.out.println("\tNão há pontos de parada cadastrados!");
      Views.pausar(Views.scan);
      return null;
    }

    int index = 1;
    int pontoDesembarque;

    do {
      System.out.println("\tInforme o destino: ");

      for (PontosDeParada ponto : getPontosDeParada()) {
        System.out.println("\t[" + (index++) + "] - " + ponto.getDesembarque());
      }
      System.out.print("\tOpção: ");
      pontoDesembarque = Views.scan.nextInt();
      Views.scan.nextLine(); // Consumir a quebra de linha pendente

      if (pontoDesembarque < 1 || pontoDesembarque > getPontosDeParada().size()) {
        System.out.println(
            "\tOpção inválida. Digite um número entre 1 e " + getPontosDeParada().size());
        index = 1; // Reiniciar o índice
      }

    } while (pontoDesembarque < 1 || pontoDesembarque > getPontosDeParada().size());

    return getPontosDeParada().get(pontoDesembarque - 1).getDesembarque();
  }

  public static String localDeEmbarquePassageiro(int opcao) {

    String pontoEmbarque = "";
    opcao = localEmbarquePassageiro();

    switch (opcao) {
      case 1:
        pontoEmbarque = "Ponto A";
        break;
      case 2:
        pontoEmbarque = "Ponto B";
        break;
      case 3:
        pontoEmbarque = "Ponto C";
        break;
      case 4:
        pontoEmbarque = "Ponto D";
        break;
      case 5:
        pontoEmbarque = "Ponto E";
        break;
    }

    return pontoEmbarque;
  }

  public static int localEmbarquePassageiro() {

    boolean opcaoValida = false;
    int opcaoEmbarque = 0;

    do {

      try {
        System.out.println("\n\tPonto de Embarque: ");
        System.out.println("\t1 - Ponto A");
        System.out.println("\t2 - Ponto B");
        System.out.println("\t3 - Ponto C");
        System.out.println("\t4 - Ponto D");
        System.out.println("\t5 - Ponto E");
        System.out.print("\tOpção: ");

        opcaoEmbarque = Integer.parseInt(Views.scan.nextLine());

        if (opcaoEmbarque >= 1 && opcaoEmbarque <= 5) {
          opcaoValida = true;
        } else {
          Views.limparTela();
          System.out.println("\n\tOpção inválida. Digite um número entre 1 e 5.");
        }

      } catch (NumberFormatException e) {
        Views.limparTela();
        System.out.println("\n\tPor favor, digite um número válido.");
      }
    } while (!opcaoValida);

    return opcaoEmbarque;
  }

  @Override
  public void carregarArquivo(String nomeArquivo) {
    pontosDeParadas = ArquivoPontoDeParada.carregarPontosDeParadaDeArquivo(nomeArquivo);

    if(pontosDeParadas != null) {
      Views.limparTela();
      System.out.println("\n\tPontos de Parada carregados do arquivo: " + nomeArquivo);
      Views.pausar(Views.scan);
    }

  }

  @Override
  public void salvarArquivo(String nomeArquivo) {
    ArquivoPontoDeParada.salvarPontosDeParadaEmArquivo(pontosDeParadas, nomeArquivo);
  }

}
