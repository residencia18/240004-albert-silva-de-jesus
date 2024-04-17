package com.swprojects.salesofeverything.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.javafaker.Faker;
import com.swprojects.salesofeverything.entities.Category;
import com.swprojects.salesofeverything.repositories.CategoryRepository;
import com.swprojects.salesofeverything.services.CategoryService;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

  @Mock
  private CategoryRepository categoryRepository;

  @InjectMocks
  private CategoryService categoryService;

  private Faker faker;

  @BeforeEach
  void setUp() {
    faker = new Faker();
  }

  private Category generateFakeCategory() {
    Category category = new Category();
    category.setId(1L); // Garantindo um ID para os testes de update
    category.setName(faker.name().fullName());
    return category;
  }

  @Test
  void createCategory_WithValidData_ReturnsCategory() {

    Category fakeCategory = generateFakeCategory();
    // Configura o Mockito para retornar o mesmo funcionario quando o repositório
    // salvar qualquer funcionario
    given(categoryRepository.save(any(Category.class))).willReturn(fakeCategory);

    // Ação:
    Category savedCategory = categoryService.create(fakeCategory);

    // Assert
    // Verifica se o método save do repositório foi chamado
    verify(categoryRepository).save(any(Category.class));

    // verifica as propriedades do funcionario retornado para assegurar que elas
    // correspondem ao esperado
    assertNotNull(savedCategory, "A categoria salva não deve ser nulo");
    assertEquals(fakeCategory.getName(), savedCategory.getName(), "O nome da categoria não corresponde ao esperado");

  }
}
