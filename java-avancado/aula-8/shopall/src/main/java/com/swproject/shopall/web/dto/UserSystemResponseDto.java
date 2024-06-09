package com.swproject.shopall.web.dto;

import com.swproject.shopall.entities.AbstractEntity;
import com.swproject.shopall.entities.UserSystem;
import com.swproject.shopall.entities.enums.PerfilTipo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSystemResponseDto extends AbstractEntity {

  private Long id;
  private String username;
  private String perfilTipo;

  public UserSystemResponseDto(UserSystem user, PerfilTipo tipo) {
    setId(user.getId());
    this.username = user.getUsername();
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
