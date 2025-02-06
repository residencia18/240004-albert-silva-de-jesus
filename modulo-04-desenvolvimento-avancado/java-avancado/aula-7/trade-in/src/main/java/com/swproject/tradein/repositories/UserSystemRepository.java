package com.swproject.tradein.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.tradein.entities.UserSystem;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long>{
  
}
