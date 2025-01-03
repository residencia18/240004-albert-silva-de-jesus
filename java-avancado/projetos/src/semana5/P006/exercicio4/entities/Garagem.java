package semana5.P006.exercicio4.entities;

import java.util.ArrayList;

public class Garagem {

  private ArrayList<Veiculo> veiculos;
  private boolean tomadaCarga;

  public Garagem(boolean tomadaCarga) {
    this.veiculos = new ArrayList<>();
    this.tomadaCarga = tomadaCarga;
  }

  public void adicionar(Veiculo veiculo) {
    this.veiculos.add(veiculo);
  }

  public void remover(Veiculo veiculo) {
    this.veiculos.remove(veiculo);
  }

  public boolean possuiTomada() {
    return tomadaCarga;
  }

  public void setTomadaCarga(boolean tomadaCarga) {
    this.tomadaCarga = tomadaCarga;
  }

  public ArrayList<Veiculo> getVeiculos() {
    return veiculos;
  }

  public void setVeiculos(ArrayList<Veiculo> veiculos) {
    this.veiculos = veiculos;
  }

  @Override
  public String toString() {
    return "\tGaragem:\n\tPossui tomada de carga: " + tomadaCarga;
  }

}