package exercicio3.repositories;

import java.util.List;

import exercicio3.entities.Jornada;

public interface JornadaRepository {

  public void adicionar(Jornada jornada);

  public List<Jornada> getJornadas();

  public void cadastrarJornada();

  public void listarJornadas();

  public void carregarArquivoJSON(String nomeArquivo);

  public void salvarArquivoJSON(String nomeArquivo);
}
