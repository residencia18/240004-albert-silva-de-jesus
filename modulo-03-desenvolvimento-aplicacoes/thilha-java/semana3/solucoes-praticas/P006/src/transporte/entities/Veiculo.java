package transporte.entities;

public class Veiculo {

  private String placa;
  private String modelo;

  public Veiculo() {
  }

  public Veiculo(String placa, String modelo) {
    this.placa = placa;
    this.modelo = modelo;
  }

  public String getPlaca() {
    return placa;
  }

  public String getModelo() {
    return modelo;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  @Override
  public String toString() {
    return ("\n\tPlaca: " + this.placa + "\n\tModelo: " + this.modelo);
  }
}
