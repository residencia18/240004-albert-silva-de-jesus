package redesocial.model.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import redesocial.model.dao.PostagemDao;
import redesocial.model.entities.Postagem;

public class PostagemDaoImpl implements PostagemDao {

  private Connection conn;

  public PostagemDaoImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void insert(Postagem obj) {

    PreparedStatement st = null;

    try {
      st = conn.prepareStatement("INSERT INTO postagem " + "(login, texto) " + "VALUES " + "(?, ?)");

      st.setString(1, obj.getLogin());
      st.setString(2, obj.getTexto());
      
      st.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
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
