package semana6.atvEmSala.P005.entities;

public class Trecho {

  private String origem;
  private String destino;
  private String pontos;
  private int intervaloEstimado;

  public Trecho() {
  }

  public Trecho(String origem, String destino, String pontos, int intervaloEstimado) {
    this.origem = origem;
    this.destino = destino;
    this.pontos = pontos;
    this.intervaloEstimado = intervaloEstimado;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public String getPontos() {
    return pontos;
  }

  public void setPontos(String pontos) {
    this.pontos = pontos;
  }

  public int getIntervaloEstimado() {
    return intervaloEstimado;
  }

  public void setIntervaloEstimado(int intervaloEstimado) {
    this.intervaloEstimado = intervaloEstimado;
  }

  @Override
  public String toString() {
    return (
      "Trecho: " + 
      "\n\tOrigem: " + origem + 
      "\n\tDestino: " + destino + 
      "\n\tPontos: " + pontos + 
      "\n\tIntervalo Estimado: " + intervaloEstimado);
  }

}
