package com.swprojects.generalsales.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.swprojects.generalsales.entities.Usuario;
import com.swprojects.generalsales.repositories.UsuarioRepository;

@DataJpaTest
public class UsuarioRepositoryTest {

  @Autowired
  private UsuarioRepository usuarioRepository;

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
    assertThat(usuarioRepository).isNotNull();
  }

  private Usuario generateFakeUsuario() {
    Usuario usuario = new Usuario();
    usuario.setUsername(faker.internet().emailAddress());
    usuario.setPassword(faker.number().digits(6));
    usuario.setRole(Usuario.Role.ROLE_ADMIN);
    return usuario;
  }

  @Test
  void createUsuario_WithValidData_ReturnsUsuario() {
    Usuario usuario = generateFakeUsuario();

    Usuario saveUsuario = usuarioRepository.save(usuario);

    assertThat(saveUsuario).isNotNull();
    assertThat(saveUsuario.getId()).isNotNull();
    assertThat(saveUsuario.getUsername()).isEqualTo(usuario.getUsername());
    assertThat(saveUsuario.getPassword()).isEqualTo(usuario.getPassword());
    assertThat(saveUsuario.getRole()).isEqualTo(usuario.getRole());
  }

  @Test
  void createUsuario_WithExistingCpf_ThrowsException() {
    Usuario usuario1 = generateFakeUsuario();
    testEntityManager.persistFlushFind(usuario1); // Força a persistência imediata

    Usuario usuario2 = generateFakeUsuario();
    usuario2.setUsername(usuario1.getUsername());

    assertThatThrownBy(() -> usuarioRepository.save(usuario2)).isInstanceOf(Exception.class);
  }

}
