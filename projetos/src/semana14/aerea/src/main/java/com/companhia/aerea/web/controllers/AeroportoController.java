package com.companhia.aerea.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.services.AeroportoService;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {
  
    @Autowired
    private AeroportoService aeroportoService;

    @GetMapping("/listar-todos")
    public List<Aeroporto> listarAeroportos(@RequestParam(required = false) String nome, @RequestParam(required = false) String icao) {
        return aeroportoService.buscarTodos(nome, icao);
    }
}
