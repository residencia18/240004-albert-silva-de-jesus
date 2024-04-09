package com.swproject.salescompany.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;

import com.github.javafaker.Faker;
import com.swproject.salescompany.entities.Category;
import com.swproject.salescompany.repositories.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

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
        assertThat(categoryRepository).isNotNull();
    }

    private Category generateFakeCategory() {
        Category category = new Category();
        category.setName(faker.commerce().department());
        return category;
    }

    @Test
    void createCategory_WithValidData_ReturnsCategory() {
        Category category = generateFakeCategory();

        Category savedCategory = categoryRepository.save(category);

        assertThat(savedCategory).isNotNull();
        assertThat(savedCategory.getId()).isGreaterThan(0); // Não é muito útil nesse caso
        assertThat(savedCategory.getName()).isEqualTo(category.getName());

    }

    @Test
    void createCategory_WithExistingNome_ThrowsException() {
        // Crie e persista uma categoria com um nome existente
        Category category1 = generateFakeCategory();
        testEntityManager.persistFlushFind(category1); // Força a persistência imediata

        // Tente criar outra categoria com o mesmo nome
        Category category2 = generateFakeCategory();
        category2.setName(category1.getName());

        // Verifique se uma exceção é lançada ao tentar salvar a segunda categoria
        assertThatThrownBy(() -> categoryRepository.save(category2)).isInstanceOf(Exception.class);
    }
}
