package com.energiacoelho.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.text.DecimalFormat;

@Entity
public class Reembolso extends AbstractEntity {

  private Double valor;
  private LocalDate data;

  @OneToOne
  @JoinColumn(name = "pagamento_id")
  private Pagamento pagamento;

  public Reembolso() {
  }

  public Reembolso(Double valor) {
    this.valor = valor;
    this.data = LocalDate.now();
  }

  public Reembolso(Integer id, Double valor) {
    super(id);
    this.valor = valor;
    this.data = LocalDate.now();
  }

  public Reembolso(Double valor, Pagamento pagamento) {
    this.valor = Math.abs(valor);
    this.data = LocalDate.now();
    this.pagamento = pagamento;
  }

  public Double getValor() {
    return valor;
  }

  public LocalDate getData() {
    return data;
  }

  public void setValor(Double valor) {
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
    return String.format("\n\tFoi gerado um reembolso no valor de: R$%s, na data: %s", df.format(valor), data);
  }

}
