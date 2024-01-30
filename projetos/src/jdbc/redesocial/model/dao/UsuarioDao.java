package jdbc.redesocial.model.dao;

import java.util.List;

import jdbc.redesocial.model.entities.Postagem;
import jdbc.redesocial.model.entities.Usuario;

public interface UsuarioDao {

  Integer cadastrar();

  void insert(Usuario obj);

  void update(Usuario obj);

  void deleteById(Integer id);

  Usuario findById(Integer id);

  List<Usuario> findAll();

  List<Usuario> findByDepartment(Postagem postagem);
}
