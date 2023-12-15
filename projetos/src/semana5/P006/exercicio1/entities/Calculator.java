/*1. Crie uma classe chamada Calculadora que contenha métodos para realizar operações matemáticas básicas, como soma, subtração, multiplicação e
divisão. Sobrecarregue os métodos para aceitar diferentes tipos de dados, como inteiros e float. Crie uma versão para receber listas de 
números (ArrayLists) e fazer operações em sequência. Certifique-se de fornecer exemplos de uso no método main */

package semana5.P006.exercicio1.entities;

import java.util.ArrayList;

public class Calculator {

  // Métodos para operações com inteiros e floats
  public static int somar(int a, int b) {
    return a + b;
  }

  public static float somar(float a, float b) {
    return a + b;
  }

  public static int subtrair(int a, int b) {
    return a - b;
  }

  public static float subtrair(float a, float b) {
    return a - b;
  }

  public static int multiplicar(int a, int b) {
    return a * b;
  }

  public static float multiplicar(float a, float b) {
    return a * b;
  }

  public static int dividir(int a, int b) {
    if (b != 0) {
      return a / b;
    } else {
      throw new ArithmeticException("Divisão por zero não permitida");
    }
  }

  public static float dividir(float a, float b) {
    if (b != 0) {
      return a / b;
    } else {
      throw new ArithmeticException("Divisão por zero não permitida");
    }
  }

  // Métodos para operações com listas de inteiros e floats
  public static int somar(ArrayList<Integer> numeros) {

    int resultado = 0;
    for (int numero : numeros) {
      resultado = somar(resultado, numero);

    }
    return resultado;
  }

  public static float somarFloat(ArrayList<Float> numeros) {

    float resultado = 0;
    for (float numero : numeros) {
      resultado = somar(resultado, numero);

    }
    return resultado;
  }

  public static int subtrair(ArrayList<Integer> numeros) {

    int resultado = numeros.get(0);
    for (int i = 1; i < numeros.size(); i++) {
      resultado = subtrair(resultado, numeros.get(i));

    }
    return resultado;
  }

  public static float subtrairFloat(ArrayList<Float> numeros) {

    float resultado = numeros.get(0);
    for (int i = 1; i < numeros.size(); i++) {

      resultado = subtrair(resultado, numeros.get(i));
    }
    return resultado;
  }

  public static int multiplicar(ArrayList<Integer> numeros) {

    if (numeros.isEmpty()) {
      throw new IllegalArgumentException("Lista de números vazia");
    }

    int resultado = 1;

    for (int i = 0; i < numeros.size(); i++) {
      int fator = numeros.get(i);
      resultado = multiplicar(resultado, fator);
    }

    return resultado;
  }

  public static float multiplicarFloat(ArrayList<Float> numeros) {

    float resultado = 1;
    for (float numero : numeros) {
      resultado = multiplicar(resultado, numero);

    }
    return resultado;
  }

  public static int dividir(ArrayList<Integer> numeros) {

    if (numeros.isEmpty()) {
      throw new IllegalArgumentException("Lista de números vazia");
    }

    int resultado = numeros.get(0);

    for (int i = 1; i < numeros.size(); i++) {
      int denominador = numeros.get(i);

      try {
        resultado = dividir(resultado, denominador);

      } catch (ArithmeticException e) {
        System.out.println("\n\tErro ao dividir na posição " + i + " da lista: " + e.getMessage());
      }
    }

    return resultado;
  }

  public static float dividirFloat(ArrayList<Float> numeros) {

    if (numeros.isEmpty()) {
      throw new IllegalArgumentException("Lista de números vazia");
    }

    float resultado = numeros.get(0);
    for (int i = 1; i < numeros.size(); i++) {

      try {
        resultado = dividir(resultado, numeros.get(i));

      } catch (ArithmeticException e) {
        System.out.println("\n\tErro ao dividir na posição " + i + " da lista: " + e.getMessage());
      }

    }
    return resultado;
  }

}