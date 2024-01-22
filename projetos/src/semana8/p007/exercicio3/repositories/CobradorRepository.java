package semana8.p007.exercicio3.repositories;

import java.util.List;

import semana8.p007.exercicio3.entities.Cobrador;

public interface CobradorRepository {

  public void adicionar(Cobrador cobrador);

  public List<Cobrador> getCobradores();

  public void cadastrarCobrador();

  public void listarCobradores();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);
}
