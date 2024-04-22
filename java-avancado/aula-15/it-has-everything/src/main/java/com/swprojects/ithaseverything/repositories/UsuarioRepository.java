package com.swprojects.ithaseverything.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.ithaseverything.entities.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  boolean existsByRole(Usuario.Role role);

  boolean existsByUsername(String username);

  Optional<Usuario> findByUsername(String username);
}
