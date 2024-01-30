package jdbc.redesocial.service;

import java.sql.Connection;
import java.util.List;

import jdbc.redesocial.dao.UsuarioDao;
import jdbc.redesocial.entities.Postagem;
import jdbc.redesocial.entities.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

  private Connection conn;

  public UsuarioDaoImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void insert(Usuario obj) {

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
