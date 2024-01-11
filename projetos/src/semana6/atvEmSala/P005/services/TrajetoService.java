package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana4.atvemsala.redesocial.Utils;
import semana6.atvEmSala.P005.Repositories.TrajetoRepository;
import semana6.atvEmSala.P005.entities.PontosDeParada;
import semana6.atvEmSala.P005.entities.Trajeto;
import semana6.atvEmSala.P005.entities.Trecho;

public class TrajetoService implements TrajetoRepository {

  public static List<Trajeto> trajetos = new ArrayList<Trajeto>();

  @Override
  public void adcionar(Trajeto trecho) {
    trajetos.add(trecho);
  }

  public static void cadastrarTrajeto() {

    System.out.println("\n\t===== CADASTRAR TRAJETO =====");

    if (PontoDeParadaService.pontosDeParada.isEmpty()) {
      System.out.println("\tNão há pontos de parada cadastrados!");
      Utils.pausar(Utils.scan);
      return;
    }

    int index = 1;
    int pontoEmbarque;

    do {
      System.out.println("\tInforme a origem: ");

      for (PontosDeParada ponto : PontoDeParadaService.pontosDeParada) {
        System.out.println("\t[" + (index++) + "] - " + ponto.getEmbarque());
      }
      System.out.print("\tOpção: ");
      pontoEmbarque = Utils.scan.nextInt();
      Utils.scan.nextLine(); // Consumir a quebra de linha pendente

      if (pontoEmbarque < 1 || pontoEmbarque > PontoDeParadaService.pontosDeParada.size()) {
        System.out
            .println("\tOpção inválida. Digite um número entre 1 e " + PontoDeParadaService.pontosDeParada.size());
        index = 1; // Reiniciar o índice
      }

    } while (pontoEmbarque < 1 || pontoEmbarque > PontoDeParadaService.pontosDeParada.size());

    String origem = PontoDeParadaService.pontosDeParada.get(pontoEmbarque - 1).getEmbarque();

    do {

      System.out.println("\tInforme o destino: ");

      index = 1;
      for (PontosDeParada ponto : PontoDeParadaService.pontosDeParada) {
        System.out.println("\t[" + (index++) + "] - " + ponto.getDesembarque());
      }
      System.out.print("\tOpção: ");
      pontoEmbarque = Utils.scan.nextInt();
      Utils.scan.nextLine(); // Consumir a quebra de linha pendente

      if (pontoEmbarque < 1 || pontoEmbarque > PontoDeParadaService.pontosDeParada.size()) {
        System.out
            .println("\tOpção inválida. Digite um número entre 1 e " + PontoDeParadaService.pontosDeParada.size());
        index = 1; // Reiniciar o índice
      }

    } while (pontoEmbarque < 1 || pontoEmbarque > PontoDeParadaService.pontosDeParada.size());

    String destino = PontoDeParadaService.pontosDeParada.get(pontoEmbarque - 1).getDesembarque();

    System.out.print("\tInforme os pontos de parada: ");
    String pontos = Utils.scan.nextLine();

    System.out.print("\tInforme o intervalo estimado: ");
    int intervaloEstimado = Utils.scan.nextInt();

    Trecho trecho = new Trecho(origem, destino, pontos, intervaloEstimado);
    trajetos.add(new Trajeto(trecho));

    System.out.println("\n\tTrajeto cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public static void listarTrajetos() {

    System.out.println("\n\t===== LISTAR TRAJETOS =====");

    if (trajetos.isEmpty()) {
      System.out.println("\tNão há trajetos cadastrados!");
      Utils.pausar(Utils.scan);
      return;
    }

    for (Trajeto trajeto : trajetos) {
      System.out.println("Embarque" + trajeto.toString());
      System.out.println("\t===============================");
    }
    Utils.pausar(Utils.scan);
  }

}
