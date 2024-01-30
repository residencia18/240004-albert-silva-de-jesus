package jdbc.redesocial.dao;

import jdbc.redesocial.db.DB;
import jdbc.redesocial.service.PostagemDaoImpl;
import jdbc.redesocial.service.UsuarioDaoImpl;

public class DaoFactory {

  public static UsuarioDao createUsuarioDao() {
    return new UsuarioDaoImpl(DB.getConnection());
  }

  public static PostagemDao createPostagemDao() {
    return new PostagemDaoImpl(DB.getConnection());
  }
}
