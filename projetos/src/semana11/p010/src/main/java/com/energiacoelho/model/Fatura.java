package com.energiacoelho.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.energiacoelho.exceptions.FaturaQuitadaException;
import com.energiacoelho.views.Views;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Entity
public class Fatura extends AbstractEntity {

  private String matriculaImovel;
  private int ultimaLeitura;
  private int penultimaLeitura;
  private Double valorTotal;
  private LocalDate dataEmissao;
  private boolean quitado;
  private Reembolso reembolso;

  @OneToMany(mappedBy = "fatura")
  private List<Pagamento> pagamentos;

  @ManyToOne
  @JoinColumn(name = "imovel_id")
  private Imovel imovel;

  public Fatura() {
  }

  public Fatura(String matriculaImovel, int ultimaLeitura, int penultimaLeitura, Imovel imovel) {
    this.matriculaImovel = matriculaImovel;
    this.ultimaLeitura = ultimaLeitura;
    this.penultimaLeitura = penultimaLeitura;
    this.imovel = imovel;
    this.dataEmissao = LocalDate.now();
    this.quitado = false;
    this.pagamentos = new ArrayList<>();
    calcularValorFatura();
  }

  public Fatura(Integer id, String matriculaImovel, int ultimaLeitura, int penultimaLeitura, Double valorTotal,
      LocalDate dataEmissao, boolean quitado, Imovel imovel) {
    super(id);
    this.matriculaImovel = matriculaImovel;
    this.ultimaLeitura = ultimaLeitura;
    this.penultimaLeitura = penultimaLeitura;
    this.imovel = imovel;
    this.valorTotal = valorTotal;
    this.dataEmissao = dataEmissao;
    this.quitado = quitado;
  }

  public String getMatriculaImovel() {
    return matriculaImovel;
  }

  public void setMatriculaImovel(String matriculaImovel) {
    this.matriculaImovel = matriculaImovel;
  }

  public int getUltimaLeitura() {
    return ultimaLeitura;
  }

  public void setUltimaLeitura(int ultimaLeitura) {
    this.ultimaLeitura = ultimaLeitura;
  }

  public int getPenultimaLeitura() {
    return penultimaLeitura;
  }

  public void setPenultimaLeitura(int penultimaLeitura) {
    this.penultimaLeitura = penultimaLeitura;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public LocalDate getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(LocalDate dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public boolean isQuitado() {
    return quitado;
  }

  public void setQuitado(boolean quitado) {
    this.quitado = quitado;
  }

  public List<Pagamento> getPagamentos() {
    return pagamentos;
  }

  public Reembolso getReembolso() {
    return reembolso;
  }

  public void setReembolso(Reembolso reembolso) {
    this.reembolso = reembolso;
  }

  public void addPagamento(Pagamento pagamento) {
    this.pagamentos.add(pagamento);
  }

  public void novoPagamento() {

    if (quitado) {
      Views.cxMsg("A fatura já está quitadaa!");
      return;
    }

    float totalPago = 0;
    Pagamento novo = Pagamento.obterDadosPagamento();
    if (novo == null) {
      Views.cxMsg("Pagamento não realizado");
      return;
    }
    this.pagamentos.add(novo);

    for (Pagamento p : pagamentos)
      totalPago += p.valor;

    if (totalPago < this.valorTotal) {
      DecimalFormat df = new DecimalFormat("#.##");
      String msg = String.format("A fatura foi parcialmente paga, restando R$%s a pagar!",
          df.format(this.valorTotal - totalPago));
      Views.cxMsg(msg);
      return;
    }

    this.quitado = true;
    Views.cxMsg("A fatura foi paga!");
    if (totalPago > this.valorTotal) {
      this.reembolso = new Reembolso(totalPago - this.valorTotal);
      Views.cxMsg(this.reembolso.toString());
    }
  }

  public void calcularValorFatura() {
    Double custoPorKWh = 10.0;
    this.valorTotal = (ultimaLeitura - penultimaLeitura) * custoPorKWh;
  }

  public void registraLeitura(int novaLeitura) {

    try {

      if (novaLeitura <= this.ultimaLeitura) {
        throw new IllegalArgumentException("A nova leitura deve ser maior que a última leitura.");
      }

      // Atualiza a penúltima leitura com o valor atual da última leitura
      this.penultimaLeitura = this.ultimaLeitura;

      // Atualiza a última leitura com a nova leitura
      this.ultimaLeitura = novaLeitura;

      // Recalcula o valor total da fatura
      calcularValorFatura();

    } catch (IllegalArgumentException e) {
      System.err.println("Erro ao registrar leitura: " + e.getMessage());
    }
  }

  public void registraPagamento(Pagamento pagamento) {

    if (quitado) {
      throw new FaturaQuitadaException("A fatura já está quitada e não aceita mais pagamentos.");
    }

    double valorRestante = getValorPendente();

    if (pagamento.getValor() > valorRestante) {
      // O pagamento excede o valor pendente, gera reembolso
      double valorExcedente = pagamento.getValor() - valorRestante;
      this.reembolso = new Reembolso(valorExcedente);
      quitado = true;

    } else {

      if (pagamento.getValor() == valorRestante) {
        // Quita totalmente a fatura
        quitado = true;
      }
    }

    // Adiciona o pagamento à lista
    this.pagamentos.add(pagamento);
  }

  public double getValorPendente() {
    double totalPago = this.pagamentos.stream().mapToDouble(Pagamento::getValor).sum();
    return Math.max(0, this.valorTotal - totalPago);
  }

  @Override
  public String toString() {

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    currencyFormat.setMaximumFractionDigits(2);
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    return String.format("\n\tNº de Matrícula: %s\n" +
        "\tConsumo: %d\n" +
        "\tValor Total: %s\n" +
        "\tData de Emissão: %s\n" +
        "\tQuitado: %s",
        matriculaImovel, ultimaLeitura - penultimaLeitura, currencyFormat.format(valorTotal),
        dataEmissao.format(dateFormatter), quitado);
  }

}
