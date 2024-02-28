package com.companhia.aerea.services;

import java.util.List;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.web.dto.AeroportoResponseDto;
import com.companhia.aerea.web.dto.form.AeroportoForm;

public interface AeroportoService {

    List<Aeroporto> buscarPorNomeOuIcao(String nome, String icao);

    Aeroporto salvar(Aeroporto aeroporto);

    Aeroporto buscarPorId(Long id);

    Aeroporto insert(Long id, AeroportoForm aeroportoForm);

    AeroportoResponseDto update(Long id, AeroportoForm aeroportoForm);

    void delete(Long id);

    Boolean isExisteId(Long id);

}