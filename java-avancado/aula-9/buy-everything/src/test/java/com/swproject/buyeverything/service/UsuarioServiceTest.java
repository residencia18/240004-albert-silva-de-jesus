package com.swproject.buyeverything.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.github.javafaker.Faker;
import com.swproject.buyeverything.entities.Usuario;
import com.swproject.buyeverything.repositories.UsuarioRepository;
import com.swproject.buyeverything.services.UsuarioService;
import com.swproject.buyeverything.web.dto.UsuarioResponseDto;
import com.swproject.buyeverything.web.dto.UsuarioSenhaDto;
import com.swproject.buyeverything.web.dto.form.UsuarioForm;
import com.swproject.buyeverything.web.exceptions.ErrorMessage;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

  public static final Logger log = LoggerFactory.getLogger(UsuarioServiceTest.class);

  @Mock
  private UsuarioRepository usuarioRepository;

  @InjectMocks
  private UsuarioService usuarioService;

  @Autowired
  WebTestClient testClient;

  private Usuario usuario;
  private Faker faker;

  @BeforeEach // Atribui valores fictícios utilizando o Faker para o usuário antes de cada teste
  void setUp() {
    faker = new Faker(new Locale("en-US"));
    // Gerando dados fictícios com o FAKER
    usuario = new Usuario();
    usuario.setId(1L); // Garantindo um ID para os testes de update
    usuario.setUsername(faker.internet().emailAddress());
    usuario.setPassword(faker.number().digits(6));
    usuario.setRole(usuario.getRole().ROLE_COMUM);
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna o status 201 (CREATED) quando o usuário é criado com sucesso.
  void _createUsuario_ComUsernameEPasswordValidos_RetornarUsuarioCriadoComStaus201() {
    // Configura o Mockito para retornar o mesmo usuário quando o repositório salvar
    // qualquer usuário for chamado
    given(usuarioRepository.save(any(Usuario.class))).willReturn(usuario);

    // Ação: Salva o usuário no banco de dados e retorna o usuário salvo (com o ID
    // preenchido) para savedusuario.
    Usuario savedusuario = usuarioService.save(usuario);

    // Assert Verifica se o método save do repositório foi chamado
    verify(usuarioRepository).save(any(Usuario.class));

    // verifica as propriedades do funcionario retornado para assegurar que elas
    // correspondem ao esperado
    assertNotNull(savedusuario, "O usuário salvo não deve ser nulo");
    assertEquals(usuario.getUsername(), savedusuario.getUsername(),
        "O email do usuário não corresponde ao esperado");
    assertEquals(usuario.getPassword(), savedusuario.getPassword(),
        "A senha do usuário não corresponde ao esperado");
    assertEquals(usuario.getRole(), savedusuario.getRole(),
        "O perfil do usuário não corresponde ao esperado");
  }

  @Test // Outra forma de testar o método save do serviço de usuário, com WebTestClient
        // retornando um response body com o
  // usuário criado e status 201 (CREATED)
  public void createUsuario_ComUsernameEPasswordValidos_RetornarUsuarioCriadoComStaus201() {
    UsuarioResponseDto responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("tody@email.com", "123456"))
        .exchange()
        .expectStatus().isCreated()
        .expectBody(UsuarioResponseDto.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getUsername()).isEqualTo("tody@email.com");
    org.assertj.core.api.Assertions.assertThat(responseBody.getRole()).isEqualTo("COMUM");
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 422 (UNPROCESSABLE_ENTITY) quando o 
  // username é inválido (nulo ou vazio) ou não é um email válido.
  public void _createUsuario_ComUsernameInvalido_RetornarErrorMessageStatus422() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("", "123456"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("tody@", "123456"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("tody@email", "123456"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

  @Test // Outra forma de testar se o método save do serviço de usuário retorna um erro 422 (UNPROCESSABLE_ENTITY) 
  //quando a senha é inválida (nula, vazia ou menor que 6 caracteres).
  public void createUsuario_ComUsernameInvalido_RetornarErrorMessageStatus422() {
    // Simulando chamadas inválidas com emails inválidos
    String[] invalidEmails = { "", "tody@", "tody@email" };

    for (String invalidEmail : invalidEmails) {
      ErrorMessage responseBody = testClient
          .post()
          .uri("/api/v1/usuarios")
          .contentType(MediaType.APPLICATION_JSON)
          .bodyValue(new Usuario(null, invalidEmail, "123456"))
          .exchange()
          .expectStatus().isEqualTo(422)
          .expectBody(ErrorMessage.class)
          .returnResult().getResponseBody();

      assertNotNull(responseBody);
      assertEquals(422, responseBody.getStatus());
    }
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 422 (UNPROCESSABLE_ENTITY)
  // quando a senha é inválida (nula, vazia ou menor que 6 caracteres).
  public void _createUsuario_ComPasswordInvalido_RetornarErrorMessageStatus422() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("tody@gmail.com", ""))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("tody@gmail.com", "123"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("tody@gmail.com", "1234567"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 409 (CONFLICT) quando o username já existe.
  public void _createUsuario_ComUsernameRepetido_RetornarUsuarioCriadoComStaus409() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioForm("ana@email.com", "123456"))
        .exchange()
        .expectStatus().isEqualTo(409)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(409);
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 200 (OK) quando o usuário é atualizado com sucesso.
  public void buscarUsuario_ComIdExistente_RetornarUsuarioComStatus200() {
    UsuarioResponseDto responseBody = testClient
        .get()
        .uri("/api/v1/usuarios/100")
        .exchange()
        .expectStatus().isOk()
        .expectBody(UsuarioResponseDto.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isEqualTo(100);
    org.assertj.core.api.Assertions.assertThat(responseBody.getUsername()).isEqualTo("ana@email.com");
    org.assertj.core.api.Assertions.assertThat(responseBody.getRole()).isEqualTo("ADMIN");
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 404 (NOT_FOUND) quando o usuário não existe.
  public void buscarUsuario_ComIdInexistente_RetornarUsuarioComStatus404() {
    ErrorMessage responseBody = testClient
        .get()
        .uri("/api/v1/usuarios/0")
        .exchange()
        .expectStatus().isNotFound()
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(404);
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 204 (NO_CONTENT) quando o usuário 
  // é atualizado com sucesso.
  public void editarSenha_ComDadosValidos_RetornarStatus204() {
    testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioSenhaDto("123456", "123456", "123456"))
        .exchange()
        .expectStatus().isNoContent();
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 422 (UNPROCESSABLE_ENTITY) quando os 
  // campos são inválidos.
  public void editarSenha_ComCamposInvalidos_RetornarErrorMessageComStatus422() {
    ErrorMessage responseBody = testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioSenhaDto("", "", ""))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioSenhaDto("12345", "12345", "12345"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioSenhaDto("12345678", "12345678", "12345678"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 400 (BAD_REQUEST) quando as senhas são inválidas.
  public void editarSenha_ComSenhaInvalidas_RetornarErrorMessageComStatus400() {
    ErrorMessage responseBody = testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioSenhaDto("123456", "123456", "000000"))
        .exchange()
        .expectStatus().isEqualTo(400)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(400);

    responseBody = testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UsuarioSenhaDto("000000", "123456", "123456"))
        .exchange()
        .expectStatus().isEqualTo(400)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(400);
  }

  @Test // Teste para verificar se o método save do serviço de usuário retorna um erro 200 (OK) quando o usuário é listado com sucesso.
  public void listarUsuarios_SemQualquerParametro_RetornarListaDeUsuariosComStatus200() {
    List<UsuarioResponseDto> responseBody = testClient
        .get()
        .uri("/api/v1/usuarios")
        .exchange()
        .expectStatus().isOk()
        .expectBodyList(UsuarioResponseDto.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.size()).isEqualTo(3);
  }

}
