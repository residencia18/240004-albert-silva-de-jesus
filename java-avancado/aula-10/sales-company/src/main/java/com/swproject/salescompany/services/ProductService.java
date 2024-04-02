package com.swproject.salescompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.salescompany.entities.Product;
import com.swproject.salescompany.exception.EntityNotFoundException;
import com.swproject.salescompany.repositories.ProductRepository;

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

  @Transactional(readOnly = true)
  public Product findById(@NonNull Long id) {
    return productRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Product id=%s não encontrado", id)));
  }

  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return productRepository.findAll();
  }

}
