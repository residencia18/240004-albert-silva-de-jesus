package semana6.atvEmSala.P005.services;

import java.util.ArrayList;
import java.util.List;

import semana6.atvEmSala.P005.Repositories.VeiculoRepository;
import semana6.atvEmSala.P005.entities.Veiculo;
import semana6.atvEmSala.P005.utils.Utils;

public class VeiculoService implements VeiculoRepository{

  public static List<Veiculo> veiculos = new ArrayList<>();

  public void adcionar(Veiculo veiculo) {
    veiculos.add(veiculo);
  }

  public static void cadastrarVeiculo() {

    System.out.println("\n\t===== CADASTRO DE VEICULO =====");

    System.out.print("\n\tPlaca do Veiculo: ");
    String placa = Utils.scan.nextLine();

    System.out.print("\tModelo do Veiculo: ");
    String modelo = Utils.scan.nextLine();

    veiculos.add(new Veiculo(placa, modelo));

    System.out.println("\n\tVeiculo cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public static void listarVeiculos() {

    System.out.println("\n\t===== LISTA DE VEICULOS =====");

    for (Veiculo veiculo : veiculos) {
      System.out.println(veiculo.toString());
      System.out.println("\t============================");
    }
    Utils.pausar(Utils.scan);
  }
}
