package semana5.P006.exercicio4.entities;

public class Veiculo {

  private String modelo;
  private String cor;
  private int ano;
  private boolean isEletrico;

  public Veiculo() {
    this.modelo = "";
    this.cor = "";
    this.ano = 0;
    this.isEletrico = false;
  }

  public Veiculo(String modelo, String cor, int ano, boolean isEletrico) {
    this.modelo = modelo;
    this.cor = cor;
    this.ano = ano;
    this.isEletrico = isEletrico;
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

  public boolean getIsEletrico() {
    return isEletrico;
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

  public void setIsEletrico(boolean isEletrico) {
    this.isEletrico = isEletrico;
  }

  @Override
  public String toString() {
    return "\tVeiculo:\n\tModelo: " + modelo + "\n\tCor: " + cor + "\n\tAno: " + ano + "\n\tÉ elétrico: " + isEletrico;
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

  public void estacionar(Garagem garagem) {
    garagem.adicionar(this);

    if (garagem.possuiTomada() && this.isEletrico) {
      System.out.println("\tVeículo carregando");
    } else {
      System.out.println("\tVeículo estacionado");
    }
  }
}