package semana10.jdbc.redesocial.model.dao;

import semana10.jdbc.redesocial.db.DB;
import semana10.jdbc.redesocial.model.dao.service.PostagemDaoImpl;
import semana10.jdbc.redesocial.model.dao.service.UsuarioDaoImpl;

public class DaoFactory {

  public static UsuarioDao createUsuarioDao() {
    return new UsuarioDaoImpl(DB.getConnection());
  }

  public static PostagemDao createPostagemDao() {
    return new PostagemDaoImpl(DB.getConnection());
  }
}
