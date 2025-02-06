package exercicio3.repositories;

import java.util.List;

import exercicio3.entities.Veiculo;

public interface VeiculoRepository {
  
  public void adicionar(Veiculo veiculo);

  public List<Veiculo> getVeiculos();

  public void cadastrarVeiculo();

  public void listarVeiculos();

  public void carregarArquivoJSON(String nomeArquivo);

  public void salvarArquivoJSON(String nomeArquivo);
}