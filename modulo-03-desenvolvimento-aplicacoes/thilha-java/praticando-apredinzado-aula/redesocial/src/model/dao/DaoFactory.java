package model.dao;

import db.DB;
import model.dao.service.PostagemDaoImpl;
import model.dao.service.UsuarioDaoImpl;

public class DaoFactory {

  public static UsuarioDao createUsuarioDao() {
    return new UsuarioDaoImpl(DB.getConnection());
  }

  public static PostagemDao createPostagemDao() {
    return new PostagemDaoImpl(DB.getConnection());
  }
}
