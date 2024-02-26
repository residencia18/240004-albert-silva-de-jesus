package atvemsala.redesocial;

import java.util.ArrayList;
import java.util.List;

public class ListaSessoes {

  private List<Sessao> sessoes;

  public ListaSessoes() {
    this.sessoes = new ArrayList<>();
  }

  public List<Sessao> getSessoes() 
  {
    return sessoes;
  }

  public void adicionarSessao(Sessao sessao) 
  {
    sessoes.add(sessao);
  }
}
