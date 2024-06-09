package com.swproject.vendagrocer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.vendagrocer.entities.UserSystem;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long>{
  
}
