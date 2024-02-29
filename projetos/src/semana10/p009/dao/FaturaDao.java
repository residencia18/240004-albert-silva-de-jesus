package semana10.p009.dao;

import semana10.p009.entities.Fatura;
import semana10.p009.entities.Imovel;

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
