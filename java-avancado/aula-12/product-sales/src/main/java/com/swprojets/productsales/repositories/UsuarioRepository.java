package com.swprojets.productsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojets.productsales.entities.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  boolean existsByRole(Usuario.Role role);

  boolean existsByUsername(String username);

  Optional<Usuario> findByUsername(String username);
}
