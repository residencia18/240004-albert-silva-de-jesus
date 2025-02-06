package transporte.repositories;

import java.util.List;

import transporte.entities.Jornada;

public interface JornadaRepository {

  public void adicionar(Jornada jornada);

  public List<Jornada> getJornadas();

  public void cadastrarJornada();

  public void listarJornadas();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);
}
