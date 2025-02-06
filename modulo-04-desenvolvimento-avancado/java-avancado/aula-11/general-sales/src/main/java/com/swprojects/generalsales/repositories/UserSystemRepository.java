package com.swprojects.generalsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.generalsales.entities.UserSystem;
import java.util.Optional;


@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {

  boolean existsByRole(UserSystem.Role role);

  Optional<UserSystem> findByUsername(String username);
}
