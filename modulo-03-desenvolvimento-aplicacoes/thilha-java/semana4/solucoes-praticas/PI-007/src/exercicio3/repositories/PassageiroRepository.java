package exercicio3.repositories;

import java.util.List;

import exercicio3.entities.Passageiro; 

public interface PassageiroRepository {
  
  public void adicionar(Passageiro passageiro);

  public List<Passageiro> getPassageiros();

  public void cadastrarPassageiro();

  public void listarPassageiros();

  public void registroDePassageiroEmbarcadoComCartao();

  public void registroDePassageiros();

  public void carregarArquivoJSON(String nomeArquivo);

  public void salvarArquivoJSON(String nomeArquivo);

}