package com.swproject.sellgenius.web.dto;

import com.swproject.sellgenius.entities.AbstractEntity;
import com.swproject.sellgenius.entities.User;

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

  public UserResponseDto(User user) {
    setId(user.getId());
    this.username = user.getUsername();
  }
}
