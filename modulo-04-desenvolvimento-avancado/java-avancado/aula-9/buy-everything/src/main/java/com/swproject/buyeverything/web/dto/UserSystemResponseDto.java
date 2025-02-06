package com.swproject.buyeverything.web.dto;

import com.swproject.buyeverything.entities.UserSystem;
import com.swproject.buyeverything.entities.UserSystem.Role;

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
public class UserSystemResponseDto {

  private Long id;
  private String username;
  private String role;

  public UserSystemResponseDto(UserSystem user, Role tipo) {
    setId(user.getId());
    this.username = user.getUsername();
    this.role = tipo.toString();
  }

}
