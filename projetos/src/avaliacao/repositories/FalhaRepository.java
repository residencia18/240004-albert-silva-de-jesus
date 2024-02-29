package avaliacao.repositories;

import avaliacao.entities.FalhaDistribuicao;

public interface FalhaRepository {

  void cadastrarFalhaDistribuicao();

  void cadastrarFalhaGeracao();

  void listar();

  void editar();

  FalhaDistribuicao buscarFalhaDistribuicao();
}