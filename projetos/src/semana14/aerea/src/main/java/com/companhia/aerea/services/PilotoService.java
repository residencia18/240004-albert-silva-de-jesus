package com.companhia.aerea.services;

import java.util.List;

import com.companhia.aerea.entities.Piloto;
import com.companhia.aerea.web.dto.PilotoDto;
import com.companhia.aerea.web.form.PilotoForm;   

public interface PilotoService {

    List<PilotoDto> buscarTodos();

    List<PilotoDto> buscarPorNome(String nome);

    Piloto salvar(Piloto piloto);

    Piloto buscarPorId(Long id);

    Piloto insert(Long id, PilotoForm pilotoForm);

    PilotoDto update(Long id, PilotoForm pilotoForm);

    void delete(Long id);

    Boolean isExisteId(Long id);
}
