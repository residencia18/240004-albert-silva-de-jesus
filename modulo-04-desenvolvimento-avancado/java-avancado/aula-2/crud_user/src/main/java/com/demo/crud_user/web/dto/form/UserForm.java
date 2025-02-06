package com.demo.crud_user.web.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserForm {
  
  private String name;
  private String email;
  private String cpf;
  private String phone;
  private String password;

}
