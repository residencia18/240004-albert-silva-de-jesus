package com.companhia.aerea.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.Piloto;
import com.companhia.aerea.repositories.PilotoRepository;
import com.companhia.aerea.web.dto.PilotoDto;
import com.companhia.aerea.web.dto.PilotoResponseDto;
import com.companhia.aerea.web.dto.form.PilotoForm;
import com.companhia.aerea.web.dto.mapper.PilotoMapper;

@Service
@Transactional(readOnly = false)
public class PilotoServiceImpl implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    // @Override
    // public List<PilotoDto> buscarTodos() {
    // List<Piloto> pilotos = pilotoRepository.findAll();
    // List<PilotoDto> pilotoDTO = new ArrayList<>();

    // for (Piloto piloto : pilotos) {
    // pilotoDTO.add(new PilotoDto(piloto));
    // }
    // return pilotoDTO;
    // }

    @Override
    @Transactional(readOnly = true)
    public List<Piloto> buscaTodos() {
        return pilotoRepository.findAll();
    }

    // @Override
    // public List<PilotoDto> buscarPorNome(String nome) {

    // List<Piloto> pilotos;
    // if (nome == null) {
    // pilotos = pilotoRepository.findAll();

    // } else {
    // pilotos = pilotoRepository.findByNomeContainingIgnoreCase(nome);
    // }
    // List<PilotoDto> pilotoDto = new ArrayList<>();

    // for (Piloto piloto : pilotos) {
    // pilotoDto.add(new PilotoDto(piloto));
    // }

    // return pilotoDto;
    // }

    @Override
    public List<PilotoResponseDto> buscarPorNome(String nome) {

        List<Piloto> pilotos;
        if (nome == null) {
            pilotos = pilotoRepository.findAll();
        } else {
            pilotos = pilotoRepository.findByNomeContainingIgnoreCase(nome);
        }
        return PilotoMapper.toListDto(pilotos);
    }

    @SuppressWarnings("null")
    @Override
    @Transactional
    public Piloto salvar(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @Override
    @Transactional(readOnly = true)
    public Piloto buscarPorId(Long id) {
        // Optional<Usuario> obj = usuarioRepository.findById(id);
        // return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return pilotoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id Inválido para condutor:" + id));
    }

    @Override
    public Piloto insert(Long id, PilotoForm pilotoForm) {
        Piloto piloto = buscarPorId(id);
        piloto.setNome(pilotoForm.getNome());
        piloto.setNumBreve(pilotoForm.getNumBreve());
        piloto.setRegistro(pilotoForm.getRegistro());
        PilotoDto pilotoDto = new PilotoDto(piloto);
        return piloto;
    }

    // @Override
    // public PilotoDto update(Long id, PilotoForm pilotoForm) {
    //     return new PilotoDto(insert(id, pilotoForm));
    // }

    @Override
    public PilotoResponseDto update(Long id, PilotoForm pilotoForm) {
        return new PilotoResponseDto(id, pilotoForm.getNome(), pilotoForm.getNumBreve());
    }

    @Override
    public void delete(Long id) {
        pilotoRepository.deleteById(id);
    }

    @Override
    public Boolean isExisteId(Long id) {
        if (pilotoRepository.existsById(id)) {
            return true;
        }
        return false;
    }

}