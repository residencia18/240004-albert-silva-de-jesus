package com.companhia.aerea.services;

import java.util.List;

import com.companhia.aerea.entities.ModeloAeronave;

public interface ModeloAeronaveService {
  
    public List<ModeloAeronave> buscarTodos(String nome, String fabricante);
}