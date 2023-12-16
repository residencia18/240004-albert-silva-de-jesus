package semana5.P006.exercicio4.entities;

public class Veiculo {

  private String modelo;
  private String cor;
  private int ano;

  public Veiculo() {
    this.modelo = "";
    this.cor = "";
    this.ano = 0;
  }

  public Veiculo(String modelo, String cor, int ano) {
    this.modelo = modelo;
    this.cor = cor;
    this.ano = ano;
  }

  public void acelerar() {
    System.out.println("\tVeículo acelerando");
  }

  public void ligar() {
    System.out.println("\tVeículo ligado");
  }

  public void parar() {
    System.out.println("\tVeículo parado");
  }

  public String getModelo() {
    return modelo;
  }

  public String getCor() {
    return cor;
  }

  public int getAno() {
    return ano;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  @Override
  public String toString() {
    return "\tVeiculo:\n\tModelo: " + modelo + "\n\tCor: " + cor + "\n\tAno: " + ano;
  }
}