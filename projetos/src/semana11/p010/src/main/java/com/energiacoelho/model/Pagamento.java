package com.energiacoelho.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.energiacoelho.views.Views;

import java.text.DecimalFormat;

@Entity
public class Pagamento extends AbstractEntity {

  protected Double valor;
  protected LocalDate data;

  @ManyToOne
  @JoinColumn(name = "fatura_id")
  private Fatura fatura;

  @OneToOne(mappedBy = "pagamento")
  private Reembolso reembolso;

  public Pagamento() {
  }

  public Pagamento(Double valor) {
    this.valor = valor;
    this.data = LocalDate.now();
  }

  public Pagamento(Double valor, Fatura fatura) {
    this.valor = valor;
    this.data = LocalDate.now();
    this.fatura = fatura;
  }

  public Pagamento(Integer id, Double valor, Fatura fatura) {
    super(id);
    this.valor = valor;
    this.fatura = fatura;
    this.data = LocalDate.now();
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

  public Fatura getFatura() {
    return fatura;
  }

  public void setFatura(Fatura fatura) {
    this.fatura = fatura;
  }

  public Reembolso getReembolso() {
    return reembolso;
  }

  public void setReembolso(Reembolso reembolso) {
    this.reembolso = reembolso;
  }

  public static Pagamento obterDadosPagamento(Fatura fatura) {

    Pagamento pagamento;
    try {

      System.out.print("\n\tInforme o valor do pagamento: ");
      Double valorPagamento = Views.scan.nextDouble();
      Views.scan.nextLine();

      pagamento = new Pagamento(valorPagamento, fatura);
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
