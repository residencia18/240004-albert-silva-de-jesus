package CalculadoraDivisao;

class DivisionByZeroException extends Exception {

  public DivisionByZeroException(String message) {
    super(message);
  }
}