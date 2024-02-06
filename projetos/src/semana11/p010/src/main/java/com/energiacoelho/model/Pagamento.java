package com.energiacoelho.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.energiacoelho.views.Views;

import java.text.DecimalFormat;

@Entity
public class Pagamento extends AbstractEntity {

  protected double valor;
  protected LocalDate data;

  @ManyToOne
  @JoinColumn(name = "fatura_id")
  private Fatura fatura;

  public Pagamento() {
  }

  public Pagamento(double valor) {
    this.valor = valor;
    this.data = LocalDate.now();
  }

  public Pagamento(Integer id, double valor) {
    super(id);
    this.valor = valor;
    this.data = LocalDate.now();
  }

  public double getValor() {
    return valor;
  }

  public LocalDate getData() {
    return data;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public static Pagamento obterDadosPagamento() {

    Pagamento pagamento;
    try {

      System.out.print("Informe o valor do pagamento: ");
      double valorPagamento = Views.scan.nextDouble();

      pagamento = new Pagamento(valorPagamento);
      return pagamento;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.##");
    return String.format("Pagamento no valor de R$%s realizado na data %s!", df.format(valor), data);
  }
}
