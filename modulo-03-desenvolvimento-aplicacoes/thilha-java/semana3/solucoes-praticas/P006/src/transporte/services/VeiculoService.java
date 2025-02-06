package transporte.services;

import java.util.ArrayList;
import java.util.List;

import transporte.entities.Veiculo;
import transporte.persistencia.ArquivoVeiculos;
import transporte.repositories.VeiculoRepository;
import transporte.views.Views;

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

  @Override
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

  @Override
  public void listarVeiculos() {

    Views.limparTela();
    System.out.println("\n\t===== LISTA DE VEICULOS =====");

    for (Veiculo veiculo : veiculos) {
      System.out.println(veiculo.toString());
      System.out.print("\t============================");
    }
    Views.pausar(Views.scan);
  }

  @Override
  public void carregarArquivo(String nomeArquivo) {
    veiculos = ArquivoVeiculos.carregarVeiculosDeArquivo(nomeArquivo);

    if (veiculos != null) {
      Views.limparTela();
      System.out.println("\n\tVeiculos carregados do arquivo: " + nomeArquivo);
      Views.pausar(Views.scan);
    }
  }

  @Override
  public void salvarArquivo(String nomeArquivo) {
    ArquivoVeiculos.salvarVeiculosEmArquivo(veiculos, nomeArquivo);
  }
}