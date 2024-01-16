package semana7.P006.exercicio4.repositories;

import java.util.List;

import semana7.P006.exercicio4.entities.Passageiro;

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