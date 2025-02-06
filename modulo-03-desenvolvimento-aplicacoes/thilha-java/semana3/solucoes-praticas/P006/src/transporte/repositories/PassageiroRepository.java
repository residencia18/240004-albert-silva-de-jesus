package transporte.repositories;

import java.util.List;

import transporte.entities.Passageiro;

public interface PassageiroRepository {
  
  public void adicionar(Passageiro passageiro);

  public List<Passageiro> getPassageiros();

  public void cadastrarPassageiro();

  public void listarPassageiros();

  public void registroDePassageiroEmbarcadoComCartao();

  public void registroDePassageiros();

  public void carregarArquivo(String nomeArquivo);

  public void salvarArquivo(String nomeArquivo);

}