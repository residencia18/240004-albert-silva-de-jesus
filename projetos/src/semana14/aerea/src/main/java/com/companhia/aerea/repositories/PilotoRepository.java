package com.companhia.aerea.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companhia.aerea.entities.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long>{

    List<Piloto> findByNome(String nome);
    
}
