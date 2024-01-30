package jdbc.redesocial.application;

import java.util.Scanner;

import jdbc.redesocial.dao.DaoFactory;
import jdbc.redesocial.dao.UsuarioDao;
import jdbc.redesocial.entities.Usuario;

public class Program {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

    System.out.println("\n\t=== TEST 1: usuario insert =====");
    Usuario usuario = new Usuario(null, "Tico", "90876", "tico@hotmail.com");
    usuarioDao.insert(usuario);
    System.out.println("\n\tInserted! New id: " + usuario.getId());

    sc.close();

  }
}
