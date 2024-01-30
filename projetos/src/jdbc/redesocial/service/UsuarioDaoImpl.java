package jdbc.redesocial.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jdbc.redesocial.dao.UsuarioDao;
import jdbc.redesocial.db.DB;
import jdbc.redesocial.db.DbException;
import jdbc.redesocial.entities.Postagem;
import jdbc.redesocial.entities.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

  private Connection conn;

  public UsuarioDaoImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void insert(Usuario obj) {

    PreparedStatement st = null;
    try {
      st = conn.prepareStatement("INSERT INTO usuario " + "(login, senha, email) "
          + "VALUES " + "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

      st.setString(1, obj.getLogin());
      st.setString(2, obj.getSenha());
      st.setString(3, obj.getEmail());

      int rowsAffected = st.executeUpdate();

      if (rowsAffected > 0) {
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
          int id = rs.getInt(1);
          obj.setId(id);
        }
        DB.closeResultSet(rs);

      } else {
        throw new DbException("Unexpected error! No rows affected!");
      }
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
      
    } finally {
      DB.closeStatement(st);
    }
  }

  @Override
  public void update(Usuario obj) {

  }

  @Override
  public void deleteById(Integer id) {

  }

  @Override
  public Usuario findById(Integer id) {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<Usuario> findAll() {
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public List<Usuario> findByDepartment(Postagem postagem) {
    throw new UnsupportedOperationException("Unimplemented method 'findByDepartment'");
  }

}
