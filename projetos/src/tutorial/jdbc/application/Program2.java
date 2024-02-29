package tutorial.jdbc.application;

import java.util.List;
import java.util.Scanner;

import tutorial.jdbc.dao.DaoFactory;
import tutorial.jdbc.dao.DepartmentDao;
import tutorial.jdbc.entities.Department;

public class Program2 {

  public static void main(String[] args) {

    limparTela();
    Scanner sc = new Scanner(System.in);

    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    System.out.println("\n\t=== TEST 1: findById =======");
    Department dep = departmentDao.findById(1);
    System.out.println(dep);

    System.out.println("\n\t=== TEST 2: findAll =======");
    List<Department> list = departmentDao.findAll();
    for (Department d : list) {
      System.out.println(d);
    }

    System.out.println("\n\t=== TEST 3: insert =======");
    Department newDepartment = new Department(null, "Music");
    departmentDao.insert(newDepartment);
    System.out.println("\n\tInserted! New id: " + newDepartment.getId());

    System.out.println("\n\t=== TEST 4: update =======");
    Department dep2 = departmentDao.findById(1);
    dep2.setName("Food");
    departmentDao.update(dep2);
    System.out.println("\n\tUpdate completed");

    System.out.println("\n\t=== TEST 5: delete =======");
    System.out.print("\n\tEnter id for delete test: ");
    int id = sc.nextInt();
    departmentDao.deleteById(id);
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
