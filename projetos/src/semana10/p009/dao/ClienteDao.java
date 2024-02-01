package p009.dao;

import p009.entities.Cliente;

public interface ClienteDao {

  void adcionar(Cliente cliente);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();
  
}