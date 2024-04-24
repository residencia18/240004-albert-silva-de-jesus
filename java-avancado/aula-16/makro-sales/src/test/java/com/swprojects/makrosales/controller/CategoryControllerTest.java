package com.swprojects.makrosales.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
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
import com.swprojects.makrosales.entities.Category;
import com.swprojects.makrosales.services.CategoryService;
import com.swprojects.makrosales.web.controllers.CategoryController;
import com.swprojects.makrosales.web.dto.form.CategoryForm;
import com.swprojects.makrosales.web.dto.mapper.CategoryMapper;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private Faker faker;

    @TestConfiguration
    static class FakerTestConfig {

        @Bean
        public Faker faker() {
            return new Faker();
        }
    }

    private Category generateFakeCategory() {
        Category category = new Category();
        category.setName(faker.commerce().department());
        return category;
    }

    @Test
    @DisplayName("Criação de uma categoria com dados válidos retorna status 201")
    void createCategory_WithValidData_ReturnsCreated() throws Exception {
        Category newCategory = generateFakeCategory();

        // Gerando um empregado fictício que simula o retorno do serviço após a criação
        // Normalmente, isso incluiria um ID e quaisquer outros campos que são gerados
        // ou alterados na criação
        Category savedCategory = generateFakeCategory();
        savedCategory.setId(faker.number().randomNumber()); // Simulando o ID que seria gerado durante a criação

        when(categoryService.create(any(Category.class))).thenReturn(savedCategory);

        mockMvc.perform(post("/api/v1/categorys")
                .content(objectMapper.writeValueAsString(newCategory))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(CategoryMapper.toDto(savedCategory))));
    }

    @Test
    @DisplayName("Retorna uma lista de categorias quando chamado com sucesso")
    void getAllCategorys_ReturnsCategoryList() throws Exception {
        Category category = generateFakeCategory();
        when(categoryService.findAll()).thenReturn(Arrays.asList(category));

        mockMvc.perform(get("/api/v1/categorys/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content().json(objectMapper.writeValueAsString(Arrays.asList(CategoryMapper.toDto(category)))));
    }

    @Test
    @DisplayName("Retorna uma lista de categorias vazia quando não há categorias")
    void getCategoryById_WhenCategoryExists_ReturnsCategory() throws Exception {
        Category category = generateFakeCategory();
        when(categoryService.findById(1L)).thenReturn(Optional.of(category));

        mockMvc.perform(get("/api/v1/categorys/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(CategoryMapper.toDto(category))));
    }

    @Test
    void getCategoryById_WhenCategoryDoesNotExist_ReturnsNotFound() throws Exception {
        when(categoryService.findById(any(Long.class))).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/categorys/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateCategory_WhenCategoryExists_ReturnsUpdatedCategory() throws Exception {
        Category updateInfo = generateFakeCategory(); // Usando Faker para gerar dados de atualização
        Category updatedCategory = generateFakeCategory(); // Supondo que seria outra versão dos dados do empregado

        // Forçando uma mudança para garantir que o empregado foi atualizado
        updatedCategory.setName("Updated " + updatedCategory.getName());
        when(categoryService.update(any(Long.class), any(CategoryForm.class))).thenReturn(Optional.of(updatedCategory));

        mockMvc.perform(put("/api/v1/categorys/{id}", 1)
                .content(objectMapper.writeValueAsString(updateInfo))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(CategoryMapper.toDto(updatedCategory))));
    }
}
