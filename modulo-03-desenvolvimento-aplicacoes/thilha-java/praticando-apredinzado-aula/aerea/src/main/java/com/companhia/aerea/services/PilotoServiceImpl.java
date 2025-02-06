package com.companhia.aerea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.Piloto;
import com.companhia.aerea.repositories.PilotoRepository;
import com.companhia.aerea.web.dto.PilotoResponseDto;
import com.companhia.aerea.web.dto.form.PilotoForm;
import com.companhia.aerea.web.dto.mapper.PilotoMapper;

@Service
@Transactional(readOnly = false)
public class PilotoServiceImpl implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    @Override
    @Transactional(readOnly = false)
    public List<PilotoResponseDto> buscarTodos(String nome) {

        List<Piloto> pilotos;

        if (nome != null) {
            pilotos = pilotoRepository.findByNomeContainingIgnoreCase(nome);
        } else {
            pilotos = pilotoRepository.findAllByOrderByNome();
        }
        return PilotoMapper.toListDto(pilotos);
    }

    @SuppressWarnings("null")
    @Override
    @Transactional
    public Piloto salvar(Piloto piloto) {
        return pilotoRepository.save(piloto);
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
            pilotos = pilotoRepository.findAllByOrderByNome();
        } else {
            pilotos = pilotoRepository.findByNomeContainingIgnoreCase(nome);
        }
        return PilotoMapper.toListDto(pilotos);
    }

    @SuppressWarnings("null")
    @Override
    @Transactional(readOnly = true)
    public Piloto buscarPorId(Long id) {
        // Optional<Usuario> obj = usuarioRepository.findById(id);
        // return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return pilotoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id Inválido para condutor:" + id));
    }

    @Override
    public Piloto update(Long id, PilotoForm pilotoForm) {
        Piloto piloto = buscarPorId(id);
        piloto.setNome(pilotoForm.getNome());
        piloto.setNumBreve(pilotoForm.getNumBreve());
        piloto.setRegistro(pilotoForm.getRegistro());
        return salvar(piloto);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        pilotoRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public Boolean isExisteId(Long id) {
        if (pilotoRepository.existsById(id)) {
            return true;
        }
        return false;
    }

}