package com.swproject.tradein.web.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swproject.tradein.entities.Product;
import com.swproject.tradein.services.ProductService;
import com.swproject.tradein.web.dto.ProductResponseDto;
import com.swproject.tradein.web.dto.form.ProductForm;
import com.swproject.tradein.web.dto.mapper.ProductMapper;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity<ProductResponseDto> create(@RequestBody ProductForm createDto) {
    Product product = productService.save(ProductMapper.toProduct(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
    return ResponseEntity.created(uri).body(ProductMapper.toDto(product));
  }
}
