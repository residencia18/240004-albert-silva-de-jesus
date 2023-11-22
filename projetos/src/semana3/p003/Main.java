package semana3.p003;

public class Main {

  public static void main(String[] args) {

    limparTela();

    try {

      System.out.println("Soma: " + CalculadoraDeDivisao.somar(5, 3));
      System.out.println("Subtração: " + CalculadoraDeDivisao.subtrair(8, 4));
      System.out.println("Multiplicação: " + CalculadoraDeDivisao.multiplicar(2, 6));
      System.out.println("Divisão inteira: " + CalculadoraDeDivisao.dividir(8, 2));
      System.out.println("Divisão float: " + CalculadoraDeDivisao.dividir(5.0f, 2.0f));

      // Tentativa de divisão por zero
      System.out.println("Tentativa de divisão por zero: ");
      System.out.println("Divisão inteira: " + CalculadoraDeDivisao.dividir(10, 0));
      System.out.println("Divisão float: " + CalculadoraDeDivisao.dividir(8.0f, 0.0f));

    } catch (DivisionByZeroException e) {
      System.out.println("Erro: " + e.getMessage());
    }
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
