package semana8.p007.exercicio3.services;

import java.util.ArrayList;
import java.util.List;

import semana8.p007.exercicio3.entities.Cobrador;
import semana8.p007.exercicio3.persistencia.JsonCobradores;
import semana8.p007.exercicio3.repositories.CobradorRepository;
import semana8.p007.exercicio3.views.Views;

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

    Cobrador cobrador = new Cobrador(nome, matricula);
    adicionar(cobrador);

    // Escrever no arquivo JSON
    // escreverJson(cobrador);

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
  public void carregarArquivoJSON(String nomeArquivo) {
    cobradores = JsonCobradores.carregarCobradoresDeArquivoJSON(nomeArquivo);

    if (cobradores != null) {
      Views.limparTela();
      System.out.println("\n\tCobradores carregados do arquivo: " + nomeArquivo);
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void salvarArquivoJSON(String nomeArquivo) {
    JsonCobradores.salvarCobradoresEmArquivoJSON(cobradores, nomeArquivo);
  }

  @Override
  public void excluirArquivoJSON() {

    Views.limparTela();
    int indiceParaExcluir = -1;

    System.err.println("\n\t========== EXCLUIR COBRADORES ==========");

    System.out.print("\n\tInforme o número de matrícula do cobrador que deseja excluir: ");
    String matricula = Views.scan.nextLine();

    // Procurando o cobrador pelo número de matrícula e armazenando o índice para
    // excluir
    for (int i = 0; i < cobradores.size(); i++) {

      if (cobradores.get(i).getMatricula().equals(matricula)) {
        indiceParaExcluir = i;
        break;
      }
    }

    if (indiceParaExcluir >= 0) {

      Views.limparTela();
      System.out.print("\n\tCobrador encontrado:");
      System.out.println("\t"+ cobradores.get(indiceParaExcluir));

      // loop de confirmação de exclusão do cobrador
      while (true) {

        System.out.print("\n\tDeseja realmente excluir este cobrador? (S/N): ");
        String resposta = Views.scan.nextLine().trim().toUpperCase();

        if (resposta.equals("S")) {

          cobradores.remove(indiceParaExcluir);
          JsonCobradores.excluirCobradorJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\cobrador.json",
              indiceParaExcluir);
          break; // Sai do loop se a exclusão for confirmada

        } else if (resposta.equals("N")) {
          System.out.println("\n\tExclusão cancelada pelo usuário.");
          break; // Sai do loop se a exclusão for cancelada

        } else {
          System.err.println("\n\tOpção inválida. Por favor, digite S para Sim ou N para Não.");
        }
      }
    } else {
      System.err.println("\n\tCobrador não encontrado!");
    }

    Views.pausar(Views.scan);
  }

  @Override
  public void alterarArquivoJSON() {

    Views.limparTela();
    int indiceParaAlterar = -1;

    System.err.println("\n\t========== ALTERAR COBRADORES ===========");

    System.out.print("\n\tInforme o número de matrícula do cobrador que deseja alterar: ");
    String matricula = Views.scan.nextLine();

    // Procurando o cobrador pelo número de matrícula e armazenando o índice para
    // alterar
    for (int i = 0; i < cobradores.size(); i++) {
      if (cobradores.get(i).getMatricula().equals(matricula)) {
        indiceParaAlterar = i;
        break;
      }
    }

    if (indiceParaAlterar >= 0) {

      Views.limparTela();
      System.out.print("\n\tCobrador encontrado:");
      System.out.println("\t"+ cobradores.get(indiceParaAlterar));

      // loop de confirmação de alteração do cobrador
      while (true) {

        System.out.print("\n\tDeseja realmente alterar este cobrador? (S/N): ");
        String resposta = Views.scan.nextLine().trim().toUpperCase();

        if (resposta.equals("S")) {

          Views.limparTela();
          System.out.println("\n\tInforme os novos dados do cobrador: ");
          System.out.print("\n\tNome do Cobrador: ");
          String nome = Views.scan.nextLine();

          System.out.print("\tMatricula do Cobrador: ");
          String novaMatricula = Views.scan.nextLine();

          Cobrador novoCobrador = new Cobrador(nome, novaMatricula);

          cobradores.set(indiceParaAlterar, novoCobrador);
          JsonCobradores.alterarCobradorJSON("projetos\\src\\semana8\\p007\\exercicio3\\json\\cobrador.json",
              indiceParaAlterar, novoCobrador);
          break; // Sai do loop se a alteração for confirmada

        } else if (resposta.equals("N")) {
          System.out.println("\n\tAlteração cancelada pelo usuário.");
          break; // Sai do loop se a alteração for cancelada

        } else {
          System.err.println("\n\tOpção inválida. Por favor, digite S para Sim ou N para Não.");
        }

      }

    } else {
      System.err.println("\n\tCobrador não encontrado!");
    }

    Views.pausar(Views.scan);

  }

}