package com.energiacoelho.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.text.DecimalFormat;

@Entity
public class Reembolso extends AbstractEntity {

  private double valor;
  private LocalDate data;

  @OneToOne
  @JoinColumn(name = "pagamento_id")
  private Pagamento pagamento;

  public Reembolso() {
  }

  public Reembolso(double valor) {
    this.valor = valor;
    this.data = LocalDate.now();
  }

  public Reembolso(Integer id, double valor) {
    super(id);
    this.valor = valor;
    this.data = LocalDate.now();
  }

  public Reembolso(double valor, Pagamento pagamento) {
    this.valor = valor;
    this.data = LocalDate.now();
    this.pagamento = pagamento;
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

  public Pagamento getPagamento() {
    return pagamento;
  }

  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.##");
    return String.format("Foi gerado um reembolso no valor de: R$%s, na data: %s]", df.format(valor), data);
  }
}
