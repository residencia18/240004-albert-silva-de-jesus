package semana6.atvEmSala.P005.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

import semana6.atvEmSala.P005.Repositories.CobradorRepository;
import semana6.atvEmSala.P005.Repositories.JornadaRepository;
import semana6.atvEmSala.P005.services.CobradorService;
import semana6.atvEmSala.P005.services.JornadaService;
import semana6.atvEmSala.P005.services.MotoristaService;
import semana6.atvEmSala.P005.services.PassageiroService;
import semana6.atvEmSala.P005.services.PontoDeParadaService;
import semana6.atvEmSala.P005.services.TrajetoService;
import semana6.atvEmSala.P005.services.VeiculoService;

public class Views {

  LocalDateTime agora = LocalDateTime.now();
  public static Scanner scan = new Scanner(System.in);

  public static void MainTransporteViario() {

    int opcao = -1;

    do {

      opcao = dispMain();

      switch (opcao) {
        case 1:
          menuVeiculos();
          break;
        case 2:
          menuMotoristas();
          break;
        case 3:
          menuCobrador();
          break;
        case 4:
          menuPassageiros();
          break;
        case 5:
          menuPontosDeParada();
          break;
        case 6:
          menuTrajetos();
          break;
        case 7:
          menuRegistroDeJornada();
          break;
        case 8:
          menuRegistroDeInicioDeTrajeto();
          break;
        case 9:
          // menuRegistroDePassageirosComCartao();
          break;
        case 10:
          // menuRegistroDeCheckpoint();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar a nossa Energia Coelho, Saindo!...");
          System.exit(0);
          break;
        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
          Views.pausar(scan);
      }

    } while (opcao != 0);

  }

  private static int dispMain() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t=============== ENERGIA COELHO ===============");
      System.out.print("\n\t[1] - GESTÃO VEÍCULOS");
      System.out.print("\n\t[2] - GESTÃO MOTORISTAS");
      System.out.print("\n\t[3] - GESTÃO COBRADORES");
      System.out.print("\n\t[4] - GESTÃO PASSAGEIROS");
      System.out.print("\n\t[5] - GESTÃO DE PONTO DE PARADA");
      System.out.print("\n\t[6] - GESTÃO TRAJETOS");
      System.out.print("\n\t[7] - REGISTRO DE JORNADA");
      System.out.print("\n\t[8] - REGISTRO DE INICIO DE TRAJETO");
      System.out.print("\n\t[9] - REGISTRO DE PASSAGEIROS COM CARTÃO");
      System.out.print("\n\t[10] - REGISTRO DE CHECKPOINT");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 10) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 10.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 10);

    return opcao;
  }

  private static int dispMenuCobradores() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO CLIENTE =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  private static void menuCobrador() {

    int opcao = -1;
    CobradorRepository cobradorRepository = new CobradorService();

    do {

      opcao = dispMenuCobradores();

      switch (opcao) {
        case 1:
          cobradorRepository.cadastrarCobrador();
          break;

        case 2:
          cobradorRepository.listarCobradores();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private static int dispMenuMotoristas() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO MOTORISTAS =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  private static void menuMotoristas() {

    int opcao = -1;

    do {

      opcao = dispMenuMotoristas();

      switch (opcao) {
        case 1:
          MotoristaService.cadastrarMotorista();
          break;

        case 2:
          MotoristaService.listarMotoristas();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private static int dispMenuVeiculos() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO VEÍCULOS =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  private static void menuVeiculos() {

    int opcao = -1;

    do {

      opcao = dispMenuVeiculos();

      switch (opcao) {
        case 1:
          VeiculoService.cadastrarVeiculo();
          break;

        case 2:
          VeiculoService.listarVeiculos();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private static int dispMenuPassageiros() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO PASSAGEIROS =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  private static void menuPassageiros() {

    int opcao = -1;

    do {

      opcao = dispMenuPassageiros();

      switch (opcao) {
        case 1:
          PassageiroService.cadastrarPassageiro();
          break;

        case 2:
          PassageiroService.listarPassageiros();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private static int dispMenuPontosDeParada() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO PONTOS DE PARADA =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  private static void menuPontosDeParada() {

    int opcao = -1;

    do {

      opcao = dispMenuPontosDeParada();

      switch (opcao) {
        case 1:
          PontoDeParadaService.cadastrarPontoDeParada();
          break;

        case 2:
          PontoDeParadaService.listarPontosDeParada();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private static int dispMenuTrajetos() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO TRAJETOS =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  private static void menuTrajetos() {

    int opcao = -1;

    do {

      opcao = dispMenuTrajetos();

      switch (opcao) {
        case 1:
          TrajetoService.cadastrarTrajeto();
          break;

        case 2:
          TrajetoService.listarTrajetos();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  public static int dispMenuJornada() {

    int opcao = -1;

    do {

      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO JORNADAS =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  public static void menuRegistroDeJornada() {

    int opcao = -1;
    JornadaRepository jornadaRepository = new JornadaService();

    do {

      opcao = dispMenuJornada();

      switch (opcao) {
        case 1:
          jornadaRepository.cadastrarJornada();
          break;

        case 2:
          JornadaService.listarJornadas();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  public static int dispMenuRegistroDeInicioDeTrajeto() {

    int opcao = -1;

    do {

      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== REGISTRO DE INICIO DE TRAJETO =====");
      System.out.print("\n\t[1] - REGISTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 3) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 3.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 3);

    return opcao;
  }

  public static void menuRegistroDeInicioDeTrajeto() {

    int opcao = -1;

    do {

      opcao = dispMenuRegistroDeInicioDeTrajeto();

      switch (opcao) {
        case 1:
          TrajetoService.registroDeTrajeto();
          break;

        case 2:
          JornadaService.listarJornadas();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainTransporteViario();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o nosso sistema de gestão de transportes, Saindo!...");
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  public static void imprimirFormatado(LocalDateTime dataHora) {
    System.out.println("\n\tHoje é " + dataHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));
  }

  public static void calcularDiasRestantes(LocalDateTime dataHora) {

    LocalDate hoje = dataHora.toLocalDate();
    LocalDate ultimoDiaDoAno = LocalDate.of(hoje.getYear(), 12, 31);
    long diasRestantes = (ChronoUnit.DAYS.between(hoje, ultimoDiaDoAno)) + 1;
    System.out.println("\tJá se passaram " + ((dataHora.getDayOfYear()) - 1) + " dias, resta " + (diasRestantes)
        + " dias para o final do ano.");

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
