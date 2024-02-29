package avaliacao.repositories;

import avaliacao.entities.Cliente;

public interface ClienteRepository {

  void adcionar(Cliente cliente);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();
}