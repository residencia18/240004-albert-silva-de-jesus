package com.swproject.sellgenius.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User extends AbstractEntity {

  @Column(name = "username", nullable = false, unique = true, length = 100)
  private String username;
  @Column(name = "password", nullable = false, length = 200)
  private String password;
  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false, length = 25)
  private Role role = Role.ROLE_USUARIO;

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

  public User(Long id, String username, String password, Role role) {
    super(id);
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public enum Role {
    ROLE_ADMIN, ROLE_USUARIO
  }

}
