package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.CobradorRepository;
import semana6.atvEmSala.P005.entities.Cobrador;
import semana6.atvEmSala.P005.views.Views;

public class CobradorService implements CobradorRepository {

  public List<Cobrador> cobradores = new ArrayList<>();

  public void adicionar(Cobrador cobrador) {
    cobradores.add(cobrador);
  }

  public void cadastrarCobrador() {

    System.out.println("\n\t===== CADASTRO DE COBRADOR =====");

    System.out.print("\n\tNome do Cobrador: ");
    String nome = Views.scan.nextLine();

    System.out.print("\tMatricula do Cobrador: ");
    String matricula = Views.scan.nextLine();

    cobradores.add(new Cobrador(nome, matricula));
    
    System.out.println("\n\tCobrador cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  public void listarCobradores() {

    System.out.print("\n\t===== LISTA DE COBRADORES =====");

    for (Cobrador cobrador : cobradores) {
      System.out.println(cobrador.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }

}
