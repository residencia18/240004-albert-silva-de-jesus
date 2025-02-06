package com.swproject.shopall.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.shopall.entities.Product;
import com.swproject.shopall.repositories.ProductRepository;

@Service
@Transactional(readOnly = false)
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product save(@Nullable Product product) {

    if (product == null) {
      throw new IllegalArgumentException("O parâmetro 'product' não pode ser nulo.");
    }

    return productRepository.save(product);
  }

}
