package com.persistencia.pratica13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencia.pratica13.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  
}
