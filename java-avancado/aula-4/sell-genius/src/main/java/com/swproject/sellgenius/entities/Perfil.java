package com.swproject.sellgenius.entities;

import com.swproject.sellgenius.entities.enums.PerfilTipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_perfis")
public class Perfil extends AbstractEntity {

  @Column(name = "descricao", nullable = false, unique = true)
  private String desc;

  public Perfil(Long id) {
    super.setId(id);
  }

  public Perfil(String desc) {
    this.desc = desc;
  }

}
