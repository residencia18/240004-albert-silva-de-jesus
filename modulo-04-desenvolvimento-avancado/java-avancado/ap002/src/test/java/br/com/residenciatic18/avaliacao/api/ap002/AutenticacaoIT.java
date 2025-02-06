package br.com.residenciatic18.avaliacao.api.ap002;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.residenciatic18.avaliacao.api.ap002.jwt.JwtToken;
import br.com.residenciatic18.avaliacao.api.ap002.web.dto.UserSystemLoginDto;
import br.com.residenciatic18.avaliacao.api.ap002.web.exceptions.ErrorMessage;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/usuarios/usuarios-insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/usuarios/usuarios-delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class AutenticacaoIT {

  @Autowired
  WebTestClient testClient;

  @Test
  public void autenticar_ComCredenciaisValidas_RetornarTokenComStatus200() {
    JwtToken responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("20191tadssaj0026@ifba.edu.br", "JAVA!@#ResTIc18"))
        .exchange()
        .expectStatus().isOk()
        .expectBody(JwtToken.class)
        .returnResult().getResponseBody();
    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
  }

  @Test
  public void autenticar_ComCredenciaisInvalidas_RetornarErrorMessageStatus400() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("invalido@email.com", "JAVA!@#ResTIc18"))
        .exchange()
        .expectStatus().isBadRequest()
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(400);

    responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("invalido@email.com", "JAVA!@#ResTIc18"))
        .exchange()
        .expectStatus().isBadRequest()
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(400);
  }

  @Test
  public void autenticar_ComUsernameInvalido_RetornarErrorMessageStatus422() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("aaa", "JAVA!@#ResTIc18"))
        .exchange()
        .expectStatus().isEqualTo(402)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(402);

    responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("@email.com", "JAVA!@#ResTIc18"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

  @Test
  public void autenticar_ComPasswordInvalido_RetornarErrorMessageStatus422() {
    ErrorMessage responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("ana@email.com", "JAVA!@#ResT"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("ana@email.com", "ResTIc1"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    responseBody = testClient
        .post()
        .uri("/api/v1/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(new UserSystemLoginDto("ana@email.com", "JAVA!@#ResTIc18dhdyf5"))
        .exchange()
        .expectStatus().isEqualTo(422)
        .expectBody(ErrorMessage.class)
        .returnResult().getResponseBody();

    org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    org.assertj.core.api.Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);
  }

}
