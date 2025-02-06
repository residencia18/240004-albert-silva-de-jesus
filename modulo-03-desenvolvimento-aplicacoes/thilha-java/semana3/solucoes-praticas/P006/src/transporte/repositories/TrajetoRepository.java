package transporte.repositories;

import java.util.List;

import transporte.entities.Trajeto;

public interface TrajetoRepository {
  

  public void adicionar(Trajeto trecho);

  public List<Trajeto> getTrajetos();

  public void cadastrarTrajeto();

  public void registroDeTrajeto();

  public void listarTrajetos();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);
}
