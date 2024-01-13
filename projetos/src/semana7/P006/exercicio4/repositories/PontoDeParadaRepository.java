package semana7.P006.exercicio4.repositories;

import semana6.atvEmSala.P005.entities.PontosDeParada;

public interface PontoDeParadaRepository {
  
  public void adicionar(PontosDeParada pontoDeParada);

  public void cadastrarPontoDeParada();

  public void listarPontosDeParada();

  public String trajetoEmbarque();

  public String trajetoDesembarque();
}
