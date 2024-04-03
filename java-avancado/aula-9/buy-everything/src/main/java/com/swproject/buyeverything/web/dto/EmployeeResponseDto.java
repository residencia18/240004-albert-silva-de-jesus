package com.swproject.buyeverything.web.dto;

import java.time.Instant;

import com.swproject.buyeverything.entities.AbstractEntity;
import com.swproject.buyeverything.entities.Employee;

import jakarta.persistence.Column;
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
public class EmployeeResponseDto extends AbstractEntity {

  private String name;
  @Column(unique = true)
  private Instant birthDate;
  private UsuarioResponseDto usuario;

  public EmployeeResponseDto(Employee employee, UsuarioResponseDto usuario) {
    setId(employee.getId());
    this.name = employee.getName();
    this.birthDate = employee.getBirthDate();
    this.usuario = usuario;
  }
}
