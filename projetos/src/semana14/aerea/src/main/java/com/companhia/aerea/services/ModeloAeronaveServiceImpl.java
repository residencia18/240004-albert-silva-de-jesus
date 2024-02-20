package com.companhia.aerea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.ModeloAeronave;
import com.companhia.aerea.repositories.ModeloAeronaveRepository;

@Service
@Transactional(readOnly = false)
public class ModeloAeronaveServiceImpl implements ModeloAeronaveService {

  @Autowired
  private ModeloAeronaveRepository modeloAeronaveRepository;

  @Override
  public List<ModeloAeronave> buscarTodos(String nome, String fabricante) {
    List<ModeloAeronave> modelos;

    if (nome != null && !nome.isEmpty() && fabricante != null && !fabricante.isEmpty()) {
      modelos = modeloAeronaveRepository.findByNomeAndFabricante(nome, fabricante);

    } else if (nome != null && !nome.isEmpty()) {
      modelos = modeloAeronaveRepository.findByNome(nome);

    } else if (fabricante != null && !fabricante.isEmpty()) {
      modelos = modeloAeronaveRepository.findByFabricante(fabricante);

    } else {
      modelos = modeloAeronaveRepository.findAll();
    }

    return modelos;
  }

}