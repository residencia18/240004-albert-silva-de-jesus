package com.companhia.aerea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companhia.aerea.entities.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long>{
    
}
