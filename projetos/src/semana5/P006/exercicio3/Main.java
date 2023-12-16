/*3. Crie uma hierarquia de classes para representar diferentes tipos de veículos, como Veiculo, Carro, e Moto. A classe base Veiculo 
deve conter atributos comuns a todos os veículos, como modelo, cor e ano. Crie métodos genéricos acelerar() que escreve a mensagem "Veículo
acelerando" e ligar() que escreve "Veículo ligado" e parar() ("Veículo parado"). Adicione métodos nas classes derivadas (Carro e Moto) 
que aproveitem o polimorfismo para realizar ações específicas, como ligar ("moto/carro ligado(a)" acelerar, e parar. Certifique-se de 
sobrescrever os métodos na classe Veiculo quando necessário. No método main, crie instâncias das classes derivadas e chame os métodos
para demonstrar o polimorfismo em ação.*/

package semana5.P006.exercicio3;

import semana5.P006.exercicio3.entities.Carro;
import semana5.P006.exercicio3.entities.Moto;

public class Main {

  public static void main(String[] args) {

    limparTela();
    Carro carro = new Carro("Fusca", "Azul", 1970);
    Moto moto = new Moto("CG 125", "Vermelha", 2000);

    System.out.println("\n\t===== Carro =====");
    System.out.print(carro.toString());
    System.out.println("\n\t===== Ações =====");
    carro.ligar();
    carro.acelerar();
    carro.parar();
    System.out.println("\t=================\n");

    System.out.println("\n\t===== Moto =====");
    System.out.print(moto.toString());
    System.out.println("\n\t===== Ações =====");
    moto.ligar();
    moto.acelerar();
    moto.parar();
    System.out.println("\t=================\n");
  }

  public static void limparTela() {

    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (final Exception e) {
      // Trata exceções (pode ser uma exceção de interrupção)
      e.printStackTrace();
    }
  }

}