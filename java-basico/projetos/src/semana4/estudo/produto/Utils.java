package semana4.estudo.produto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Utils {

  public static Scanner scan = new Scanner(System.in);
  LocalDateTime agora = LocalDateTime.now();

  public static int menu(Scanner scan) {

    limparTela();
    imprimirFormatado(LocalDateTime.now());
    calcularDiasRestantes(LocalDateTime.now());
    int opcao = 0;

    do {

      System.out.print("\n\t========== CRUD ==========");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - EDITAR");
      System.out.print("\n\t[4] - EXCLUIR");
      System.out.print("\n\t[5] - PESQUISAR");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");
      opcao = scan.nextInt();
      scan.nextLine();

      if (opcao > 5 || opcao < 0) {
        System.out.println("\n\tOps, opção inválida");
        pausar(scan);
        limparTela();
      }

    } while (opcao > 5 || opcao < 0);

    return opcao;
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

  // public static void calcularDiasRestantes(LocalDateTime dataHora) {
  // LocalDate hoje = dataHora.toLocalDate();
  // LocalDate ultimoDiaDoAno = LocalDate.of(hoje.getYear(), 12, 31);
  // long diasRestantes = ChronoUnit.DAYS.between(hoje, ultimoDiaDoAno) + 1;

  // System.out.println("\tJá se passaram " + (dataHora.getDayOfYear() - 1) + "
  // dias.");
  // System.out.println("\tRestam " + diasRestantes + " dias para o final do
  // ano.");
  // System.out.println("\tHoje é " +
  // hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
  // }

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
