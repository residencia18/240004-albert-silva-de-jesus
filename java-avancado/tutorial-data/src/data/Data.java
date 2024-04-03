package src.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
// import java.util.Locale;
import java.util.Scanner;

public class Data {

  public static void main(String[] args) throws Exception {

    Scanner scan = new Scanner(System.in);

    menu(scan);

    // // Obtendo a data e hora atual
    LocalDateTime agora = LocalDateTime.now();

    // // Obtendo o dia da semana
    // String diaDaSemana = agora.getDayOfWeek().getDisplayName(TextStyle.FULL,
    // Locale.getDefault());

    // // Obtendo a data formatada
    // String dataFormatada =
    // agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    // // Obtendo o horário formatado
    // String horarioFormatado =
    // agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    // System.out.printf("\t" + diaDaSemana + ", " + dataFormatada + " - " +
    // horarioFormatado + "\n\n");

    System.out.println(
        "\n\tHoje é dia " + agora.getDayOfMonth() + " do mês " + agora.getMonth() + " do ano " + agora.getYear()
            + ", e é o " + (agora.getDayOfYear() - 1) + "º dia do ano.\n");
    // pausa(scan);

  }

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

      if (opcao > 5 || opcao < 0) {
        System.out.println("\n\tOps, opção inválida!");
        pausar(scan);
        limparTela();
      }

    } while (opcao > 5 || opcao < 0);

    return opcao;
  }

  static void imprimirFormatado(LocalDateTime dataHora) {
    System.out.println("\n\tHoje é " + dataHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));
  }

  static void calcularDiasRestantes(LocalDateTime dataHora) {

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
