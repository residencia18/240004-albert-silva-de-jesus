package com.swproject.buyeverything.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class Usuario extends AbstractEntity {

  @Column(name = "username", nullable = false, unique = true, length = 100)
  private String username;
  @Column(name = "password", nullable = false, length = 200)
  private String password;
  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false, length = 25)
  private Role role = Role.ROLE_COMUM;

  @OneToMany(mappedBy = "usuario")
  private List<Employee> employees = new ArrayList<>();

  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;
  @Column(name = "data_modificacao")
  private LocalDateTime dataModificacao;
  @Column(name = "criado_por")
  private String criadorPor;
  @Column(name = "modificado_por")
  private String modificadoPor;

  public Usuario(Long id, String username, String password) {
    super(id);
    this.username = username;
    this.password = password;
  }

  public Usuario(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public enum Role {
    ROLE_ADMIN, ROLE_COMUM
  }

}
