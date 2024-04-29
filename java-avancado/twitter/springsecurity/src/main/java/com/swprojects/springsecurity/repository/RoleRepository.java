package com.swprojects.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.springsecurity.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
  
}
