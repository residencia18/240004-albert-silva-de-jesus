package com.swproject.buyeverything.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.javafaker.Faker;

import com.swproject.buyeverything.entities.Product;
import com.swproject.buyeverything.repositories.ProductRepository;
import com.swproject.buyeverything.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

  private Product product;
  private Faker faker;

  @BeforeEach
  void setUp() {
    faker = new Faker(new Locale("en-US"));
    // Gerando dados fictícios com o FAKER
    product = new Product();
    product.setId(1L); // Garantindo um ID para os testes de update
    product.setName(faker.name().fullName());
    product.setDescription(faker.lorem().sentence());
    product.setPrice(faker.number().randomDouble(2, 1, 1000));
    product.setImgUrl(faker.internet().image());
  }

  @Test
  void testCreateFakeEmployee() {
    // Configura o Mockito para retornar o mesmo funcionario quando o repositório
    // salvar qualquer funcionario
    given(productRepository.save(any(Product.class))).willReturn(product);

    // Ação:
    Product savedProduct = productService.save(product);

    // Assert
    // Verifica se o método save do repositório foi chamado
    verify(productRepository).save(any(Product.class));

    // verifica as propriedades do funcionario retornado para assegurar que elas
    // correspondem ao esperado
    assertNotNull(savedProduct, "O produto salvo não deve ser nulo");
    assertEquals(product.getName(), savedProduct.getName(), "O nome da produto não corresponde ao esperado");
    assertEquals(product.getDescription(), savedProduct.getDescription(),
        "A descrição do produto não corresponde ao esperado");
    assertEquals(product.getPrice(), savedProduct.getPrice(), "O preço do produto não corresponde ao esperado");
    assertEquals(product.getImgUrl(), savedProduct.getImgUrl(),
        "A URL da imagem do produto não corresponde ao esperado");

  }
}
