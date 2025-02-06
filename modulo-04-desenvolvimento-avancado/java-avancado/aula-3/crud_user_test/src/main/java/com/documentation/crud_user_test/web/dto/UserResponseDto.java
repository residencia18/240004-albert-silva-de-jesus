package com.documentation.crud_user_test.web.dto;

import com.documentation.crud_user_test.entities.AbstractEntity;
import com.documentation.crud_user_test.entities.User;

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
  private String name;
  private String email;
  private String phone;

  public UserResponseDto(User user) {
    setId(user.getId());
    this.name = user.getName();
    this.email = user.getEmail();
    this.phone = user.getPhone();
  }
}
