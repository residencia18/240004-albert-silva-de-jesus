package semana6.atvEmSala.P005.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import semana4.atvemsala.redesocial.Utils;
import semana6.atvEmSala.P005.Repositories.TrajetoRepository;
import semana6.atvEmSala.P005.entities.Jornada;
import semana6.atvEmSala.P005.entities.PontosDeParada;
import semana6.atvEmSala.P005.entities.Trajeto;
import semana6.atvEmSala.P005.entities.Trecho;

public class TrajetoService implements TrajetoRepository {

  public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  public static List<Trajeto> trajetos = new ArrayList<Trajeto>();

  @Override
  public void adicionar(Trajeto trecho) {
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
      System.out.println(trajeto.toString());
      System.out.println("\t===============================");
    }
    Utils.pausar(Utils.scan);
  }

  public static void registroDeTrajeto() {

    System.out.println("\n\t===== REGISTRO DE TRAJETO =====");

    if (JornadaService.jornadas.isEmpty()) {
      System.out.println("\tNão há jornadas cadastradas!");
      Utils.pausar(Utils.scan);
      return;
    }

    // Exibi as opções de jornadas
    for (int i = 0; i < JornadaService.jornadas.size(); i++) {
      System.out.println("\n\t" + (i + 1) + "º" + JornadaService.jornadas.get(i));
      System.out.println("\t============================");
    }

    System.out.print("\tEscolha a jornada pelo índice: ");
    int opcaoJornada = Utils.scan.nextInt();
    Utils.scan.nextLine(); // Consumir a quebra de linha pendente

    if (opcaoJornada < 1 || opcaoJornada > JornadaService.jornadas.size()) {
      System.out.println("\tOpção inválida. Digite um número entre 1 e " + JornadaService.jornadas.size());
      Utils.pausar(Utils.scan);
      return;
    }

    // Obtém a jornada escolhida
    Jornada jornadaEscolhida = JornadaService.jornadas.get(opcaoJornada - 1);

    // Registra a data e hora de início do trajeto
    System.out.print("\tInforme a data e hora de início do trajeto (formato dd/MM/yyyy): ");
    String dataHoraInicio = Utils.scan.nextLine();

    // Converte a string em um objeto Date
    Date dataInicio = converterStringParaData(dataHoraInicio);

    if (dataInicio != null) {
      // Obtém uma instância de Calendar e define a data e hora
      Calendar calendarInicio = Calendar.getInstance();
      calendarInicio.setTime(dataInicio);

      // Obtém a hora atual do sistema
      Calendar calendarAtual = Calendar.getInstance();

      // Define a hora e minutos da data de início do trajeto com a hora atual do
      // sistema
      calendarInicio.set(Calendar.HOUR_OF_DAY, calendarAtual.get(Calendar.HOUR_OF_DAY));
      calendarInicio.set(Calendar.MINUTE, calendarAtual.get(Calendar.MINUTE));
      calendarInicio.set(Calendar.SECOND, calendarAtual.get(Calendar.SECOND));

      // Obtém a data atualizada
      dataInicio = calendarInicio.getTime();

    } else {
      System.out.println("\tEntrada inválida para data. Registro de trajeto não realizado.");
    }

    jornadaEscolhida.registrarInicioDoTrajeto(dataInicio);
    System.out.println("\n\tRegistro de trajeto realizado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  private static Date converterStringParaData(String dataString) {

    sdf.setLenient(false); // Desativa a flexibilidade na validação

    try {
      return sdf.parse(dataString);

    } catch (ParseException e) {
      System.out.println("\tFormato de data inválido. Digite novamente.");
      return null;
    }
  }

}
