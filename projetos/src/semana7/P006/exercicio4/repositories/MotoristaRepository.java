package semana7.P006.exercicio4.repositories;

import java.util.List;

import semana7.P006.exercicio4.entities.Motorista;

public interface MotoristaRepository {
  
  public void adicionar(Motorista motorista);

  public List<Motorista> getMotoristas();

  public void cadastrarMotorista();

  public void listarMotoristas();
}
