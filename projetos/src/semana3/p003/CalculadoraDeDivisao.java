/*
 * Calculadora de Divisão 
 
 Crie uma classe Calculadora com métodos para as 4 operações. Note que haverá um método que realiza uma divisão de dois números inteiros e outro que 
realizará a divisão de dois números float. No entanto, se o divisor for igual a zero, sua calculadora deverá lançar uma exceção 
personalizada chamada DivisionByZeroException. O seu programa deve lidar com essa exceção e informar ao usuário que a divisão por zero 
não é permitida.
 */

package p003;

class CalculadoraDeDivisao {

  public static int somar(int a, int b) {
    return a + b;
  }

  public static int subtrair(int a, int b) {
    return a - b;
  }

  public static int multiplicar(int a, int b) {
    return a * b;
  }

  public static int dividir(int dividendo, int divisor) throws DivisionByZeroException {
    if (divisor == 0) {
      throw new DivisionByZeroException("Divisão por zero não permitida");
    }
    return dividendo / divisor;
  }

  public static float dividir(float dividendo, float divisor) throws DivisionByZeroException {
    if (divisor == 0) {
      throw new DivisionByZeroException("Divisão por zero não permitida");
    }
    return dividendo / divisor;
  }
}