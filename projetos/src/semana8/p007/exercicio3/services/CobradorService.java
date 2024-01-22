package semana8.p007.exercicio3.services;

import java.util.ArrayList;
import java.util.List;

import semana7.P006.exercicio4.entities.Cobrador;
import semana7.P006.exercicio4.repositories.CobradorRepository;
import semana7.P006.exercicio4.views.Views;
import semana7.P006.exercicio4.persistencia.ArquivoCobradores;

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

    adicionar(new Cobrador(nome, matricula));

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

  @Override
  public void carregarArquivo(String nomeArquivo) {
    cobradores = ArquivoCobradores.carregarDeArquivo(nomeArquivo);

    if (cobradores != null) {
      Views.limparTela();
      System.out.println("\n\tCobradores carregados do arquivo: " + nomeArquivo);
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void salvarArquivo(String nomeArquivo) {
    ArquivoCobradores.salvarEmArquivo(cobradores, nomeArquivo);
  }

}
