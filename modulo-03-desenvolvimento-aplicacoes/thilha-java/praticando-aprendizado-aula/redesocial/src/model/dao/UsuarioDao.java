package model.dao;

import java.util.List;

import model.entities.Postagem;
import model.entities.Usuario;

public interface UsuarioDao {

  Integer cadastrar();

  void insert(Usuario obj);

  void update(Usuario obj);

  void deleteById(Integer id);

  Usuario findById(Integer id);

  List<Usuario> findAll();

  List<Usuario> findByPostagem(Postagem postagem);
}
