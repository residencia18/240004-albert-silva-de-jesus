package com.swproject.sellgenius.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.swproject.sellgenius.entities.enums.PerfilTipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class UserSystem extends AbstractEntity {

  @Column(name = "username", nullable = false, unique = true, length = 100)
  private String username;
  @Column(name = "password", nullable = false, length = 200)
  private String password;
  private String perfilTipo;

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

  public UserSystem(Long id, String username, String password) {
    super(id);
    this.username = username;
    this.password = password;
  }

  public UserSystem(Long id, String username, String password, PerfilTipo tipo) {
    this.username = username;
    this.password = password;
    setPerfilTipo(tipo);
  }

  public PerfilTipo getPerfilTipo() {
    return PerfilTipo.fromString(perfilTipo);
  }

  public void setPerfilTipo(PerfilTipo perfilTipo) {
    if (perfilTipo != null) {
      this.perfilTipo = perfilTipo.getCodigo();
    }
  }

}
