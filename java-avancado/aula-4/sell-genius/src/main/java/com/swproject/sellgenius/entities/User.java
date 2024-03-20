package com.swproject.sellgenius.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.swproject.sellgenius.entities.enums.PerfilTipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class User extends AbstractEntity {

  @Column(name = "username", nullable = false, unique = true, length = 100)
  private String username;
  @Column(name = "password", nullable = false, length = 200)
  private String password;
  @OneToMany(mappedBy = "usuario")
  private List<Employee> employees = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "usuarios_tem_perfis", joinColumns = {
      @JoinColumn(name = "usuario_id", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "perfil_id", referencedColumnName = "id") })
  private List<Perfil> perfis;

  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;
  @Column(name = "data_modificacao")
  private LocalDateTime dataModificacao;
  @Column(name = "criado_por")
  private String criadorPor;
  @Column(name = "modificado_por")
  private String modificadoPor;

  public User(Long id, String username, String password) {
    super(id);
    this.username = username;
    this.password = password;
  }

  public User(String username, String password, PerfilTipo tipo) {
    this.username = username;
    this.password = password;
    addPerfil(PerfilTipo.valueOf((int) tipo.getCod()));
  }

  // adiciona perfis a lista
  public void addPerfil(PerfilTipo tipo) {
    if (this.perfis == null) {
      this.perfis = new ArrayList<>();
    }
    this.perfis.add(new Perfil(tipo.getCod()));
  }

  public List<Perfil> getPerfis() {
    return perfis;
  }

  public void setPerfis(List<Perfil> perfis) {
    this.perfis = perfis;
  }

}
