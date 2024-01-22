package semana8.p007.exercicio3.entities;

public class PontosDeParada {

  private String embarque;
  private String desembarque;
  private int distanciaEntreParadas;

  public PontosDeParada() {
  }

  public PontosDeParada(String embarque, String desembarque) {
    this.embarque = embarque;
    this.desembarque = desembarque;
  }

  public PontosDeParada(String embarque, String desembarque, int distanciaEntreParadas) {
    this.embarque = embarque;
    this.desembarque = desembarque;
    this.distanciaEntreParadas = distanciaEntreParadas;
  }

  public String getEmbarque() {
    return embarque;
  }

  public void setEmbarque(String embarque) {
    this.embarque = embarque;
  }

  public String getDesembarque() {
    return desembarque;
  }

  public void setDesembarque(String desembarque) {
    this.desembarque = desembarque;
  }

  public int getDistanciaEntreParadas() {
    return distanciaEntreParadas;
  }

  public void setDistanciaEntreParadas(int distanciaEntreParadas) {
    this.distanciaEntreParadas = distanciaEntreParadas;
  }

  @Override
  public String toString() {
    return ("\n\tPonto de embarque: " + embarque + "\n\tPonto de desembarque: " + desembarque + "\n\tDistância entre os pontos: " + distanciaEntreParadas + "km");
  }

}
