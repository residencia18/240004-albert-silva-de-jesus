package com.companhia.aerea.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.Piloto;
import com.companhia.aerea.repositories.PilotoRepository;
import com.companhia.aerea.web.dto.PilotoDto;

@Service
@Transactional(readOnly = false)
public class PilotoServiceImpl implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    @Override
    public List<PilotoDto> buscarTodos(String nome) {
        List<Piloto> pilotos;
        if (nome == null) {
            pilotos = pilotoRepository.findAll();

        } else {
            pilotos = pilotoRepository.findByNome(nome);
        }
        List<PilotoDto> pilotosDTO = new ArrayList<>();
        for (Piloto piloto : pilotos) {
            pilotosDTO.add(new PilotoDto(piloto));
        }

        return pilotosDTO;
    }

}
