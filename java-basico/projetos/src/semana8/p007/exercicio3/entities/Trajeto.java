package semana8.p007.exercicio3.entities;

public class Trajeto {
  
  private Trecho trecho;

  public Trajeto() {
  }

  public Trajeto(Trecho trecho) {
    this.trecho = trecho;
  }

  public Trecho getTrecho() {
    return trecho;
  }

  public void setTrecho(Trecho trecho) {
    this.trecho = trecho;
  }

  @Override
  public String toString() {
    return ("\n\t" + trecho.toString());
  }
  
}