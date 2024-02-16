package com.pratica12.pilotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica12.pilotos.services.PilotoService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/pilotos")
public class PilotoController {
  
  @Autowired
  private PilotoService pilotoService;

  @GetMapping("/todos")
  public String listarTodos() {
    return pilotoService.findAll();
  }

  @GetMapping("/vencedoresBrasileiros")
  public String listarVencedoresBrasileiros() {
    return pilotoService.vencedoresBrasileiros();
  }
  
  @GetMapping("/top5")
  public String listarTop5() {
    return pilotoService.top5Vencedores();
  }

  @GetMapping("/top10")
  public String listarTop10() {
    return pilotoService.top10Vencedores();
  }

  @GetMapping("/vitoriasPorPais")
  public String listarVitoriasPorPais() {
    return pilotoService.numeroDeVitoriasPorPais();
  }

  @GetMapping("/mediaVitoriasPorPais")
  public String listarMediaVitoriasPorPais() {
    return pilotoService.mediaDeVitoriasPorPais();
  }
  
}