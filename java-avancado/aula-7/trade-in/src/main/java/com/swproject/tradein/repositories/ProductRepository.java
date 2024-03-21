package com.swproject.tradein.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.tradein.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
