package com.companhia.aerea.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companhia.aerea.entities.ModeloAeronave;

public interface ModeloAeronaveRepository extends JpaRepository<ModeloAeronave, Long> {
  
  List<ModeloAeronave> findByNome(String nome);

  List<ModeloAeronave> findByFabricante(String fabricante);
}
