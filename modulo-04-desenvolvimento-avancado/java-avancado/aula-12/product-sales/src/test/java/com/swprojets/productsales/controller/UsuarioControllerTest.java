package com.swprojets.productsales.controller;

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
import com.swprojets.productsales.entities.UserSystem;
import com.swprojets.productsales.entities.UserSystem.Role;
import com.swprojets.productsales.services.UserSystemService;
import com.swprojets.productsales.web.controllers.UserSystemController;
import com.swprojets.productsales.web.dto.form.UserSystemForm;
import com.swprojets.productsales.web.dto.mapper.UserSystemMapper;

@WebMvcTest(UserSystemController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserSystemService usuarioService;

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

    private UserSystem generateFakeUsuario() {
        UserSystem usuario = new UserSystem();
        usuario.setUsername(faker.internet().emailAddress());
        usuario.setPassword(faker.number().digits(6));
        usuario.setRole(Role.ROLE_ADMIN);
        return usuario;
    }

    @Test
    void createUsuario_WithValidData_ReturnsCreated() throws Exception {
        UserSystem newUsuario = generateFakeUsuario();

        UserSystem saveUsuario = generateFakeUsuario();
        saveUsuario.setId(faker.number().randomNumber());

        when(usuarioService.create(any(UserSystem.class))).thenReturn(saveUsuario);

        mockMvc.perform(post("/api/v1/usuarios")
                .content(objectMapper.writeValueAsString(newUsuario))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(UserSystemMapper.toDto(saveUsuario))));
    }

    @Test
    void getAllUsuarios_ReturnsUsuarioList() throws Exception {
        UserSystem usuario = generateFakeUsuario();
        when(usuarioService.findAll()).thenReturn(Arrays.asList(usuario));

        mockMvc.perform(get("/api/v1/usuarios/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content().json(objectMapper.writeValueAsString(Arrays.asList(UserSystemMapper.toDto(usuario)))));
    }

    @Test
    void getUsuarioById_WhenUsuarioExists_ReturnsUsuario() throws Exception {
        UserSystem usuario = generateFakeUsuario();
        when(usuarioService.searchbyId(1L)).thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/api/v1/usuarios/searchbyId/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(UserSystemMapper.toDto(usuario))));
    }

    @Test
    void getUsuarioById_WhenUsuarioDoesNotExist_ReturnsNotFound() throws Exception {
        when(usuarioService.searchbyId(any(Long.class))).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/usuarios/searchbyId/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateUsuario_WhenUsuarioExists_ReturnsUpdatedUsuario() throws Exception {
        UserSystem updateInfo = generateFakeUsuario(); // Usando Faker para gerar dados de atualização
        UserSystem updatedUsuario = generateFakeUsuario(); // Supondo que seria outra versão dos dados do empregado

        // Forçando uma mudança para garantir que o empregado foi atualizado
        updatedUsuario.setUsername("Updated@gmail.com " + updatedUsuario.getUsername());
        when(usuarioService.toEdit(any(Long.class), any(UserSystemForm.class))).thenReturn(Optional.of(updatedUsuario));

        mockMvc.perform(put("/api/v1/usuarios/toEdit/{id}", 1)
                .content(objectMapper.writeValueAsString(updateInfo))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(UserSystemMapper.toDto(updatedUsuario))));
    }

}
