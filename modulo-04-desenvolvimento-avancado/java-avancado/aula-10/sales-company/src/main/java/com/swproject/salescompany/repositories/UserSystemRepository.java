package com.swproject.salescompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.salescompany.entities.UserSystem;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {

  boolean existsByRole(UserSystem.Role role);
}
