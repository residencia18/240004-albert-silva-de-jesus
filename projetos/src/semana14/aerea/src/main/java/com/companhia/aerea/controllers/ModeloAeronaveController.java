package com.companhia.aerea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.companhia.aerea.entities.ModeloAeronave;
import com.companhia.aerea.services.ModeloAeronaveService;

@RestController
@RequestMapping("/modelo-aeronave")
public class ModeloAeronaveController {
  
  @Autowired
  private ModeloAeronaveService modeloAeronaveService;

  @GetMapping("/listar-todos")
  public List<ModeloAeronave> buscarTodos(@RequestParam(required = false) String nome, @RequestParam(required = false) String fabricante) {
    return modeloAeronaveService.buscarTodos(nome, fabricante);
  }
}
