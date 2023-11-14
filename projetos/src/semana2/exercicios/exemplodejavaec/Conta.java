package semana2.exercicios.exemplodejavaec;

/*#include <iostream>
using namespace std;

class Conta
{
  int numero;     // São atributos
  string nome;    // privados por
  float saldo;    // default
public:
  void inicializa(string n, float s);
  void deposita(float valor);
  void consulta();
  int saque(float valor);
}; */

public class Conta {

  private int numero;
  private String nome;
  private double saldo;

  public Conta() {
  }

  public Conta(int numero, String nome, double saldo) {
    this.numero = numero;
    this.nome = nome;
    this.saldo = saldo;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  void inicializa(String nome, float saldo) {
    this.nome = nome;
    this.saldo = saldo;
    if (saldo < 0) {

      System.out.println("Erro na Criação da Conta!!!");
    }

  }

  void depositar(double valor) {
    this.saldo += valor;
  }

  double saque(double valor) {
    return this.saldo -= valor;
  }

  @Override
  public String toString() {
    return String.format("\n\tNome da conta: %s\n\tNúmero: %d\n\tSaldo: %.2f", this.nome, this.numero, this.saldo);
  }

}
