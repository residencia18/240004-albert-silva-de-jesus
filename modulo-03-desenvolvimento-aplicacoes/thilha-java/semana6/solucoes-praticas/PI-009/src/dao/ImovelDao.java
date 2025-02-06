package dao;

import entities.Imovel;

public interface ImovelDao {

  void adicionar(Imovel imovel);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();

  Imovel buscaImovel();

}
