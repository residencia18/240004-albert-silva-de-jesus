package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.MotoristaRepository;
import semana6.atvEmSala.P005.entities.Motorista;
import semana6.atvEmSala.P005.utils.Utils;

public class MotoristaService implements MotoristaRepository {
  
  public static List<Motorista> motoristas = new ArrayList<>();

  public void adcionar(Motorista motorista) {
    motoristas.add(motorista);
  }

  public static void cadastrarMotorista() {

    System.out.println("\n\t===== CADASTRO DE MOTORISTA =====");

    System.out.print("\n\tNome do Motorista: ");
    String nome = Utils.scan.nextLine();

    System.out.print("\tMatricula do Motorista: ");
    String matricula = Utils.scan.nextLine();

    motoristas.add(new Motorista(nome, matricula));

    System.out.println("\n\tMotorista cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public static void listarMotoristas() {

    System.out.println("\n\t===== LISTA DE MOTORISTAS =====");

    for (Motorista motorista : motoristas) {
      System.out.println(motorista.toString());
    }
    Utils.pausar(Utils.scan);
  }
}
