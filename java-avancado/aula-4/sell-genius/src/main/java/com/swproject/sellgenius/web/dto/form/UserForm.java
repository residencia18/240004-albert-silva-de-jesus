package com.swproject.sellgenius.web.dto.form;

import com.swproject.sellgenius.entities.User.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserForm {
  
  private String username;
  private String password;
  private Role role = Role.ROLE_USUARIO;

}
