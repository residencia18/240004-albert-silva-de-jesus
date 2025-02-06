package dao;

import entities.Fatura;
import entities.Imovel;

public interface FaturaDao {

  void registrarConsumo();

  void faturasEmAberto();

  static void novaFatura(Imovel imovel) {
  }

  void todasAsFaturas();

  Fatura obterFaturaPorMesEmissao();

  void pagamentosPorFatura();

  void todosOsReembolsos();

  void reembolsosPorFatura();
}
