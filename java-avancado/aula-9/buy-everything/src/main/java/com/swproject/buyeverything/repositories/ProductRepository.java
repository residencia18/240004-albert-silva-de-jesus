package com.swproject.buyeverything.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.buyeverything.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
