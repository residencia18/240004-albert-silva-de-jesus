package com.energiacoelho.dao;

import com.energiacoelho.model.Cliente;

public interface ClienteDao {

  void adicionar(Cliente cliente);

  void cadastrar();

  void listar();

  void editar();

  void excluir();

  void pesquisar();

  Cliente findById(Integer id);
  
  Integer findClientIdByCpf(String cpf);
  
  public void encerrarComunicacao();
  
}