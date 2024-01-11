package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.CobradorRepository;
import semana6.atvEmSala.P005.entities.Cobrador;
import semana6.atvEmSala.P005.utils.Utils;

public class CobradorService implements CobradorRepository {

  private static List<Cobrador> cobradores = new ArrayList<>();

  public void adcionar(Cobrador cobrador) {
    cobradores.add(cobrador);
  }

  public static void cadastrarCobrador() {

    System.out.println("\n\t===== CADASTRO DE COBRADOR =====");

    System.out.print("\n\tNome do Cobrador: ");
    String nome = Utils.scan.nextLine();

    System.out.print("\tMatricula do Cobrador: ");
    String matricula = Utils.scan.nextLine();

    cobradores.add(new Cobrador(nome, matricula));
  }

  public static void listarCobradores() {

    System.out.println("\n\t===== LISTA DE COBRADORES =====");

    for (Cobrador cobrador : cobradores) {
      System.out.println(cobrador.toString());
    }
    Utils.pausar(Utils.scan);
  }

}
