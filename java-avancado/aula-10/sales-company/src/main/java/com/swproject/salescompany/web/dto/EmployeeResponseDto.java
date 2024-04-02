package com.swproject.salescompany.web.dto;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import com.swproject.salescompany.entities.AbstractEntity;
import com.swproject.salescompany.entities.Employee;
import com.swproject.salescompany.entities.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
  private Boolean isActive;
  @Temporal(TemporalType.DATE)
  private Date startDate;
  private Integer experienceYears;
  private UsuarioResponseDto usuario;
  private Set<Product> productsSold;

  public EmployeeResponseDto(Employee employee, UsuarioResponseDto usuario) {
    setId(employee.getId());
    this.name = employee.getName();
    this.birthDate = employee.getBirthDate();
    this.isActive = employee.getIsActive();
    this.startDate = employee.getStartDate();
    this.experienceYears = employee.getExperienceYears();
    this.usuario = usuario;
    this.productsSold = employee.getProductsSold();
  }
}
