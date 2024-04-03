package com.swproject.salescompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.salescompany.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
