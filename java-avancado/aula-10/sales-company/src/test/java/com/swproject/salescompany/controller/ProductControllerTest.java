package com.swproject.salescompany.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.swproject.salescompany.entities.Product;
import com.swproject.salescompany.services.ProductService;
import com.swproject.salescompany.web.controllers.ProductController;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private Faker faker;

  @TestConfiguration
  static class FakerTestConfig {

    @Bean
    public Faker faker() {
      return new Faker();
    }
  }

  private Product generateFakeProduct() {
    Product product = new Product();
    product.setId(faker.number().randomNumber());
    product.setName(faker.commerce().productName());
    product.setPrice(faker.number().randomDouble(2, 1, 1000));
    product.setDescription(faker.lorem().sentence());
    product.setImgUrl(faker.internet().url());
    return product;
  }

  @Test
  void createProduct_WithValidData_ReturnsCreated() throws Exception {
    Product newProduct = generateFakeProduct();

    Product saveProduct = generateFakeProduct();
    saveProduct.setId(faker.number().randomNumber());

    when(productService.create(any(Product.class))).thenReturn(saveProduct);

    mockMvc.perform(post("/api/v1/products")
        .content(objectMapper.writeValueAsString(newProduct))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().json(objectMapper.writeValueAsString(saveProduct)));
  }

  @Test
  void getAllProducts_ReturnsProductList() throws Exception {
    Product product = generateFakeProduct();
    when(productService.findAll()).thenReturn(Arrays.asList(product));

    mockMvc.perform(get("/api/v1/products/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(product))));
  }
}
