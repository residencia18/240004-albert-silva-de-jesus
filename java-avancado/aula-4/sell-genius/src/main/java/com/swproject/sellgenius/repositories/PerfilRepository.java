package com.swproject.sellgenius.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.sellgenius.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{
  
}
