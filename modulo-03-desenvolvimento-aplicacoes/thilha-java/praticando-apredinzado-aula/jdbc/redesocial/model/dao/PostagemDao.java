package semana10.jdbc.redesocial.model.dao;

import java.util.List;

import semana10.jdbc.redesocial.model.entities.Postagem;

public interface PostagemDao {

  void insert(Postagem obj);

  void update(Postagem obj);

  void deleteById(Integer id);

  Postagem findById(Integer id);

  List<Postagem> findAll();

}