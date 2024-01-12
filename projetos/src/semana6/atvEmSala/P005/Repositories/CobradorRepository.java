package semana6.atvEmSala.P005.Repositories;

import semana6.atvEmSala.P005.entities.Cobrador;

public interface CobradorRepository {
  
  public void adicionar(Cobrador cobrador);
  
  public void cadastrarCobrador();

  public void listarCobradores();
}
