package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.VeiculoRepository;
import semana6.atvEmSala.P005.entities.Veiculo;
import semana6.atvEmSala.P005.views.Views;

public class VeiculoService implements VeiculoRepository{

  public static List<Veiculo> veiculos = new ArrayList<>();

  @Override
  public void adicionar(Veiculo veiculo) {
    veiculos.add(veiculo);
  }

  @Override
  public List<Veiculo> getVeiculos() {
    return veiculos;
  }

  public void cadastrarVeiculo() {

    Views.limparTela();
    System.out.println("\n\t===== CADASTRO DE VEICULO =====");

    System.out.print("\n\tPlaca do Veiculo: ");
    String placa = Views.scan.nextLine();

    System.out.print("\tModelo do Veiculo: ");
    String modelo = Views.scan.nextLine();

    veiculos.add(new Veiculo(placa, modelo));

    System.out.println("\n\tVeiculo cadastrado com sucesso!");
    Views.pausar(Views.scan);
  }

  public void listarVeiculos() {

    Views.limparTela();
    System.out.println("\n\t===== LISTA DE VEICULOS =====");

    for (Veiculo veiculo : veiculos) {
      System.out.println(veiculo.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }
}
