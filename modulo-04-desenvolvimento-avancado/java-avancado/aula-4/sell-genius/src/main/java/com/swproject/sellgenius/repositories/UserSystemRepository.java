package com.swproject.sellgenius.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.sellgenius.entities.UserSystem;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long>{
  
}
