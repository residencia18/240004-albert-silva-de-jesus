package com.companhia.aerea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companhia.aerea.dto.PilotoDto;
import com.companhia.aerea.services.PilotoService;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @GetMapping("/listar/")
    public List<PilotoDto> listarPilotos(String nome) {
        return pilotoService.buscarTodos(nome);
    }
  
}
