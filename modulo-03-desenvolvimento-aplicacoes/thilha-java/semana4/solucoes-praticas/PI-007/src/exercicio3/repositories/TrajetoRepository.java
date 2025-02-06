package exercicio3.repositories;

import java.util.List;

import exercicio3.entities.Trajeto;

public interface TrajetoRepository {
  

  public void adicionar(Trajeto trecho);

  public List<Trajeto> getTrajetos();

  public void cadastrarTrajeto();

  public void registroDeTrajeto();

  public void listarTrajetos();

  public void carregarArquivoJSON(String nomeArquivo);

  public void salvarArquivoJSON(String nomeArquivo);
}
