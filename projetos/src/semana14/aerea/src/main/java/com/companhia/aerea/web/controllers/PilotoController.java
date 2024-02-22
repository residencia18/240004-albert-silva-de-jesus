package com.companhia.aerea.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.companhia.aerea.services.PilotoService;
import com.companhia.aerea.web.dto.PilotoDto;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @GetMapping("/listar-todos")
    public List<PilotoDto> listarPilotos(@RequestParam(required = false) String nome) {
        return pilotoService.buscarTodos(nome);
    }
  
}
