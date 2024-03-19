package com.swproject.sellgenius.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.sellgenius.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}
