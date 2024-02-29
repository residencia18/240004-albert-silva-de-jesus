package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.PassageiroRepository;
import semana6.atvEmSala.P005.entities.Passageiro;
import semana6.atvEmSala.P005.views.Views;

public class PassageiroService implements PassageiroRepository {

  public static List<Passageiro> passageiros = new ArrayList<>();
  private PontoDeParadaService pontoDeParadaService = new PontoDeParadaService();

  @Override
  public void adicionar(Passageiro passageiro) {
    passageiros.add(passageiro);
  }

  @Override
  public List<Passageiro> getPassageiros() {
    return passageiros;
  }

  @Override
  public void cadastrarPassageiro() {

    int tipoCartao = 0;

    Views.limparTela();
    System.out.println("\n\t===== CADASTRO DE PASSAGEIRO =====");

    System.out.print("\n\tNome do Passageiro: ");
    String nome = Views.scan.nextLine();

    System.out.print("\tCPF do Passageiro: ");
    String cpf = Views.scan.nextLine();

    passageiros.add(new Passageiro(nome, cpf, tipoCartaoPassageiro(tipoCartao)));

    System.out.println("\n\tPassageiro cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  @Override
  public void listarPassageiros() {

    Views.limparTela();
    System.out.print("\n\t===== LISTA DE PASSAGEIROS =====");

    for (Passageiro passageiro : passageiros) {
      System.out.println(passageiro.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }

  @Override
  public void registroDePassageiroEmbarcadoComCartao() {
    
    Views.limparTela();
    System.out.println("\n\t===== REGISTRO DE PASSAGEIRO EMBARCADO COM CARTÃO =====");

    boolean passageiroEncontrado = false;

    while (!passageiroEncontrado) {

      try {
        System.out.print("\n\tInforme o CPF do passageiro: ");
        String cpf = Views.scan.nextLine();

        for (Passageiro passageiro : passageiros) {
          if (passageiro.getCpf().equals(cpf)) {
            passageiro.setPontoEmbarque(pontoDeParadaService.trajetoEmbarque());
            passageiroEncontrado = true;
            break;
          }
        }

        if (!passageiroEncontrado) {
          System.out.println("\n\tPassageiro não encontrado. Tente novamente.");
        }
      } catch (Exception e) {
        System.out.println("\n\tOcorreu um erro: " + e.getMessage());
        Views.scan.nextLine(); // Limpar o buffer do scanner após a exceção
      }
    }
  }

  @Override
  public void registroDePassageiros() {

    Views.limparTela();
    System.out.println("\n\t===== REGISTRO DE PASSAGEIRO EMBARCADOS COM CARTÃO =====");

    for(Passageiro passageiro : passageiros) {
      if(passageiro.getPontoEmbarque() != null) {
        System.out.println(passageiro.toString());
        System.out.print("\t============================");
      }
      Views.pausar(Views.scan);
    }
  }

  public static String tipoCartaoPassageiro(int opcao) {

    String tipoCartao = "";
    opcao = opcaoCartaoPassageiro();

    Views.limparTela();
    switch (opcao) {
      case 1:
        tipoCartao = "Estudante";
        break;
      case 2:
        tipoCartao = "Idoso";
        break;
      case 3:
        tipoCartao = "Normal";
        break;
    }

    return tipoCartao;
  }

  public static int opcaoCartaoPassageiro() {

    boolean opcaoValida = false;
    int tipoCartao = 0;

    do {

      try {

        System.out.println("\n\tTipo de Cartão: ");
        System.out.println("\t1 - Estudante");
        System.out.println("\t2 - Idoso");
        System.out.println("\t3 - Normal");
        System.out.print("\tOpção: ");

        tipoCartao = Integer.parseInt(Views.scan.nextLine());

        if (tipoCartao >= 1 && tipoCartao <= 3) {
          opcaoValida = true;

        } else {
          Views.limparTela();
          System.out.println("\n\tOpção inválida. Digite um número entre 1 e 3.");
        }

      } catch (NumberFormatException e) {
        Views.limparTela();
        System.out.println("\n\tPor favor, digite um número válido.");
      }
    } while (!opcaoValida);

    return tipoCartao;
  }

}