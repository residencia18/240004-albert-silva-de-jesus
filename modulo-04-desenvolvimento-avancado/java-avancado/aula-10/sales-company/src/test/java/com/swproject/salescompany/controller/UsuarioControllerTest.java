package com.swproject.salescompany.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
import com.swproject.salescompany.entities.UserSystem;
import com.swproject.salescompany.entities.UserSystem.Role;
import com.swproject.salescompany.services.UserSystemService;
import com.swproject.salescompany.web.controllers.UserSystemController;

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
                .andExpect(content().json(objectMapper.writeValueAsString(saveUsuario)));

    }
}
