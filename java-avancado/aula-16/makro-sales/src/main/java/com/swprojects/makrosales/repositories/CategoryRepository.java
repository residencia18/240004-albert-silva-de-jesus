package com.swprojects.makrosales.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.makrosales.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
  
    Optional<Category> findByName(String name);
}