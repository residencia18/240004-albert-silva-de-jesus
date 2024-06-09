package com.swprojets.productsales.web.dto;

import com.swprojets.productsales.entities.AbstractEntity;
import com.swprojets.productsales.entities.UserSystem;
import com.swprojets.productsales.entities.UserSystem.Role;

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
public class UserSystemResponseDto extends AbstractEntity{

  private Long id;
  private String username;
  private String role;

  public UserSystemResponseDto(UserSystem user, Role tipo) {
    setId(user.getId());
    this.username = user.getUsername();
    this.role = tipo.toString();
  }

}
