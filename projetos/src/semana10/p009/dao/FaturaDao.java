package p009.dao;

import p009.entities.Imovel;

public interface FaturaDao {

  void registrarConsumo();

  void faturasEmAberto();

  static void novaFatura(Imovel imovel) {}

  void todasAsFaturas();
}
