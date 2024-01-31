package jdbc.redesocial.application;

import java.util.Scanner;

import jdbc.redesocial.model.dao.DaoFactory;
import jdbc.redesocial.model.dao.UsuarioDao;
import jdbc.redesocial.model.entities.Usuario;  

public class Program {

  public static void main(String[] args) {

    limparTela(); 
    Scanner sc = new Scanner(System.in);

    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    // System.out.println("\n\t=== TEST 1: usuario findById =====");
		// Usuario usuario = usuarioDao.findById(1);
		// System.out.println(usuario);

    // System.out.println("\n\t=== TEST 1: usuario insert =====");
    // Integer id = usuarioDao.cadastrar();
    // System.out.println("\n\tInserted! New id: " + id);

    // System.out.println("\n\t=== TEST 2: usuario findById =====");

    sc.close();

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
