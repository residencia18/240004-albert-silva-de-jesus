package com.swproject.shopall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.shopall.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
