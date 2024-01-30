package jdbc.redesocial.application;

import java.util.Scanner;

import jdbc.redesocial.dao.DaoFactory;
import jdbc.redesocial.dao.UsuarioDao;
import jdbc.redesocial.entities.Usuario;

public class Program {

  public static void main(String[] args) {

    limparTela(); 
    Scanner sc = new Scanner(System.in);

    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    System.out.println("\n\t=== TEST 1: usuario insert =====");
    Usuario usuario = new Usuario(null, "street", "334455", "tacio@Yaho.com");
    usuarioDao.insert(usuario);
    System.out.println("\n\tInserted! New id: " + usuario.getId());

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
