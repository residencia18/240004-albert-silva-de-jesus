package br.com.residenciatic18.avaliacao.api.ap002.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Email(message = "Formato do e-mail está inválido", regexp = "^[a-zA-Z0-9._%+-]+_?@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
  @Column(name = "username", nullable = false, unique = true)
  private String username;

  // @ValidPassword(minLength = 8, maxLength = 15)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false, length = 25)
  private Role role = Role.ROLE_CLIENTE;

  @CreatedDate
  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;

  @LastModifiedDate
  @Column(name = "data_modificacao")
  private LocalDateTime dataModificacao;

  @CreatedBy
  @Column(name = "criado_por")
  private String criadorPor;

  @LastModifiedBy
  @Column(name = "modificado_por")
  private String modificadoPor;

  @Column(name = "ativo", nullable = false, columnDefinition = "BOOLEAN")
  private boolean ativo;

  @Column(name = "codigo_verificador", length = 200)
  private String codigoVerificador;

  public boolean hasNotId() {
    return id == null;
  }

  public boolean hasId() {
    return id != null;
  }

  public enum Role {
    ROLE_ADMIN, ROLE_CLIENTE
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Usuario usuario = (Usuario) o;
    return Objects.equals(id, usuario.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Usuario{" + "id=" + id + '}';
  }
}
