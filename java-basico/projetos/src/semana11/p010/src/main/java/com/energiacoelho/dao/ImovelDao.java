package com.energiacoelho.dao;

import com.energiacoelho.model.Imovel;

public interface ImovelDao {

  void adicionar(Imovel imovel);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();

  Imovel buscaImovel();

  public Imovel findById(Integer id);

}