package com.residenciatic18.apileilao.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.residenciatic18.apileilao.entities.Concorrente;
import com.residenciatic18.apileilao.repositories.ConcorrenteRepository;
import com.residenciatic18.apileilao.web.dto.ConcorrenteResponseDto;
import com.residenciatic18.apileilao.web.dto.form.ConcorrenteForm;
import com.residenciatic18.apileilao.web.dto.mapper.ConcorrenteMapper;

@Service
@Transactional(readOnly = false)
public class ConcorrenteServiceImpl implements ConcorrenteService {

  @Autowired
  private ConcorrenteRepository concorrenteRepository;

  @SuppressWarnings("null")
  @Override
  @Transactional
  public Concorrente salvar(Concorrente concorrente) {
    return concorrenteRepository.save(concorrente);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ConcorrenteResponseDto> findById(Long id) {

    if (id == null) {
      return ConcorrenteMapper.toListDto(findAll());
    } else {

      Concorrente concorrente = buscarPorId(id);
     if(concorrente != null) {
        return ConcorrenteMapper.toListDto(Collections.singletonList(concorrente));

      } else {
        return new ArrayList<ConcorrenteResponseDto>();
      }
    }
  }

  @Override
  public List<Concorrente> findAll() {
    return concorrenteRepository.findAll();
  }

  @SuppressWarnings("null")
  @Override
  public Concorrente buscarPorId(Long id) {
    return concorrenteRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id Inválido para o leilao:" + id));
  }

  @Override
  public Concorrente update(Long id, ConcorrenteForm concorrenteForm) {
    Concorrente concorrente = buscarPorId(id);
    concorrente.setNome(concorrenteForm.getNome());
    concorrente.setCpf(concorrenteForm.getCpf());
    return salvar(concorrente);
  }

  @SuppressWarnings("null")
  @Override
  public void delete(Long id) {
    concorrenteRepository.deleteById(id);
  }

  @SuppressWarnings("null")
  @Override
  public Boolean isExisteId(Long id) {
    if (concorrenteRepository.existsById(id)) {
      return true;
    } else {
      return false;
    }
  }

}
