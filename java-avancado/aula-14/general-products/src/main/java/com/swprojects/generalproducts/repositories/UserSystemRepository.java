package com.swprojects.generalproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.generalproducts.entities.UserSystem;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {

  boolean existsByRole(UserSystem.Role role);

  boolean existsByUsername(String username);

  Optional<UserSystem> findByUsername(String username);
}
