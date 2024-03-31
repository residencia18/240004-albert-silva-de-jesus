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
import com.swproject.buyeverything.entities.Category;

import com.swproject.buyeverything.repositories.CategoryRepository;
import com.swproject.buyeverything.services.CategoryService;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

  @Mock
  private CategoryRepository categoryRepository;

  @InjectMocks
  private CategoryService categoryService;

  private Category category;
  private Faker faker;

  @BeforeEach
  void setUp() {
    faker = new Faker(new Locale("en-US"));
    // Gerando dados fictícios com o FAKER
    category = new Category();
    category.setId(1L); // Garantindo um ID para os testes de update
    category.setName(faker.name().fullName());
  }

  @Test
  void testCreateFakeEmployee() {
    // Configura o Mockito para retornar o mesmo funcionario quando o repositório
    // salvar qualquer funcionario
    given(categoryRepository.save(any(Category.class))).willReturn(category);

    // Ação:
    Category savedCategory = categoryService.save(category);

    // Assert
    // Verifica se o método save do repositório foi chamado
    verify(categoryRepository).save(any(Category.class));

    // verifica as propriedades do funcionario retornado para assegurar que elas
    // correspondem ao esperado
    assertNotNull(savedCategory, "A categoria salva não deve ser nulo");
    assertEquals(category.getName(), savedCategory.getName(), "O nome da categoria não corresponde ao esperado");

  }
}
