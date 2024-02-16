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
  
}