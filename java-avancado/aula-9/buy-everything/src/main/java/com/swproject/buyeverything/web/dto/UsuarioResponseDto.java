package com.swproject.buyeverything.web.dto;

import com.swproject.buyeverything.entities.AbstractEntity;
import com.swproject.buyeverything.entities.Usuario;
import com.swproject.buyeverything.entities.enums.PerfilTipo;

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
public class UsuarioResponseDto extends AbstractEntity {

  private Long id;
  private String username;
  private String perfilTipo;

  public UsuarioResponseDto(Usuario user, PerfilTipo tipo) {
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
