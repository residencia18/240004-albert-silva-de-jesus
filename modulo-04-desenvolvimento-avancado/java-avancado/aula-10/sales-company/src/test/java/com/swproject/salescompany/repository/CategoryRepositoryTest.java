package com.swproject.salescompany.repository;

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

    @Test
    void findCategory_ById_ReturnsCategory() {
        Category category = generateFakeCategory();
        Category persistedCategory = testEntityManager.persistFlushFind(category);

        Optional<Category> foundCategory = categoryRepository.findById(persistedCategory.getId());

        assertThat(foundCategory).isNotEmpty();
        assertThat(foundCategory.get().getId()).isEqualTo(persistedCategory.getId());
    }

    @Test
    void findCategory_ByName_ReturnsCategory() {
        Category employee = generateFakeCategory();
        Category persistedCategory = testEntityManager.persistFlushFind(employee);

        Optional<Category> foundCategory = categoryRepository.findByName(persistedCategory.getName());

        assertThat(foundCategory).isNotEmpty();
        assertThat(foundCategory.get().getName()).isEqualTo(persistedCategory.getName());
    }

    @Test
    void listCategorys_ReturnsAllCategorys() {
        Category category1 = generateFakeCategory();
        Category category2 = generateFakeCategory();
        testEntityManager.persistFlushFind(category1);
        testEntityManager.persistFlushFind(category2);

        List<Category> categorys = categoryRepository.findAll();

        assertThat(categorys).hasSizeGreaterThanOrEqualTo(2);
    }

    @Test
    void deleteCategory_WithExistingId_RemovesCategory() {
        Category category = generateFakeCategory();
        Category persistedCategory = testEntityManager.persistFlushFind(category);

        categoryRepository.deleteById(persistedCategory.getId());

        Category deletedCategory = testEntityManager.find(Category.class, persistedCategory.getId());
        assertThat(deletedCategory).isNull();
    }
}
