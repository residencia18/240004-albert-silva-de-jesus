package com.swproject.shopall.web.dto.form;

import java.util.List;

import com.swproject.shopall.entities.Employee;
import com.swproject.shopall.entities.enums.PerfilTipo;

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
public class UserSystemForm {

  @NotBlank
  @Email(message = "formato do e-mail está invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
  private String username;

  @NotBlank
  @Size(min = 6, max = 6)
  private String password;
  private String perfilTipo;
  private List<Employee> employees;

  public PerfilTipo getPerfilTipo() {
    return PerfilTipo.fromString(perfilTipo);
  }

  public void setPerfilTipo(PerfilTipo perfilTipo) {
    if (perfilTipo != null) {
      this.perfilTipo = perfilTipo.getCodigo();
    }
  }

}
