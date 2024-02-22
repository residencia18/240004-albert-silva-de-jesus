package com.companhia.aerea.services;

import java.util.List;

import com.companhia.aerea.web.dto.PilotoDto;   

public interface PilotoService {

    public List<PilotoDto> buscarTodos(String nome);

}
