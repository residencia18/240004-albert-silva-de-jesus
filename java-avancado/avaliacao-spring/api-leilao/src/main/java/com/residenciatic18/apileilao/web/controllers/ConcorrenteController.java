package com.residenciatic18.apileilao.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.residenciatic18.apileilao.entities.Concorrente;
import com.residenciatic18.apileilao.services.ConcorrenteService;
import com.residenciatic18.apileilao.web.dto.ConcorrenteResponseDto;
import com.residenciatic18.apileilao.web.dto.form.ConcorrenteForm;
import com.residenciatic18.apileilao.web.dto.mapper.ConcorrenteMapper;

@RestController
@RequestMapping("/concorrentes/")
public class ConcorrenteController {

  @Autowired
  private ConcorrenteService concorrenteService;

  @PostMapping("create")
  public ResponseEntity<ConcorrenteResponseDto> create(@RequestBody ConcorrenteForm createDto) {
    try {
      Concorrente obj = concorrenteService.salvar(ConcorrenteMapper.toConcorrente(createDto));
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).body(ConcorrenteMapper.toDto(obj));

    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("{id}")
  public ResponseEntity<List<ConcorrenteResponseDto>> getById(@PathVariable Long id) {

    if (concorrenteService.isExisteId(id)) {
      return ResponseEntity.ok().body(concorrenteService.findById(id));

    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping
  public ResponseEntity<List<ConcorrenteResponseDto>> buscarTodos() {
    return ResponseEntity.ok(ConcorrenteMapper.toListDto(concorrenteService.findAll()));
  }

  @PutMapping("{id}")
  public ResponseEntity<ConcorrenteResponseDto> update(@PathVariable Long id, @RequestBody ConcorrenteForm createDto) {

    if (concorrenteService.isExisteId(id)) {
      return ResponseEntity.ok(ConcorrenteMapper.toDto(concorrenteService.update(id, createDto)));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

    if (concorrenteService.isExisteId(id)) {
      concorrenteService.delete(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}