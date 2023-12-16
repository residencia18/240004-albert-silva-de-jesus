package semana5.P006.exercicio4.entities;

public class Carro extends Veiculo {

  public Carro() {
    super();
  }

  public Carro(String modelo, String cor, int ano, boolean isEletrico) {
    super(modelo, cor, ano, isEletrico);
  }

  @Override
  public void acelerar() {
    System.out.println("\tCarro acelerando");
  }

  @Override
  public void ligar() {
    System.out.println("\tCarro ligado");
  }

  @Override
  public void parar() {
    System.out.println("\tCarro parado");
  }

}