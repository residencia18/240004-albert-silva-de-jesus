package semana7.P006.exercicio4.repositories;

import java.util.List;

import semana7.P006.exercicio4.entities.Cobrador;

public interface CobradorRepository {

  public void adicionar(Cobrador cobrador);

  public List<Cobrador> getCobradores();

  public void cadastrarCobrador();

  public void listarCobradores();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);
}
