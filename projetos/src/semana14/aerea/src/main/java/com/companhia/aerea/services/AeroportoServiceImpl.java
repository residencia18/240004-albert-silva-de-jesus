package com.companhia.aerea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.repositories.AeroportoRepository;

@Service
public class AeroportoServiceImpl implements AeroportoService{

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Aeroporto> buscarTodos() {
        return aeroportoRepository.findAll();
    }
}
