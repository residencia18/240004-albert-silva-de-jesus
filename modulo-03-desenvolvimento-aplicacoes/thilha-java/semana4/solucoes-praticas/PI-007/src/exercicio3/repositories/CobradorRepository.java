package exercicio3.repositories;

import java.util.List;

import exercicio3.entities.Cobrador;

public interface CobradorRepository {

  public void adicionar(Cobrador cobrador);

  public List<Cobrador> getCobradores();

  public void cadastrarCobrador();

  public void listarCobradores();

  public void carregarArquivoJSON(String nomeArquivo);

  public void salvarArquivoJSON(String nomeArquivo);

  public void excluirArquivoJSON();

  public void alterarArquivoJSON(); 
}
