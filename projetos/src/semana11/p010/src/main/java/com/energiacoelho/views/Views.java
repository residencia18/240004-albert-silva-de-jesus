package com.energiacoelho.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.energiacoelho.dao.ClienteDao;
import com.energiacoelho.dao.FaturaDao;
import com.energiacoelho.dao.ImovelDao;
import com.energiacoelho.dao.impl.ClienteDaoImpl;
import com.energiacoelho.dao.impl.FaturaDaoImpl;
import com.energiacoelho.dao.impl.ImovelDaoImpl;

public class Views {

  LocalDateTime agora = LocalDateTime.now();
  public static Scanner scan = new Scanner(System.in);

  public static void MainEnergiaCoelho() {

    int opcao = -1;

    do {

      opcao = dispMain();

      switch (opcao) {
        case 1:
          menuCliente();
          break;
        case 2:
          menuImoveis();
          break;
        case 3:
          menuFaturas();
          break;
        case 4:
          menuPagamentos();
          break;
        case 5:
          menuFalhas();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar a nossa Energia Coelho, Saindo!...");
          ClienteDaoImpl.encerrarComunicacao();
          System.exit(0);
          break;
      }

    } while (opcao != 0);

  }

  public static int dispMain() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== ENERGIA COELHO =====");
      System.out.print("\n\t[1] - GESTÃO CLIENTES");
      System.out.print("\n\t[2] - GESTÃO IMÓVEIS");
      System.out.print("\n\t[3] - GESTÃO CONTAS");
      System.out.print("\n\t[4] - GESTÃO PAGAMENTOS");
      System.out.print("\n\t[5] - GESTÃO FALHAS");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 5) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 5.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 5);

    return opcao;
  }

  private static int dispMenuClientes() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO CLIENTE =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - EDITAR");
      System.out.print("\n\t[4] - EXCLUIR");
      System.out.print("\n\t[5] - PESQUISAR");
      System.out.print("\n\t[6] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 6) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 6.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 6);

    return opcao;
  }

  public static void menuCliente() {

    int opcao = -1;
    ClienteDao clienteDao = new ClienteDaoImpl();

    do {

      opcao = dispMenuClientes();

      switch (opcao) {
        case 1:
          clienteDao.cadastrar();
          break;
        case 2:
          clienteDao.listar();
          break;
        case 3:
          clienteDao.editar();
          break;
        case 4:
          clienteDao.excluir();
          break;
        case 5:
          clienteDao.pesquisar();
          break;
        case 6:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainEnergiaCoelho();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar o Energia Coelho, Saindo!...");
          ClienteDaoImpl.encerrarComunicacao();
          System.exit(0);
          break;
        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  public static int dispMenuImoveis() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO IMÓVEIS =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - EDITAR");
      System.out.print("\n\t[4] - EXCLUIR");
      System.out.print("\n\t[5] - PESQUISAR");
      System.out.print("\n\t[6] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 6) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 6.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 6);

    return opcao;
  }

  public static void menuImoveis() {

    int opcao = -1;
    ImovelDao imovelDao = new ImovelDaoImpl();

    do {

      opcao = dispMenuImoveis();

      switch (opcao) {
        case 1:
          imovelDao.cadastrar();
          break;
        case 2:
          imovelDao.listar();
          break;
        case 3:
          imovelDao.editar();
          break;
        case 4:
          imovelDao.excluir();
          break;
        case 5:
          imovelDao.pesquisar();
          break;
        case 6:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainEnergiaCoelho();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar o Energia Coelho, Saindo!...");
          ClienteDaoImpl.encerrarComunicacao();
          System.exit(0);
          break;
        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private static int dispMenuFaturas() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO CLIENTE =====");
      System.out.print("\n\t[1] - REGISTRO DE CONSUMO");
      System.out.print("\n\t[2] - LISTAR FATURAS EM ABERTO");
      System.out.print("\n\t[3] - LISTAR TODAS AS FATURAS");
      System.out.print("\n\t[4] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 4) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 6.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 4);

    return opcao;
  }

  public static void menuFaturas() {

    int opcao = -1;
    FaturaDao faturaDao = new FaturaDaoImpl();

    do {

      opcao = dispMenuFaturas();

      switch (opcao) {
        case 1:
          faturaDao.registrarConsumo();
          break;
        case 2:
          faturaDao.faturasEmAberto();
          break;
        case 3:
          faturaDao.todasAsFaturas();
          break;
        case 4:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainEnergiaCoelho();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar o Energia Coelho, Saindo!...");
          ClienteDaoImpl.encerrarComunicacao();
          System.exit(0);
          break;
        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private static int dispMenuPagamentos() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO CLIENTE =====");
      System.out.print("\n\t[1] - INCLUIR PAGAMENTO");
      System.out.print("\n\t[2] - EXIBIR TODOS OS PAGAMENTOS");
      System.out.print("\n\t[3] - EXIBIR PAGAMENTOS POR FATURA");
      System.out.print("\n\t[4] - EXIBIR TODOS OS REEMBOLSOS");
      System.out.print("\n\t[5] - EXIBIR REEMBOLSOS POR FATURA");
      System.out.print("\n\t[6] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 6) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 6.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 6);

    return opcao;
  }

  public static void menuPagamentos() {

    int opcao = -1;
    // FaturaDao faturaDao = new FaturaDaoImpl();

    do {

      opcao = dispMenuPagamentos();

      switch (opcao) {

        case 1:

          // Fatura fatura = faturaDao.obterFaturaPorMesEmissao();

          // if (fatura != null)
          // fatura.novoPagamento();
          break;

        case 2:
          // FaturaDaoImpl.todosOsPagamentos();
          break;

        case 3:
          // faturaDao.pagamentosPorFatura();
          break;

        case 4:
          // faturaDao.todosOsReembolsos();
          break;

        case 5:
          // faturaDao.reembolsosPorFatura();
          break;

        case 6:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainEnergiaCoelho();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o Energia Coelho, Saindo!...");
          ClienteDaoImpl.encerrarComunicacao();
          System.exit(0);
          break;

        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  public static int dispMenuFalhas() {
    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO FALHAS =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - MOSTRAR TODAS AS FALHAS");
      System.out.print("\n\t[3] - FINALIZAR FALHA");
      System.out.print("\n\t[4] - GESTÃO REPAROS");
      System.out.print("\n\t[5] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 5) {
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

    } while (opcao < 0 || opcao > 5);

    return opcao;
  }

  public static int dispMenuTipoFalhas() {
    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO FALHAS =====");
      System.out.print("\n\t[1] - CADASTRAR FALHA DE DISTRIBUIÇÃO");
      System.out.print("\n\t[2] - CADASTRAR FALHA DE GERAÇÃO");
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

  public static void menuTipoFalhas() {

    int opcao = -1;
    // FalhaDao falhaDao = new FalhaDaoImpl();

    do {

      opcao = dispMenuTipoFalhas();

      switch (opcao) {
        case 1:
          // falhaDao.cadastrarFalhaDistribuicao();
          break;

        case 2:
          // falhaDao.cadastrarFalhaGeracao();
          break;
        case 3:

          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainEnergiaCoelho();
          break;

        case 0:
          System.err.println("\n\tObrigado por utilizar o Energia Coelho, Saindo!...");
          ClienteDaoImpl.encerrarComunicacao();
          System.exit(0);
          break;
        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);

  }

  public static int dispMenuReparos() {
    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO DE REPAROS =====");
      System.out.print("\n\t[1] - LISTAR REPARO NÃO CONCLUIDOS");
      System.out.print("\n\t[2] - MARCAR REPARO COMO CONCLUIDO");
      System.out.print("\n\t[3] - MENU GESTÃO DE FALHAS");
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

  public static void menuReparos() {

    int opcao = -1;
    // ReparoDao reparoDao = new ReparoDaoImpl();

    do {

      opcao = dispMenuReparos();

      switch (opcao) {
        case 1:
          // reparoDao.listarRaparosAbertos();
          break;

        case 2:
          // reparoDao.encerraReparo();
          break;

        case 3:
          System.out.println("\n\tRetornando ao menu anterior...");
          pausar(scan);
          menuFalhas();
          break;

        default:
          break;
      }
    } while (opcao != 0);
  }

  public static void menuFalhas() {

    int opcao = -1;
    // FalhaDao falhaDao = new FalhaDaoImpl();

    do {

      opcao = dispMenuFalhas();

      switch (opcao) {

        case 1:
          menuTipoFalhas();
          break;

        case 2:
          // falhaDao.listar();
          break;

        case 3:
          // falhaDao.editar();
          break;

        case 4:
          menuReparos();
          break;
        case 5:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainEnergiaCoelho();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar o Energia Coelho, Saindo!...");
          ClienteDaoImpl.encerrarComunicacao();
          System.exit(0);
          break;
        default:
          break;
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

  public static void cxMsg(String mensagem) {
    limparTela();
    System.out.println(mensagem);
    pausar(Views.scan);
  }

  public static boolean confirmarRepeticao() {

    while (true) {

      System.out.print("\n\tDeseja pesquisar outro imóvel? (S/N): ");
      String resposta = Views.scan.nextLine();

      if (resposta.equalsIgnoreCase("S")) {
        return true;

      } else if (resposta.equalsIgnoreCase("N")) {
        return false;

      } else {
        Views.limparTela();
        System.out.println("\n\tOpção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
      }
    }
  }

}
