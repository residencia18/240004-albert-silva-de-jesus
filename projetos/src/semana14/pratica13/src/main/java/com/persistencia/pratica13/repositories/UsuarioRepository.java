package com.persistencia.pratica13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistencia.pratica13.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  
  List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
