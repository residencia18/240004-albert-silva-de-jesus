package semana8.p007.exercicio3.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

import semana8.p007.exercicio3.repositories.CobradorRepository;
import semana8.p007.exercicio3.repositories.JornadaRepository;
import semana8.p007.exercicio3.repositories.MotoristaRepository;
import semana8.p007.exercicio3.repositories.PassageiroRepository;
import semana8.p007.exercicio3.repositories.PontoDeParadaRepository;
import semana8.p007.exercicio3.repositories.TrajetoRepository;
import semana8.p007.exercicio3.repositories.VeiculoRepository;
import semana8.p007.exercicio3.services.CobradorService;
import semana8.p007.exercicio3.services.JornadaService;
import semana8.p007.exercicio3.services.MotoristaService;
import semana8.p007.exercicio3.services.PassageiroService;
import semana8.p007.exercicio3.services.PontoDeParadaService;
import semana8.p007.exercicio3.services.TrajetoService;
import semana8.p007.exercicio3.services.VeiculoService;


public class Views {

  LocalDateTime agora = LocalDateTime.now();
  public static Scanner scan = new Scanner(System.in);
  private VeiculoRepository veiculoRepository = new VeiculoService();
  private MotoristaRepository motoristaRepository = new MotoristaService();
  private CobradorRepository cobradorRepository = new CobradorService();
  private PassageiroRepository passageiroRepository = new PassageiroService();
  private PontoDeParadaRepository pontoDeParadaRepository = new PontoDeParadaService();
  private TrajetoRepository trajetoRepository = new TrajetoService();
  private JornadaRepository jornadaRepository = new JornadaService();

  public void MainTransporteViario() {

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
          menuRegistroDePassageirosComCartao();
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
      System.out.print("\n\t===== GESTÃO COBRADORES =====");
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

  private void menuCobrador() {

    int opcao = -1;
    cobradorRepository.carregarArquivoJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\cobrador.json");

    do {

      opcao = dispMenuCobradores();

      switch (opcao) {
        case 1:
          cobradorRepository.cadastrarCobrador();
          cobradorRepository.salvarArquivoJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\cobrador.json");
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

  private void menuMotoristas() {

    int opcao = -1;
    motoristaRepository.carregarArquivoJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\motorista.json");

    do {

      opcao = dispMenuMotoristas();

      switch (opcao) {
        case 1:
          motoristaRepository.cadastrarMotorista();
          motoristaRepository.salvarArquivoJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\motorista.json");
          break;

        case 2:
          motoristaRepository.listarMotoristas();
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

  private void menuVeiculos() {

    int opcao = -1;
    veiculoRepository.carregarArquivoJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\veiculo.json");

    do {

      opcao = dispMenuVeiculos();

      switch (opcao) {
        case 1:
          veiculoRepository.cadastrarVeiculo();
          veiculoRepository.salvarArquivoJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\veiculo.json");
          break;

        case 2:
          veiculoRepository.listarVeiculos();
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

  private void menuPassageiros() {

    int opcao = -1;
    passageiroRepository.carregarArquivo("projetos\\src\\semana7\\P006\\exercicio4\\bancodedados\\passageiro.txt");

    do {

      opcao = dispMenuPassageiros();

      switch (opcao) {
        case 1:
          passageiroRepository.cadastrarPassageiro();
          passageiroRepository.salvarArquivo("projetos\\src\\semana7\\P006\\exercicio4\\bancodedados\\passageiro.txt");
          break;

        case 2:
          passageiroRepository.listarPassageiros();
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

  private void menuPontosDeParada() {

    int opcao = -1;
    pontoDeParadaRepository
        .carregarArquivo("projetos\\src\\semana7\\P006\\exercicio4\\bancodedados\\pontodeparada.txt");

    do {

      opcao = dispMenuPontosDeParada();

      switch (opcao) {
        case 1:
          pontoDeParadaRepository.cadastrarPontoDeParada();
          pontoDeParadaRepository
              .salvarArquivo("projetos\\src\\semana7\\P006\\exercicio4\\bancodedados\\pontodeparada.txt");
          break;

        case 2:
          pontoDeParadaRepository.listarPontosDeParada();
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

  private void menuTrajetos() {

    int opcao = -1;
    trajetoRepository.carregarArquivo("projetos\\src\\semana7\\P006\\exercicio4\\bancodedados\\trajeto.txt");
    pontoDeParadaRepository
        .carregarArquivo("projetos\\src\\semana7\\P006\\exercicio4\\bancodedados\\pontodeparada.txt");

    do {

      opcao = dispMenuTrajetos();

      switch (opcao) {
        case 1:
          trajetoRepository.cadastrarTrajeto();
          trajetoRepository.salvarArquivo("projetos\\src\\semana7\\P006\\exercicio4\\bancodedados\\trajeto.txt");
          break;

        case 2:
          trajetoRepository.listarTrajetos();
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

  public void menuRegistroDeJornada() {

    int opcao = -1;

    do {

      opcao = dispMenuJornada();

      switch (opcao) {
        case 1:
          jornadaRepository.cadastrarJornada();
          break;

        case 2:
          jornadaRepository.listarJornadas();
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

  public void menuRegistroDeInicioDeTrajeto() {

    int opcao = -1;

    do {

      opcao = dispMenuRegistroDeInicioDeTrajeto();

      switch (opcao) {
        case 1:
          trajetoRepository.registroDeTrajeto();
          break;

        case 2:
          jornadaRepository.listarJornadas();
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

  public static int dispMenuRegistroDePassageirosComCartao() {

    int opcao = -1;

    do {

      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== REGISTRO DE PASSAGEIROS COM CARTÃO =====");
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

  public void menuRegistroDePassageirosComCartao() {

    int opcao = -1;

    do {

      opcao = dispMenuRegistroDePassageirosComCartao();

      switch (opcao) {
        case 1:
          passageiroRepository.registroDePassageiroEmbarcadoComCartao();
          break;

        case 2:
          passageiroRepository.registroDePassageiros();
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
