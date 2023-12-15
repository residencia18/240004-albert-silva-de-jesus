package semana5.P006.exercicio3.entities;

public class Carro extends Veiculo {

  public Carro() {
    super();
  }

  public Carro(String modelo, String cor, int ano) {
    super(modelo, cor, ano);
  }

  @Override
  public void acelerar() {
    System.out.println("Carro acelerando");
  }

  @Override
  public void ligar() {
    System.out.println("Carro ligado");
  }

  @Override
  public void parar() {
    System.out.println("Carro parado");
  }

}