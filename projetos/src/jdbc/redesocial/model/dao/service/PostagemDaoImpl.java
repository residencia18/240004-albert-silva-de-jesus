package jdbc.redesocial.model.dao.service;

import java.sql.Connection;
import java.util.List;

import jdbc.redesocial.model.dao.PostagemDao;
import jdbc.redesocial.model.entities.Postagem;

public class PostagemDaoImpl implements PostagemDao{

  private Connection conn;

  public PostagemDaoImpl(Connection conn) {
    this.conn = conn;
  }
  
  @Override
  public void insert(Postagem obj) {
   
  }

  @Override
  public void update(Postagem obj) {
 
  }

  @Override
  public void deleteById(Integer id) {

  }

  @Override
  public Postagem findById(Integer id) {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<Postagem> findAll() {
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }
  
}
