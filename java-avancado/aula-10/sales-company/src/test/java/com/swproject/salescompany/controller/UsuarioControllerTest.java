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
import com.swproject.salescompany.entities.Usuario;
import com.swproject.salescompany.entities.Usuario.Role;
import com.swproject.salescompany.services.UsuarioService;
import com.swproject.salescompany.web.controllers.UsuarioController;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

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

    private Usuario generateFakeUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsername(faker.internet().emailAddress());
        usuario.setPassword(faker.number().digits(6));
        usuario.setRole(Role.ROLE_ADMIN);
        return usuario;
    }

    @Test
    void createUsuario_WithValidData_ReturnsCreated() throws Exception {
        Usuario newUsuario = generateFakeUsuario();

        Usuario saveUsuario = generateFakeUsuario();
        saveUsuario.setId(faker.number().randomNumber());

        when(usuarioService.create(any(Usuario.class))).thenReturn(saveUsuario);

        mockMvc.perform(post("/api/v1/usuarios")
                .content(objectMapper.writeValueAsString(newUsuario))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(saveUsuario)));

    }
}
