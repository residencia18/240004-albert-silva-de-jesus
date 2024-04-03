package com.swproject.salescompany.web.dto;

import com.swproject.salescompany.entities.Usuario;
import com.swproject.salescompany.entities.Usuario.Role;

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
public class UsuarioResponseDto {

  private Long id;
  private String username;
  private String role;

  public UsuarioResponseDto(Usuario user, Role tipo) {
    setId(user.getId());
    this.username = user.getUsername();
    this.role = tipo.toString();
  }

}
