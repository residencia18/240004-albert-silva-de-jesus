package model.dao;

import java.util.List;

import model.entities.Postagem;

public interface PostagemDao {

  void insert(Postagem obj);

  void update(Postagem obj);

  void deleteById(Integer id);

  Postagem findById(Integer id);

  List<Postagem> findAll();

}