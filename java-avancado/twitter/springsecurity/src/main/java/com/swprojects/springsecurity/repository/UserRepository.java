package com.swprojects.springsecurity.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.springsecurity.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
  
}
