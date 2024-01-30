package jdbc.redesocial.dao;

import jdbc.redesocial.db.DB;
import jdbc.redesocial.service.PostagemDaoImpl;
import jdbc.redesocial.service.UsuarioDaoImpl;

public class DaoFactory {

  public static UsuarioDao createUsuario() {
    return new UsuarioDaoImpl(DB.getConnection());
  }

  public static PostagemDao createDepartmentDao() {
    return new PostagemDaoImpl(DB.getConnection());
  }
}
