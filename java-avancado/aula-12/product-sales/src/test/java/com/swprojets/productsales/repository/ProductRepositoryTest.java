package com.swprojets.productsales.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.swprojets.productsales.entities.Product;
import com.swprojets.productsales.repositories.ProductRepository;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private Faker faker;

    @AfterEach
    public void setup() {
        // faker = new Faker();
    }

    @TestConfiguration
    static class FakerTestConfig {

        @Bean
        public Faker faker() {
            return new Faker();
        }
    }

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(testEntityManager).isNotNull();
        assertThat(productRepository).isNotNull();
    }

    private Product generateFakeProduct() {
        Product product = new Product();
        product.setName(faker.commerce().productName());
        product.setDescription(faker.commerce().material());
        product.setPrice(faker.number().randomDouble(2, 1, 1000));
        product.setImgUrl(faker.internet().url());
        return product;
    }

    @Test
    void createProduct_WithValidData_ReturnsProduct() {
        Product product = generateFakeProduct();

        Product savedProduct = productRepository.save(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo(product.getName());
        assertThat(savedProduct.getDescription()).isEqualTo(product.getDescription());
        assertThat(savedProduct.getPrice()).isEqualTo(product.getPrice());
        assertThat(savedProduct.getImgUrl()).isEqualTo(product.getImgUrl());

    }

    @Test
    void createProduct_WithExistingNome_ThrowsException() {
        // Crie e persista uma categoria com um nome existente
        Product product1 = generateFakeProduct();
        testEntityManager.persistFlushFind(product1); // Força a persistência imediata

        // Tente criar outra categoria com o mesmo nome
        Product product2 = generateFakeProduct();
        product2.setName(product1.getName());

        // Verifique se uma exceção é lançada ao tentar salvar a segunda categoria
        assertThatThrownBy(() -> productRepository.save(product2)).isInstanceOf(Exception.class);
    }

    @Test
    void findProduct_ById_ReturnsProduct() {
        Product product = generateFakeProduct();
        Product persistedProduct = testEntityManager.persistFlushFind(product);

        Optional<Product> foundProduct = productRepository.findById(persistedProduct.getId());

        assertThat(foundProduct).isNotEmpty();
        assertThat(foundProduct.get().getId()).isEqualTo(persistedProduct.getId());
    }

    @Test
    void findProduct_ByName_ReturnsProduct() {
        Product product = generateFakeProduct();
        Product persistedProduct = testEntityManager.persistFlushFind(product);

        Optional<Product> foundProduct = productRepository.findByName(persistedProduct.getName());

        assertThat(foundProduct).isNotEmpty();
        assertThat(foundProduct.get().getName()).isEqualTo(persistedProduct.getName());
    }

    @Test
    void listProducts_ReturnsAllProducts() {
        Product product1 = generateFakeProduct();
        Product product2 = generateFakeProduct();
        testEntityManager.persistFlushFind(product1);
        testEntityManager.persistFlushFind(product2);

        List<Product> products = productRepository.findAll();

        assertThat(products).hasSizeGreaterThanOrEqualTo(2);
    }

    @Test
    void deleteProduct_WithExistingId_RemovesProduct() {
        Product product = generateFakeProduct();
        Product persistedProduct = testEntityManager.persistFlushFind(product);

        productRepository.deleteById(persistedProduct.getId());

        Product deletedProduct = testEntityManager.find(Product.class, persistedProduct.getId());
        assertThat(deletedProduct).isNull();
    }

}
