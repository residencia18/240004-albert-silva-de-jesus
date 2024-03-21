package com.swproject.supersale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.supersale.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
