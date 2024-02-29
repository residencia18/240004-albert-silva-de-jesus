package semana10.p009.entities;

import java.time.LocalDate;

public class FalhaGeracao extends Falha {

  public FalhaGeracao() {
  }

  public FalhaGeracao(String matriculaImovel, String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    super(matriculaImovel, descricao, previsaoConclusao, dataInicio, dataFim);
  }

  public FalhaGeracao(Integer id, String matriculaImovel, String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    super(id, matriculaImovel, descricao, previsaoConclusao, dataInicio, dataFim);
  }
}