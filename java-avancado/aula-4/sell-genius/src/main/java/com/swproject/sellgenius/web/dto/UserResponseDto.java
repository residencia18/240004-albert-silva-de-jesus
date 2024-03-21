package com.swproject.sellgenius.web.dto;

import com.swproject.sellgenius.entities.AbstractEntity;
import com.swproject.sellgenius.entities.Usuario;
import com.swproject.sellgenius.entities.enums.PerfilTipo;

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
public class UserResponseDto extends AbstractEntity {

  private Long id;
  private String username;
  private String perfilTipo;

  public UserResponseDto(Usuario user, PerfilTipo tipo) {
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
