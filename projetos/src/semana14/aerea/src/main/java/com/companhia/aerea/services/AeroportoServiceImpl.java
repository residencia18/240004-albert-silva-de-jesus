package com.companhia.aerea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.repositories.AeroportoRepository;

@Service
@Transactional(readOnly = false)
public class AeroportoServiceImpl implements AeroportoService {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Aeroporto> buscarTodos(String nome, String icao) {

        List<Aeroporto> aeroportos;
        
        if (nome != null && !nome.isEmpty() && icao != null && !icao.isEmpty()) {
            aeroportos = aeroportoRepository.findByNomeAndIcao(nome, icao);

        } else if (nome != null && !nome.isEmpty()) {
            aeroportos = aeroportoRepository.findByNome(nome);

        } else if (icao != null && !icao.isEmpty()) {
            aeroportos = aeroportoRepository.findByIcao(icao);

        } else {
            aeroportos = aeroportoRepository.findAll();
        }

        return aeroportos;
    }
}
