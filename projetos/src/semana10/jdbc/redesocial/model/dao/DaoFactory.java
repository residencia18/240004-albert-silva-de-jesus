package redesocial.model.dao;

import redesocial.db.DB;
import redesocial.model.dao.service.PostagemDaoImpl;
import redesocial.model.dao.service.UsuarioDaoImpl;

public class DaoFactory {

  public static UsuarioDao createUsuarioDao() {
    return new UsuarioDaoImpl(DB.getConnection());
  }

  public static PostagemDao createPostagemDao() {
    return new PostagemDaoImpl(DB.getConnection());
  }
}
