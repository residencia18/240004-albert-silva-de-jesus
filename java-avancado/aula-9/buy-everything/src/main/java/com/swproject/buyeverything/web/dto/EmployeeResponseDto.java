package com.swproject.buyeverything.web.dto;

import java.time.Instant;

import com.swproject.buyeverything.entities.Employee;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

  private Long id;
  private String name;
  @Column(unique = true)
  private Instant birthDate;
  private UsuarioResponseDto usuario;

  public EmployeeResponseDto(Employee employee, UsuarioResponseDto usuario) {
    setId(id);
    this.name = employee.getName();
    this.birthDate = employee.getBirthDate();
    this.usuario = usuario;
  }
}
