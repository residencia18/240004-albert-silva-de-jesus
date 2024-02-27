package com.companhia.aerea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.entities.ModeloAeronave;
import com.companhia.aerea.repositories.ModeloAeronaveRepository;
import com.companhia.aerea.web.dto.ModeloAeronaveResponseDto;
import com.companhia.aerea.web.dto.form.ModeloAeronaveForm;

@Service
@Transactional(readOnly = false)
public class ModeloAeronaveServiceImpl implements ModeloAeronaveService {

  @Autowired
  private ModeloAeronaveRepository modeloAeronaveRepository;

  // @Override
  // public List<ModeloAeronave> buscarTodos(String nome, String fabricante) {

  // List<ModeloAeronave> modelos;

  // if (nome != null && !nome.isEmpty() && fabricante != null &&
  // !fabricante.isEmpty()) {
  // modelos = modeloAeronaveRepository.findByNomeAndFabricante(nome, fabricante);

  // } else if (nome != null && !nome.isEmpty()) {
  // modelos = modeloAeronaveRepository.findByNome(nome);

  // } else if (fabricante != null && !fabricante.isEmpty()) {
  // modelos = modeloAeronaveRepository.findByFabricante(fabricante);

  // } else {
  // modelos = modeloAeronaveRepository.findAll();
  // }

  // return modelos;
  // }

  @Override
  public List<ModeloAeronaveResponseDto> buscaTodos() {

    throw new UnsupportedOperationException("Unimplemented method 'buscaTodos'");
  }

  @Override
  public List<ModeloAeronaveResponseDto> buscarPorNome(String nome) {

    throw new UnsupportedOperationException("Unimplemented method 'buscarPorNome'");
  }

  @Override
  public ModeloAeronave salvar(Aeroporto modeloAerona) {

    throw new UnsupportedOperationException("Unimplemented method 'salvar'");
  }

  @Override
  public ModeloAeronave buscarPorId(Long id) {

    throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
  }

  @Override
  public ModeloAeronave insert(Long id, ModeloAeronaveForm modeloAeronaForm) {

    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public ModeloAeronaveResponseDto update(Long id, ModeloAeronaveForm modeloAeronaForm) {

    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public Boolean isExisteId(Long id) {

    throw new UnsupportedOperationException("Unimplemented method 'isExisteId'");
  }

}