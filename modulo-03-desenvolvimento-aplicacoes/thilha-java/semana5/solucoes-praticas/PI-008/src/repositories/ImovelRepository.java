package repositories;

import entities.Imovel;
public interface ImovelRepository {

  public void adcionar(Imovel imovel);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();

  Imovel buscaImovel();
}
