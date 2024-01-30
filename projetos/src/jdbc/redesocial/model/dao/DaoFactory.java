package jdbc.redesocial.model.dao;

import jdbc.redesocial.db.DB;
import jdbc.redesocial.model.dao.service.PostagemDaoImpl;
import jdbc.redesocial.model.dao.service.UsuarioDaoImpl;

public class DaoFactory {

  public static UsuarioDao createUsuarioDao() {
    return new UsuarioDaoImpl(DB.getConnection());
  }

  public static PostagemDao createPostagemDao() {
    return new PostagemDaoImpl(DB.getConnection());
  }
}
