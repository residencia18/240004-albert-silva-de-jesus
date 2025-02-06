package exercicio3.repositories;

import java.util.List;

import exercicio3.entities.Motorista;

public interface MotoristaRepository {
  
  public void adicionar(Motorista motorista);

  public List<Motorista> getMotoristas();

  public void cadastrarMotorista();

  public void listarMotoristas();

  public void carregarArquivoJSON(String nomeArquivo);

  public void salvarArquivoJSON(String nomeArquivo);
}
