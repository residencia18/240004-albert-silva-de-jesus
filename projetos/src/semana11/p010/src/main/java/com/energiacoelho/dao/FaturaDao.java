package com.energiacoelho.dao;

import com.energiacoelho.model.Fatura;
import com.energiacoelho.model.Imovel;

public interface FaturaDao {

  void registrarConsumo();

  void faturasEmAberto();

  void novaFatura(Imovel imovel);

  void todasAsFaturas();

  Fatura obterFaturaPorMesEmissao();

  void pagamentosPorFatura();

  void todosOsReembolsos();

  void reembolsosPorFatura();
}
