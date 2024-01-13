package semana7.P006.exercicio4.services;

import java.util.ArrayList;
import java.util.List;

import semana4.atvemsala.redesocial.Utils;
import semana6.atvEmSala.P005.entities.Cobrador;
import semana6.atvEmSala.P005.entities.Jornada;
import semana6.atvEmSala.P005.entities.Motorista;
import semana6.atvEmSala.P005.entities.Trajeto;
import semana6.atvEmSala.P005.entities.Veiculo;
import semana6.atvEmSala.P005.repositories.JornadaRepository;
import semana6.atvEmSala.P005.views.Views;

public class JornadaService implements JornadaRepository {

  public static List<Jornada> jornadas = new ArrayList<Jornada>();

  @Override
  public void adicionar(Jornada jornada) {
    jornadas.add(jornada);
  }

  @Override
  public List<Jornada> getJornadas() {
    return jornadas;
  }

  // public static void cadastrarJornada() {

  // System.out.println("\n\t===== CADASTRAR JORNADA =====\n");

  // System.out.println("\tEscolha o trajeto: ");
  // for (int i = 0; i < TrajetoService.trajetos.size(); i++) {
  // System.out.println("\t" + (i + 1) + " - " + TrajetoService.trajetos.get(i));
  // }
  // System.out.println("\tOpção: ");
  // int opcaoTrajeto = Utils.scan.nextInt();
  // Utils.scan.nextLine();

  // System.out.println("\tEscolha o veículo: ");
  // for (int i = 0; i < VeiculoService.veiculos.size(); i++) {
  // System.out.println("\t" + (i + 1) + " - " + VeiculoService.veiculos.get(i));
  // }
  // System.out.println("\tOpção: ");
  // int opcaoVeiculo = Utils.scan.nextInt();

  // System.out.println("\tEscolha o motorista: ");
  // for (int i = 0; i < MotoristaService.motoristas.size(); i++) {
  // System.out.println("\t" + (i + 1) + " - " +
  // MotoristaService.motoristas.get(i));
  // }
  // System.out.println("\tOpção: ");
  // int opcaoMotorista = Utils.scan.nextInt();

  // System.out.println("\tEscolha o cobrador: ");
  // for (int i = 0; i < CobradorService.cobradores.size(); i++) {
  // System.out.println("\t" + (i + 1) + " - " +
  // CobradorService.cobradores.get(i));
  // }
  // System.out.println("\tOpção: ");
  // int opcaoCobrador = Utils.scan.nextInt();

  // Jornada jornada = new Jornada(TrajetoService.trajetos.get(opcaoTrajeto - 1),
  // VeiculoService.veiculos.get(opcaoVeiculo - 1),
  // MotoristaService.motoristas.get(opcaoMotorista - 1),
  // CobradorService.cobradores.get(opcaoCobrador - 1));
  // jornadas.add(jornada);

  // System.out.println("\n\tJornada cadastrada com sucesso!");
  // Utils.pausar(Utils.scan);

  // }

  @Override
  public void cadastrarJornada() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRAR JORNADA =====\n");

    Trajeto trajeto = selecionarOpcao("\tEscolha o trajeto: ", TrajetoService.trajetos);
    Veiculo veiculo = selecionarOpcao("\tEscolha o veículo: ", VeiculoService.veiculos);
    Motorista motorista = selecionarOpcao("\tEscolha o motorista: ", MotoristaService.motoristas);
    Cobrador cobrador = selecionarOpcao("\tEscolha o cobrador: ", CobradorService.cobradores);

    jornadas.add(new Jornada(trajeto, veiculo, motorista, cobrador));

    System.out.println("\n\tJornada cadastrada com sucesso!");
    Utils.pausar(Utils.scan);
  }

  private static <T> T selecionarOpcao(String mensagem, List<T> opcoes) {

    Utils.limparTela();
    System.out.println(mensagem);
    System.out.println("\t============================");
    for (int i = 0; i < opcoes.size(); i++) {
      System.out.println("\t" + (i + 1) + "º" + opcoes.get(i));
      System.out.println("\t============================");
    }
    System.out.print("\tOpção: ");

    int opcao = Utils.scan.nextInt();
    Utils.scan.nextLine(); // Consumir a quebra de linha pendente

    if (opcao < 1 || opcao > opcoes.size()) {
      System.out.println("\n\tOpção inválida. Digite um número entre 1 e " + opcoes.size());
      Utils.pausar(Utils.scan);
      return selecionarOpcao(mensagem, opcoes); // Chamada recursiva em caso de opção inválida
    }

    return opcoes.get(opcao - 1);
    
  }

  public void listarJornadas() {

    Views.limparTela();
    System.out.println("\n\t===== LISTA DE JORNADAS =====");

    for (Jornada jornada : jornadas) {
      System.out.println(jornada.toString());
      System.out.print("\t============================");
    }
    Utils.pausar(Utils.scan);
  }
}