package com.companhia.aerea.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companhia.aerea.entities.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long>{
    
  List<Aeroporto> findByIcao(String icao);

  List<Aeroporto> findByNome(String nome);

  List<Aeroporto> findByNomeAndIcao(String nome, String icao);
}
