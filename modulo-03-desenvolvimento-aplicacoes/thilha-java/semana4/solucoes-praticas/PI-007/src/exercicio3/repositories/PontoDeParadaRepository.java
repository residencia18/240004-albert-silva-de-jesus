package exercicio3.repositories;

import exercicio3.entities.PontosDeParada;

public interface PontoDeParadaRepository {
  
  public void adicionar(PontosDeParada pontoDeParada);

  public void cadastrarPontoDeParada();

  public void listarPontosDeParada();

  public String trajetoEmbarque();

  public String trajetoDesembarque();

  public void carregarArquivoJSON(String nomeArquivo);

  public void salvarArquivoJSON(String nomeArquivo);
}
