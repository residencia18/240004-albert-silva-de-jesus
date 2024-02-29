package semana10.p009.dao.impl;

import semana10.p009.dao.ClienteDao;
import semana10.p009.dao.FaturaDao;
import semana10.p009.dao.ImovelDao;
import semana10.p009.db.DB;

public class DaoFactory {

  public static ClienteDao createClienteDao() {
    return new ClienteDaoImpl(DB.getConnection());
  }

  public static ImovelDao createImovelDao() {
    return new ImovelDaoImpl(DB.getConnection());
  }

  public static FaturaDao createFaturaDao() {
    return new FaturaDaoImpl(DB.getConnection());
  }
}
