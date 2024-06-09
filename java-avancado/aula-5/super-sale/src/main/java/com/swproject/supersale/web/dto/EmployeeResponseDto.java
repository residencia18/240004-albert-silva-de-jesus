package com.swproject.supersale.web.dto;

import java.time.Instant;

import com.swproject.supersale.entities.Employee;
import com.swproject.supersale.entities.UserSystem;

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

  public EmployeeResponseDto(Employee employee, UserSystem usuario) {
    setId(id);
    this.name = employee.getName();
    this.birthDate = employee.getBirthDate();
    
  }
}
