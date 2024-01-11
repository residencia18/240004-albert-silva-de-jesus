package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.PontoDeParadaRepository;
import semana6.atvEmSala.P005.entities.PontosDeParada;
import semana6.atvEmSala.P005.utils.Utils;

public class PontoDeParadaService implements PontoDeParadaRepository{

  public static List<PontosDeParada> pontosDeParada = new ArrayList<PontosDeParada>();
  
  @Override
  public void adicionar(PontosDeParada pontoDeParada) {
    pontosDeParada.add(pontoDeParada);
  }

  public static void cadastrarPontoDeParada() {

    System.out.println("\n\t===== CADASTRAR PONTO DE PARADA =====\n");

    System.out.print("\tInforme o ponto de embarque: ");
    String pontoEmbarque = Utils.scan.nextLine();

    System.out.print("\tInforme o ponto de desembarque: ");
    String pontoDesembarque = Utils.scan.nextLine();

    System.out.print("\tInforme a distância entre os pontos: ");
    int distancia = Utils.scan.nextInt();

    pontosDeParada.add(new PontosDeParada(pontoEmbarque, pontoDesembarque, distancia));

  }

  public static void listarPontosDeParada() {
    
    Utils.limparTela();
    System.out.println("\n\t===== LISTAR PONTOS DE PARADA =====");

    for (PontosDeParada pontoDeParada : pontosDeParada) {
      System.out.println(pontoDeParada.toString());
      System.out.println("\t============================");
    }
    Utils.pausar(Utils.scan);
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

        opcaoEmbarque = Integer.parseInt(Utils.scan.nextLine());

        if (opcaoEmbarque >= 1 && opcaoEmbarque <= 5) {
          opcaoValida = true;
        } else {
          Utils.limparTela();
          System.out.println("\n\tOpção inválida. Digite um número entre 1 e 5.");
        }

      } catch (NumberFormatException e) {
        Utils.limparTela();
        System.out.println("\n\tPor favor, digite um número válido.");
      }
    } while (!opcaoValida);

    return opcaoEmbarque;
  }
  
}
