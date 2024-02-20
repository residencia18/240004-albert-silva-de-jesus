package com.companhia.aerea.services;

import java.util.List;

import com.companhia.aerea.dto.PilotoDto;   

public interface PilotoService {

    public List<PilotoDto> buscarTodos(String nome);

}
