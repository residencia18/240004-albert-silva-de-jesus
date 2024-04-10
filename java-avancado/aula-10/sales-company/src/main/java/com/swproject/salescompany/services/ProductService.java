package com.swproject.salescompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.salescompany.entities.Product;
import com.swproject.salescompany.exception.EntityNotFoundException;
import com.swproject.salescompany.repositories.ProductRepository;
import com.swproject.salescompany.web.dto.form.ProductForm;

@Service
@Transactional(readOnly = false)
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product create(@Nullable Product product) {

    if (product == null) {
      throw new IllegalArgumentException("O parâmetro 'product' não pode ser nulo.");
    }

    return productRepository.save(product);
  }

  @Transactional(readOnly = true)
  public Optional<Product> findById(@NonNull Long id) {
    return Optional.ofNullable(productRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Product id=%s não encontrado", id))));
        
  }

  public Optional<Product> update(@NonNull Long id, ProductForm productForm) {
    return findById(id).map(product -> {
      product.setName(productForm.getName());
      product.setDescription(productForm.getDescription());
      product.setPrice(productForm.getPrice());
      product.setImgUrl(productForm.getImgUrl());
      return productRepository.save(product);
    });
  }

  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public void delete(@NonNull Long id) {
    productRepository.deleteById(id);
  }

}
