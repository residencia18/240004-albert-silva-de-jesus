package transporte.repositories;

import java.util.List;

import transporte.entities.Cobrador;

public interface CobradorRepository {

  public void adicionar(Cobrador cobrador);

  public List<Cobrador> getCobradores();

  public void cadastrarCobrador();

  public void listarCobradores();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);
}
