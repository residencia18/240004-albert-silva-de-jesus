package semana7.P006.exercicio4.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.entities.Cobrador;
import semana6.atvEmSala.P005.repositories.CobradorRepository;
import semana6.atvEmSala.P005.views.Views;

public class CobradorService implements CobradorRepository {

  public static List<Cobrador> cobradores = new ArrayList<>();

  @Override
  public void adicionar(Cobrador cobrador) {
    cobradores.add(cobrador);
  }

  @Override
  public List<Cobrador> getCobradores() {
    return cobradores;
  }

  @Override
  public void cadastrarCobrador() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRO DE COBRADOR =====");

    System.out.print("\n\tNome do Cobrador: ");
    String nome = Views.scan.nextLine();

    System.out.print("\tMatricula do Cobrador: ");
    String matricula = Views.scan.nextLine();

    cobradores.add(new Cobrador(nome, matricula));
    
    System.out.println("\n\tCobrador cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  @Override
  public void listarCobradores() {

    Views.limparTela();
    System.out.print("\n\t===== LISTA DE COBRADORES =====");

    for (Cobrador cobrador : cobradores) {
      System.out.println(cobrador.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }

}
