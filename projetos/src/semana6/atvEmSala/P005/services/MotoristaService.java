package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.MotoristaRepository;
import semana6.atvEmSala.P005.entities.Motorista;
import semana6.atvEmSala.P005.views.Views;

public class MotoristaService implements MotoristaRepository {
  
  public static List<Motorista> motoristas = new ArrayList<>();

  public void adicionar(Motorista motorista) {
    motoristas.add(motorista);
  }

  public static void cadastrarMotorista() {

    System.out.println("\n\t===== CADASTRO DE MOTORISTA =====");

    System.out.print("\n\tNome do Motorista: ");
    String nome = Views.scan.nextLine();

    System.out.print("\tMatricula do Motorista: ");
    String matricula = Views.scan.nextLine();

    motoristas.add(new Motorista(nome, matricula));

    System.out.println("\n\tMotorista cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  public static void listarMotoristas() {

    System.out.println("\n\t===== LISTA DE MOTORISTAS =====");

    for (Motorista motorista : motoristas) {
      System.out.println(motorista.toString());
      System.out.println("\t============================");
    }
    Views.pausar(Views.scan);
  }
}
