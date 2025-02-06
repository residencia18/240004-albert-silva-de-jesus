package com.swprojets.productsales.repository;

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
import com.swprojets.productsales.entities.UserSystem;
import com.swprojets.productsales.repositories.UserSystemRepository;

@DataJpaTest
public class UsuarioRepositoryTest {

  @Autowired
  private UserSystemRepository usuarioRepository;

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

  private UserSystem generateFakeUsuario() {
    UserSystem usuario = new UserSystem();
    usuario.setUsername(faker.internet().emailAddress());
    usuario.setPassword(faker.number().digits(6));
    usuario.setRole(UserSystem.Role.ROLE_ADMIN);
    return usuario;
  }

  @Test
  void createUsuario_WithValidData_ReturnsUsuario() {
    UserSystem usuario = generateFakeUsuario();

    UserSystem saveUsuario = usuarioRepository.save(usuario);

    assertThat(saveUsuario).isNotNull();
    assertThat(saveUsuario.getId()).isNotNull();
    assertThat(saveUsuario.getUsername()).isEqualTo(usuario.getUsername());
    assertThat(saveUsuario.getPassword()).isEqualTo(usuario.getPassword());
    assertThat(saveUsuario.getRole()).isEqualTo(usuario.getRole());
  }

  @Test
  void createUsuario_WithExistingCpf_ThrowsException() {
    UserSystem usuario1 = generateFakeUsuario();
    testEntityManager.persistFlushFind(usuario1); // Força a persistência imediata

    UserSystem usuario2 = generateFakeUsuario();
    usuario2.setUsername(usuario1.getUsername());

    assertThatThrownBy(() -> usuarioRepository.save(usuario2)).isInstanceOf(Exception.class);
  }

  @Test
  void findUsuario_ById_ReturnsUsuario() {
    UserSystem usuario = generateFakeUsuario();
    UserSystem persistedUsuario = testEntityManager.persistFlushFind(usuario);

    Optional<UserSystem> foundUsuario = usuarioRepository.findById(persistedUsuario.getId());

    assertThat(foundUsuario).isNotEmpty();
    assertThat(foundUsuario.get().getId()).isEqualTo(persistedUsuario.getId());
  }

  @Test
  void findUsuario_ByUsername_ReturnsUsuario() {
    UserSystem usuario = generateFakeUsuario();
    UserSystem persistedUsuario = testEntityManager.persistFlushFind(usuario);

    Optional<UserSystem> foundUsuario = usuarioRepository.findByUsername(persistedUsuario.getUsername());

    assertThat(foundUsuario).isNotEmpty();
    assertThat(foundUsuario.get().getUsername()).isEqualTo(persistedUsuario.getUsername());
  }

  @Test
  void listUsuarios_ReturnsAllUsuarios() {
    UserSystem usuario1 = generateFakeUsuario();
    UserSystem usuario2 = generateFakeUsuario();
    testEntityManager.persistFlushFind(usuario1);
    testEntityManager.persistFlushFind(usuario2);

    List<UserSystem> usuarios = usuarioRepository.findAll();

    assertThat(usuarios).hasSizeGreaterThanOrEqualTo(2);
  }

  @Test
  void deleteUsuario_WithExistingId_RemovesUsuario() {
    UserSystem usuario = generateFakeUsuario();
    UserSystem persistedUsuario = testEntityManager.persistFlushFind(usuario);

    usuarioRepository.deleteById(persistedUsuario.getId());

    UserSystem deletedUsuario = testEntityManager.find(UserSystem.class, persistedUsuario.getId());
    assertThat(deletedUsuario).isNull();
  }

}
