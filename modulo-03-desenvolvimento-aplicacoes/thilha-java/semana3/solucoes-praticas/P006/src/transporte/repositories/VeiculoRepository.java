package transporte.repositories;

import java.util.List;

import transporte.entities.Veiculo;

public interface VeiculoRepository {
  
  public void adicionar(Veiculo veiculo);

  public List<Veiculo> getVeiculos();

  public void cadastrarVeiculo();

  public void listarVeiculos();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);
}