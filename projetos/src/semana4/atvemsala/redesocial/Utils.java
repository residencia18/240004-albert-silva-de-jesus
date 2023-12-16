package semana4.atvemsala.redesocial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

  public static Scanner scan = new Scanner(System.in);
  LocalDateTime agora = LocalDateTime.now();
  ListaUsuarios usuarios;
  private Usuario usuarioLogado;
  private Sessao sessaoAtual;

  public static int menuPrincipal(Scanner scan) {

    int opcao = 0;

    do {

      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());

      System.out.print("\n\t========== INSTADEGAS ==========");
      System.out.print("\n\t[1] - NOVO USUÁRIO");
      System.out.print("\n\t[2] - LISTAR USUÁRIOS");
      System.out.print("\n\t[3] - REMOVER USUÁRIO");
      System.out.print("\n\t[4] - LOGAR");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");
      opcao = scan.nextInt();
      scan.nextLine();

      if (opcao > 4 || opcao < 0) {
        System.out.println("\n\tOps, opção inválida");
        pausar(Utils.scan);
        limparTela();
      }

    } while (opcao > 4 || opcao < 0);

    return opcao;
  }

  public static int menuSessao() {
    
    int opcao = 0;

    do {

      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());

      System.out.print("\n\t========== INSTADEGAS ==========");
      System.out.print("\n\t[1] - LISTAR POSTAGENS");
      System.out.print("\n\t[2] - CRIAR POSTAGEM");
      System.out.print("\n\t[3] - CRIAR AMIZADE");
      System.out.print("\n\t[4] - DESFAZER AMIZADE");
      System.out.print("\n\t[0] - MENU ANTERIOR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine(); // Limpar o buffer do scanner
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número.");
        scan.nextLine(); // Limpar o buffer do scanner
        pausar(Utils.scan);
        limparTela();
        continue;
      }

      if (opcao > 4 || opcao < 0) {

        System.out.println("\n\tOps, opção inválida");
        pausar(Utils.scan);
        limparTela();
      }

    } while (opcao > 4 || opcao < 0);

    return opcao;
  }

  public void redeSocial() {

    int opcao = 0;
    int opcaoSessao = 0;
    Scanner scan = new Scanner(System.in);
    usuarios = new ListaUsuarios();

    usuarios.carregarDeArquivo("projetos/src/semana4/atvemsala/redesocial/bancodedados/redesocial.txt");

    do {

      opcao = menuPrincipal(scan);

      switch (opcao) {

        case 1:
          usuarios.novoUsuario(scan);
          usuarios.salvarEmArquivo("projetos/src/semana4/atvemsala/redesocial/bancodedados/redesocial.txt");
          break;

        case 2:
          usuarios.listarUsuarios();
          pausar(Utils.scan);
          break;

        case 3:
          // usuarios.removerUsuario(scan);
          // usuarios.salvarEmArquivo("projetos/src/semana4/atvemsala/redesocial/bancodedados/redesocial.txt");
          break;

        case 4:

          usuarioLogado = Sessao.login(usuarios);

          if (usuarioLogado == null) {
            break;
          }

          sessaoAtual = usuarioLogado.logar();
          do {

            opcaoSessao = menuSessao();

            switch (opcaoSessao) {

              case 1:
                // usuario.listarPostagens();
                // pausar(scan);
                break;

              case 2:
                // usuario.novaPostagem(scan);
                // usuarios.salvarEmArquivo("projetos/src/semana4/atvemsala/redesocial/bancodedados/redesocial.txt");
                break;

              case 3:
                sessaoAtual.criarAmizade(usuarios);
                // usuarios.salvarEmArquivo("projetos/src/semana4/atvemsala/redesocial/bancodedados/redesocial.txt");
                break;

              case 4:
                // usuario.desfazerAmizade(scan);
                // usuario.salvarEmArquivo("projetos/src/semana4/atvemsala/redesocial/bancodedados/redesocial.txt");
                break;

              case 0:
                limparTela();
                usuarioLogado.deslogar(sessaoAtual);
                System.out.println("\n\tUsuário deslogado, " + sessaoAtual.getDataHoraFim().format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));
                sessaoAtual = null;
                usuarioLogado = null;
                pausar(Utils.scan);
                limparTela(); 
                break;

              default:
                System.out.println("\n\tOps, opção inválida");
                pausar(Utils.scan);
                break;
            }
          } while (opcaoSessao != 0);
          break;

        case 0:
          System.out.println("\n\tSaindo...");
          break;

        default:
          System.out.println("\n\tOps, opção inválida");
          pausar(Utils.scan);
          break;

      }
    } while (opcao != 0 || opcaoSessao != 0);

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

  public static String validarNomeUsuario() {

    String nome = "";

    while (true) {
      try {

        System.out.print("\n\tInforme o nome de usuário: ");
        nome = scan.nextLine();

        if (nome.length() >= 3 && nome.matches("^[a-zA-Z0-9_-]{3,}$")) {
          break; // Sai do loop se o nome de usuário tiver 3 ou mais caracteres e for
                 // alfanumérico
        } else {
          System.out.println("\n\tOps, o nome de usuário deve ter 3 ou mais caracteres e ser alfanumérico.");
          pausar(Utils.scan);
          limparTela();

        }
      } catch (InputMismatchException e) {
        // Tratamento de exceção para entrada inválida
        System.out.println("\n\tOps, entrada inválida. Por favor, tente novamente.");
        scan.nextLine(); // Limpar o buffer de entrada

      } catch (Exception e) {
        // Tratamento de exceção genérica (se necessário)
        System.out.println("\n\tOps, algo deu errado. Por favor, tente novamente.");
        scan.nextLine(); // Limpar o buffer de entrada
      }
    }

    return nome;
  }

  public static String validarEmail() {

    String email = "";

    while (true) {
      try {

        System.out.print("\n\tInforme o e-mail: ");
        email = scan.nextLine();

        if (email.length() >= 3 && email.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")) {
          break;
        } else {
          System.out.println("\n\tOps, o e-mail deve ter 3 ou mais caracteres e ser válido.");
          pausar(Utils.scan);
          limparTela();

        }
      } catch (InputMismatchException e) {

        System.out.println("\n\tOps, entrada inválida. Por favor, tente novamente.");
        scan.nextLine();

      } catch (Exception e) {

        System.out.println("\n\tOps, algo deu errado. Por favor, tente novamente.");
        scan.nextLine();
      }
    }

    return email;
  }

  public static String validarSenha() {
   
    String senha = "";

    while (true) {
      try {

        System.out.print("\n\tInforme a senha: ");
        senha = scan.nextLine();

        if (senha.length() >= 3 && senha.matches("^[a-zA-Z0-9_-]{3,}$")) {
          break;
        } else {
          System.out.println("\n\tOps, a senha deve ter 3 ou mais caracteres e ser alfanumérica.");
          pausar(Utils.scan);
          limparTela();

        }
      } catch (InputMismatchException e) {

        System.out.println("\n\tOps, entrada inválida. Por favor, tente novamente.");
        scan.nextLine();

      } catch (Exception e) {

        System.out.println("\n\tOps, algo deu errado. Por favor, tente novamente.");
        scan.nextLine();
      }
    }

    return senha;
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
