package com.swprojects.salesforce.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

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
import com.swprojects.salesforce.entities.Product;
import com.swprojects.salesforce.services.ProductService;
import com.swprojects.salesforce.web.controllers.ProductController;
import com.swprojects.salesforce.web.dto.form.ProductForm;
import com.swprojects.salesforce.web.dto.mapper.ProductMapper;

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
        .andExpect(content().json(objectMapper.writeValueAsString(ProductMapper.toDto(saveProduct))));
  }

  @Test
  void getAllProducts_ReturnsProductList() throws Exception {
    Product product = generateFakeProduct();
    when(productService.findAll()).thenReturn(Arrays.asList(product));

    mockMvc.perform(get("/api/v1/products/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(ProductMapper.toDto(product)))));
  }

  @Test
  void getProductById_WhenproductExists_Returnsproduct() throws Exception {
    Product product = generateFakeProduct();
    when(productService.findById(1L)).thenReturn(Optional.of(product));

    mockMvc.perform(get("/api/v1/products/{id}", 1))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(ProductMapper.toDto(product))));
  }

  @Test
  void getProductById_WhenProductDoesNotExist_ReturnsNotFound() throws Exception {
    when(productService.findById(any(Long.class))).thenReturn(Optional.empty());

    mockMvc.perform(get("/api/v1/products/{id}", 1))
        .andExpect(status().isNotFound());
  }

  @Test
  void updateProduct_WhenProductExists_ReturnsUpdatedProduct() throws Exception {
    Product updateInfo = generateFakeProduct(); // Usando Faker para gerar dados de atualização
    Product updatedProduct = generateFakeProduct(); // Supondo que seria outra versão dos dados do empregado

    // Forçando uma mudança para garantir que o empregado foi atualizado
    updatedProduct.setName("Updated " + updatedProduct.getName());
    when(productService.update(any(Long.class), any(ProductForm.class))).thenReturn(Optional.of(updatedProduct));

    mockMvc.perform(put("/api/v1/products/{id}", 1)
        .content(objectMapper.writeValueAsString(updateInfo))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(ProductMapper.toDto(updatedProduct))));
  }
}
