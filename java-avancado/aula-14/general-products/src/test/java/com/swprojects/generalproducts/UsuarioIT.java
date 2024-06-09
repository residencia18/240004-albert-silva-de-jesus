package com.swprojects.generalproducts;

import com.swprojects.generalproducts.web.dto.UserSystemResponseDto;
import com.swprojects.generalproducts.web.dto.UserSystemSenhaDto;
import com.swprojects.generalproducts.web.dto.form.UserSystemForm;
import com.swprojects.generalproducts.web.exceptions.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/usuarios/usuarios-insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
// @Sql(scripts = "/sql/usuarios/usuarios-delete.sql", executionPhase =
// Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UsuarioIT {

  @Autowired
  WebTestClient testClient;

  @Test
  public void _createUsuario_ComUsernameEPasswordValidos_RetornarUsuarioCriadoComStaus201() {
    UserSystemResponseDto responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemForm("tody@email.com", "123456"))
        .exchange()
        .expectStatus().isCreated()
        .expectBody(UserSystemResponseDto.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getUsername()).isEqualTo("tody@email.com");
    org.assertj.core.api.Assertions.assertThat(responseBody.getRole()).isEqualTo("COMUM");
  }

  @Test
  public void _createUsuario_ComUsernameInvalido_RetornarErrorMessageStatus422() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemForm("", "123456"))
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
        .bodyValue(new UserSystemForm("tody@", "123456"))
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
        .bodyValue(new UserSystemForm("tody@email", "123456"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

  @Test
  public void _createUsuario_ComPasswordInvalido_RetornarErrorMessageStatus422() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemForm("tody@gmail.com", ""))
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
        .bodyValue(new UserSystemForm("tody@gmail.com", "123"))
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
        .bodyValue(new UserSystemForm("tody@gmail.com", "1234567"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

  @Test
  public void _createUsuario_ComUsernameRepetido_RetornarUsuarioCriadoComStaus409() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/usuarios")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemForm("ana@email.com", "123456"))
        .exchange()
        .expectStatus().isEqualTo(409)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(409);
  }

  @Test
  public void buscarUsuario_ComIdExistente_RetornarUsuarioComStatus200() {
    UserSystemResponseDto responseBody = testClient
        .get()
        .uri("/api/v1/usuarios/100")
        .exchange()
        .expectStatus().isOk()
        .expectBody(UserSystemResponseDto.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isEqualTo(100);
    org.assertj.core.api.Assertions.assertThat(responseBody.getUsername()).isEqualTo("ana@email.com");
    org.assertj.core.api.Assertions.assertThat(responseBody.getRole()).isEqualTo("ADMIN");
  }

  @Test
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

  @Test
  public void editarSenha_ComDadosValidos_RetornarStatus204() {
    testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemSenhaDto("123456", "123456", "123456"))
        .exchange()
        .expectStatus().isNoContent();
  }

  @Test
  public void editarSenha_ComCamposInvalidos_RetornarErrorMessageComStatus422() {
    ErrorMessage responseBody = testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemSenhaDto("", "", ""))
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
        .bodyValue(new UserSystemSenhaDto("12345", "12345", "12345"))
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
        .bodyValue(new UserSystemSenhaDto("12345678", "12345678", "12345678"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

  @Test
  public void editarSenha_ComSenhaInvalidas_RetornarErrorMessageComStatus400() {
    ErrorMessage responseBody = testClient
        .patch()
        .uri("/api/v1/usuarios/100")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemSenhaDto("123456", "123456", "000000"))
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
        .bodyValue(new UserSystemSenhaDto("000000", "123456", "123456"))
        .exchange()
        .expectStatus().isEqualTo(400)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(400);
  }

  @Test
  public void listarUsuarios_SemQualquerParametro_RetornarListaDeUsuariosComStatus200() {
    List<UserSystemResponseDto> responseBody = testClient
        .get()
        .uri("/api/v1/usuarios/")
        .exchange()
        .expectStatus().isOk()
        .expectBodyList(UserSystemResponseDto.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.size()).isEqualTo(23);
  }
}
