package transporte.repositories;

import java.util.List;

import transporte.entities.Motorista;

public interface MotoristaRepository {
  
  public void adicionar(Motorista motorista);

  public List<Motorista> getMotoristas();

  public void cadastrarMotorista();

  public void listarMotoristas();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);
}
