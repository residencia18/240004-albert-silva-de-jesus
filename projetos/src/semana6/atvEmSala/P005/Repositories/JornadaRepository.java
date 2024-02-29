package semana6.atvEmSala.P005.Repositories;

import java.util.List;

import semana6.atvEmSala.P005.entities.Jornada;

public interface JornadaRepository {

  public void adicionar(Jornada jornada);

  public List<Jornada> getJornadas();

  public void cadastrarJornada();

  public void listarJornadas();
}
