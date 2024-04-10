package com.swprojects.generalsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.generalsales.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  boolean existsByRole(Usuario.Role role);
}
