package com.swproject.buyeverything.web.dto.form;

import java.util.List;

import com.swproject.buyeverything.entities.Employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UsuarioForm {

  @NotBlank
  @Email(message = "formato do e-mail está invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
  private String username;

  @NotBlank
  @Size(min = 6, max = 6)
  private String password;
  private List<Employee> employees;

  public UsuarioForm(String username, String password) {
    this.username = username;
    this.password = password;
  }

}
