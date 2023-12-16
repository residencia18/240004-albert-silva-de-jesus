/*4. Amplie o exemplo anterior introduzindo uma classe adicional chamada Garagem. A classe Garagem deve ter uma lista de veículos e métodos 
para adicionar (estacionar) e remover veículos. A garagem também deve ter um atributo indicando se possui ou não tomada de carga elétrica 
para veículos. Modifique sua classe Veículo para ele ter um flag indicando se é um veículo elétrico ou não. Crie o método estacionar() na 
classe veículo. Este método recebe uma garagem como parâmetro. O veículo deve ser incluído na lista de veículos daquela garagem.
"Veículo estacionado!" ou "Carro/Moto estacionado(a)" Todavia, se a garagem possuir tomada de carga elétrica, e o veículo for do tipo 
elétrico, deve-se acrescentar a mensagem "Veículo carregando" ou "Carro/Moto carregando". No método main, crie instâncias das classes 
derivadas e chame os métodos para demonstrar o polimorfismo em ação.*/

package semana5.P006.exercicio4;

import semana5.P006.exercicio4.entities.Moto;
import semana5.P006.exercicio4.entities.Veiculo;
import semana5.P006.exercicio4.entities.Carro;
import semana5.P006.exercicio4.entities.Garagem;

public class Main {

  public static void main(String[] args) {

    limparTela();
    Carro carro = new Carro("Fusca", "Azul", 1970, false);
    Moto moto = new Moto("CG 125", "Vermelha", 2000, false);
    Garagem garagem = new Garagem(true);

    System.out.println("\n\t===== Carro =====");
    System.out.println(carro);
    carro.estacionar(garagem);
    garagem.setTomadaCarga(false);
    System.out.println(garagem);
    System.out.println("\t=================\n");

    System.out.println("\n\t===== Moto =====");
    moto.setIsEletrico(true);
    garagem.setTomadaCarga(true);
    System.out.println(moto);
    moto.estacionar(garagem);
    System.out.println(garagem);
    System.out.println("\t=================\n");

    garagem.remover(moto);
    System.out.println("\n\t===== Veículos na garagem =====");
    for (Veiculo veiculo : garagem.getVeiculos()) {
      System.out.println(veiculo);
    }
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
