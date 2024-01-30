package jdbc.redesocial.application;

import java.util.Scanner;

import jdbc.redesocial.dao.DaoFactory;
import jdbc.redesocial.dao.UsuarioDao;
import jdbc.redesocial.entities.Usuario;

public class Program {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    UsuarioDao usuarioDao = DaoFactory.createUsuario();

    System.out.println("\n\t=== TEST 1: usuario insert =====");
    Usuario usuario = new Usuario(null, "Greg", "12345", "greg@gmail.com");
    usuarioDao.insert(usuario);
    System.out.println("\n\tInserted! New id: " + usuario.getId());

  }
}
