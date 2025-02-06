package dao.impl;

import dao.ClienteDao;
import dao.FaturaDao;
import dao.ImovelDao;
import db.DB;

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
