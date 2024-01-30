package jdbc.redesocial.dao;

import java.util.List;

import jdbc.redesocial.entities.Postagem;
import jdbc.redesocial.entities.Usuario;

public interface UsuarioDao {

  void insert(Usuario obj);

  void update(Usuario obj);

  void deleteById(Integer id);

  Usuario findById(Integer id);

  List<Usuario> findAll();

  List<Usuario> findByDepartment(Postagem postagem);
}
