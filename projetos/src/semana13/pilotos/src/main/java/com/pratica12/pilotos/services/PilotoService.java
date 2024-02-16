package com.pratica12.pilotos.services;

import java.util.List;

import com.pratica12.pilotos.entities.Piloto;

public interface PilotoService {
  
  public List<Piloto> carregarPilotos();

  public String findAll();

  public String vencedoresBrasileiros();

  public String top5Vencedores();

  public String top10Vencedores();

  public String numeroDeVitoriasPorPais();

  public String  mediaDeVitoriasPorPais();
}
