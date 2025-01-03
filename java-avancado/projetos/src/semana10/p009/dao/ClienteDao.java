package semana10.p009.dao;

import semana10.p009.entities.Cliente;

public interface ClienteDao {

  void adicionar(Cliente cliente);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();

  Cliente findById(Integer id);
  
  Integer findClientIdByCpf(String cpf);
  
}