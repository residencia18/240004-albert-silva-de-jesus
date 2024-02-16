package com.pratica12.pilotos.entities;

import java.io.Serializable;

public class Piloto implements Serializable {

  private static final long serialVersionUID = 1L;

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

  @Override
  public String toString() {
    return "Piloto [pais=" + pais + ", nome=" + nome + ", numVitorias=" + numVitorias + "]";
  }

}