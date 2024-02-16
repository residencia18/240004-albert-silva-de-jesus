package com.pratica12.pilotos.entities;

import java.io.Serializable;

public class Piloto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer numero = 0;
  private String pais;
  private String nome;
  private Integer numVitorias;

  public Piloto() {
  }

  public Piloto(String pais, String nome, Integer numVitorias) {
    this.pais = pais;
    this.nome = nome;
    this.numVitorias = numVitorias;
  }

  
  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getNumVitorias() {
    return numVitorias;
  }

  public void setNumVitorias(Integer numVitorias) {
    this.numVitorias = numVitorias;
  }

  // @Override
  // public String toString() {
  // StringBuilder sb = new StringBuilder();
  // sb.append("<div style=\" padding: 10px; border: 1px solid #ccc;
  // margin-bottom: 10px; background-color:#cecece;\">");
  // sb.append("<p><strong>País:</strong> ").append(pais).append("</p>");
  // sb.append("<p><strong>Nome:</strong> ").append(nome).append("</p>");
  // sb.append("<p><strong>Número de Vitórias:</strong>
  // ").append(numVitorias).append("</p>");
  // sb.append("</div>");
  // return sb.toString();
  // }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div style=\"padding: 2px; border: 1px solid #ccc; margin-bottom: 10px; background-color:#cecece;\">");
    sb.append("<p><strong>Número:</strong> ").append(this.numero + "º").append("</p>");
    sb.append("<p><strong>País:</strong> ").append(pais).append("</p>");
    sb.append("<p><strong>Nome:</strong> ").append(nome).append("</p>");
    sb.append("<p><strong>Número de Vitórias:</strong> ").append(numVitorias).append("</p>");
    sb.append("</div>");
    return sb.toString();
  }

}