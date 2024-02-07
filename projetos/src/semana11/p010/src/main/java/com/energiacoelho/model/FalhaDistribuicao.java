package com.energiacoelho.model;

import java.time.LocalDate;

public class FalhaDistribuicao extends Falha {

  public FalhaDistribuicao() {
  }

  public FalhaDistribuicao(String matriculaImovel, String descricao, LocalDate previsaoConclusao, LocalDate dataInicio,
      LocalDate dataFim) {
    super(matriculaImovel, descricao, previsaoConclusao, dataInicio, dataFim);
  }

  public FalhaDistribuicao(Integer id, String matriculaImovel, String descricao, LocalDate previsaoConclusao,
      LocalDate dataInicio, LocalDate dataFim) {
    super(id, matriculaImovel, descricao, previsaoConclusao, dataInicio, dataFim);
  }
}
