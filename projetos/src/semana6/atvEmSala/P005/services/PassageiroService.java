package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.PassageiroRepository;
import semana6.atvEmSala.P005.entities.Passageiro;
import semana6.atvEmSala.P005.utils.Utils;

public class PassageiroService implements PassageiroRepository {

  public static List<Passageiro> passageiros = new ArrayList<>();

  public void adicionar(Passageiro passageiro) {
    passageiros.add(passageiro);
  }

  public static void cadastrarPassageiro() {

    int tipoCartao = 0;

    System.out.println("\n\t===== CADASTRO DE PASSAGEIRO =====");

    System.out.print("\n\tNome do Passageiro: ");
    String nome = Utils.scan.nextLine();

    System.out.print("\tCPF do Passageiro: ");
    String cpf = Utils.scan.nextLine();

    passageiros.add(new Passageiro(nome, cpf, tipoCartaoPassageiro(tipoCartao)));

    System.out.println("\n\tPassageiro cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public static void listarPassageiros() {

    System.out.println("\n\t===== LISTA DE PASSAGEIROS =====");

    for (Passageiro passageiro : passageiros) {
      System.out.println(passageiro.toString());
      System.out.println("\t============================");
    }
    Utils.pausar(Utils.scan);
  }

  public static String tipoCartaoPassageiro(int opcao) {

    String tipoCartao = "";
    opcao = opcaoCartaoPassageiro();

    Utils.limparTela(); 
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

        tipoCartao = Integer.parseInt(Utils.scan.nextLine());

        if (tipoCartao >= 1 && tipoCartao <= 3) {
          opcaoValida = true;

        } else {
          Utils.limparTela();
          System.out.println("\n\tOpção inválida. Digite um número entre 1 e 3.");
        }

      } catch (NumberFormatException e) {
        Utils.limparTela();
        System.out.println("\n\tPor favor, digite um número válido.");
      }
    } while (!opcaoValida);

    return tipoCartao;
  }

}