package com.companhia.aerea.services;

import java.util.List;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.entities.ModeloAeronave;
import com.companhia.aerea.web.dto.ModeloAeronaveResponseDto;
import com.companhia.aerea.web.dto.form.ModeloAeronaveForm;

public interface ModeloAeronaveService {

    List<ModeloAeronaveResponseDto> buscaTodos();

    List<ModeloAeronaveResponseDto> buscarPorNome(String nome);

    ModeloAeronave salvar(Aeroporto modeloAerona);

    ModeloAeronave buscarPorId(Long id);

    ModeloAeronave insert(Long id, ModeloAeronaveForm modeloAeronaForm);

    ModeloAeronaveResponseDto update(Long id, ModeloAeronaveForm modeloAeronaForm);

    void delete(Long id);

    Boolean isExisteId(Long id);
}