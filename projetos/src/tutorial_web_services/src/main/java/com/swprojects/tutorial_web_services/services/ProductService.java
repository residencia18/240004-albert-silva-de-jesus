package com.swprojects.tutorial_web_services.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swprojects.tutorial_web_services.entities.Product;
import com.swprojects.tutorial_web_services.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {
    @SuppressWarnings("null")
    Optional<Product> obj = productRepository.findById(id);
    return obj.get();
  }
}