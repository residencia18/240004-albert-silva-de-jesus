package com.swprojects.ithaseverything.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.ithaseverything.entities.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByName(String name);
}
