package semana7.P006.exercicio4.repositories;

import java.util.List;

import semana6.atvEmSala.P005.entities.Trajeto;

public interface TrajetoRepository {
  

  public void adicionar(Trajeto trecho);

  public List<Trajeto> getTrajetos();

  public void cadastrarTrajeto();

  public void registroDeTrajeto();

  public void listarTrajetos();
}
