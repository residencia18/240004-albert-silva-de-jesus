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
import com.swproject.buyeverything.entities.Usuario;
import com.swproject.buyeverything.entities.enums.PerfilTipo;
import com.swproject.buyeverything.repositories.UsuarioRepository;
import com.swproject.buyeverything.services.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

  @Mock
  private UsuarioRepository usuarioRepository;

  @InjectMocks
  private UsuarioService usuarioService;

  private Usuario usuario;
  private Faker faker;

  @BeforeEach
  void setUp() {
    faker = new Faker(new Locale("en-US"));
    // Gerando dados fictícios com o FAKER
    usuario = new Usuario();
    usuario.setId(1L); // Garantindo um ID para os testes de update
    usuario.setUsername(faker.internet().emailAddress());
    usuario.setPassword(faker.number().digits(6));
    usuario.setPerfilTipo(PerfilTipo.ADMIN);
  }

  @Test
  void testCreateFakeUsuario() {
    // Configura o Mockito para retornar o mesmo funcionario quando o repositório
    // salvar qualquer funcionario
    given(usuarioRepository.save(any(Usuario.class))).willReturn(usuario);

    // Ação:
    Usuario savedusuario = usuarioService.save(usuario);

    // Assert
    // Verifica se o método save do repositório foi chamado
    verify(usuarioRepository).save(any(Usuario.class));

    // verifica as propriedades do funcionario retornado para assegurar que elas
    // correspondem ao esperado
    assertNotNull(savedusuario, "O usuário salvo não deve ser nulo");
    assertEquals(usuario.getUsername(), savedusuario.getUsername(),
        "O email do usuário não corresponde ao esperado");
    assertEquals(usuario.getPassword(), savedusuario.getPassword(),
        "A senha do usuário não corresponde ao esperado");
    assertEquals(usuario.getPerfilTipo(), savedusuario.getPerfilTipo(),
        "O perfil do usuário não corresponde ao esperado");
  }
}
