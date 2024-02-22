package com.persistencia.pratica13.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Usuario extends AbstractEntity {

  @Column(name = "nome", nullable = false, unique = true, length = 100)
  private String nome;
  
  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "senha", nullable = false, length = 200)
  private String senha;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false, length = 25)
  private Role role = Role.ROLE_CLIENTE;

  public enum Role {
    ROLE_ADMIN, ROLE_CLIENTE
  }

}