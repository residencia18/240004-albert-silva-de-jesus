package tutorial.jdbc.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import tutorial.jdbc.dao.DaoFactory;
import tutorial.jdbc.dao.SellerDao;
import tutorial.jdbc.entities.Department;
import tutorial.jdbc.entities.Seller;

public class Program {

  public static void main(String[] args) {

    limparTela();
    Scanner sc = new Scanner(System.in);

    SellerDao sellerDao = DaoFactory.createSellerDao();

    System.out.println("\n\t=== TEST 1: seller findById =====");
    Seller seller = sellerDao.findById(3);
    System.out.println(seller);

    System.out.println("\n\t=== TEST 2: seller findByDepartment =====");
    Department department = new Department(2, null);
    List<Seller> list = sellerDao.findByDepartment(department);
    for (Seller obj : list) {
    System.out.println(obj);
    }

    System.out.println("\n\t=== TEST 3: seller findAll =====");
    list = sellerDao.findAll();
    for (Seller obj : list) {
    System.out.println(obj);
    }

    System.out.println("\n\t=== TEST 4: seller insert =====");
    Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(),
    4000.0, department);
    sellerDao.insert(newSeller);
    System.out.println("\n\tInserted! New id = " + newSeller.getId());

    System.out.println("\n\t=== TEST 5: seller update =====");
    seller = sellerDao.findById(1);
    seller.setName("Martha Waine");
    sellerDao.update(seller);
    System.out.println("\n\tUpdate completed");

    System.out.println("\n\t=== TEST 6: seller delete =====");
    System.out.print("\n\tEnter id for delete test: ");
    int id = sc.nextInt();
    sellerDao.deleteById(id);
    System.out.println("\n\tDelete completed");

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
