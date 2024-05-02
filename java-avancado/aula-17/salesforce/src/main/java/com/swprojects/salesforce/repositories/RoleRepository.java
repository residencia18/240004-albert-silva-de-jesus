package com.swprojects.salesforce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.salesforce.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
  
}
