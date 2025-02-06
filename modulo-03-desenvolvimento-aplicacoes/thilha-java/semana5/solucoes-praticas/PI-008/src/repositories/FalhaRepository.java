package repositories;

import entities.FalhaDistribuicao;

public interface FalhaRepository {

  void cadastrarFalhaDistribuicao();

  void cadastrarFalhaGeracao();

  void listar();

  void editar();

  FalhaDistribuicao buscarFalhaDistribuicao();
}