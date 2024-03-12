package com.example.crud_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}
