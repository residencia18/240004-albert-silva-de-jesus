package com.swprojects.generalsales.controller;

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
import com.swprojects.generalsales.entities.Category;
import com.swprojects.generalsales.services.CategoryService;
import com.swprojects.generalsales.web.controllers.CategoryController;

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
                .andExpect(content().json(objectMapper.writeValueAsString(savedCategory)));
    }

    @Test
    void getAllCategorys_ReturnsCategoryList() throws Exception {
        Category category = generateFakeCategory();
        when(categoryService.findAll()).thenReturn(Arrays.asList(category));

        mockMvc.perform(get("/api/v1/categorys/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(category))));
    }

    @Test
    void getCategoryById_WhenCategoryExists_ReturnsCategory() throws Exception {
        Category category = generateFakeCategory();
        when(categoryService.findById(1L)).thenReturn(Optional.of(category));

        mockMvc.perform(get("/api/v1/categorys/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(category)));
    }

    @Test
    void getCategoryById_WhenCategoryDoesNotExist_ReturnsNotFound() throws Exception {
        when(categoryService.findById(any(Long.class))).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/categorys/{id}", 1))
                .andExpect(status().isNotFound());
    }
}
