package p009.dao.impl;

import p009.dao.ClienteDao;
import p009.dao.ImovelDao;
import p009.db.DB;

public class DaoFactory {

  public static ClienteDao createClienteDao() {
    return new ClienteDaoImpl(DB.getConnection());
  }

  public static ImovelDao createImovelDao() {
    return new ImovelDaoImpl(DB.getConnection());
  }
}
