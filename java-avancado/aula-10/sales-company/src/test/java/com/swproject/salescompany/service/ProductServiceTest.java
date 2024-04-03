package com.swproject.salescompany.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import com.swproject.salescompany.entities.Product;
import com.swproject.salescompany.repositories.ProductRepository;
import com.swproject.salescompany.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

  public static final Logger log = LoggerFactory.getLogger(ProductServiceTest.class);

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

  private Faker faker;

  @BeforeEach
  void setUp() {
    faker = new Faker();
  }

  private Product generateFakeProduct() {
    Product product = new Product();
    product.setId(1L); // Garantindo um ID para os testes de update
    product.setName(faker.name().fullName());
    product.setDescription(faker.lorem().sentence());
    product.setPrice(faker.number().randomDouble(2, 1, 1000));
    product.setImgUrl(faker.internet().image());
    log.info("Product: " + product);
    return product;
  }

  @Test
  void createProduct_WithValidData_ReturnsProduct() {

    Product fakeProduct = generateFakeProduct();
    // Configura o Mockito para retornar o mesmo funcionario quando o repositório
    // salvar qualquer funcionario
    given(productRepository.save(any(Product.class))).willReturn(fakeProduct);

    // Ação:
    Product savedProduct = productService.save(fakeProduct);

    // Assert
    // Verifica se o método save do repositório foi chamado
    verify(productRepository).save(any(Product.class));

    // verifica as propriedades do funcionario retornado para assegurar que elas
    // correspondem ao esperado
    assertNotNull(savedProduct, "O produto salvo não deve ser nulo");
    assertEquals(fakeProduct.getName(), savedProduct.getName(), "O nome da produto não corresponde ao esperado");
    assertEquals(fakeProduct.getDescription(), savedProduct.getDescription(),
        "A descrição do produto não corresponde ao esperado");
    assertEquals(fakeProduct.getPrice(), savedProduct.getPrice(), "O preço do produto não corresponde ao esperado");
    assertEquals(fakeProduct.getImgUrl(), savedProduct.getImgUrl(),
        "A URL da imagem do produto não corresponde ao esperado");

  }
}
