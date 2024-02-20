package com.companhia.aerea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.services.AeroportoService;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {
  
    @Autowired
    private AeroportoService aeroportoService;

    @GetMapping("/listar/")
    public List<Aeroporto> listarAeroportos(String icao, String nome) {
        return aeroportoService.buscarTodos();
    }
}
