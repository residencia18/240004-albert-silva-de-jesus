package semana10.p009.dao;

import semana10.p009.entities.Imovel;

public interface ImovelDao {

  void adicionar(Imovel imovel);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();

  Imovel buscaImovel();

}
