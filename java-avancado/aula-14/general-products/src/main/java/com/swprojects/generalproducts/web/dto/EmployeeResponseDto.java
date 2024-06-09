package com.swprojects.generalproducts.web.dto;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import com.swprojects.generalproducts.entities.AbstractEntity;
import com.swprojects.generalproducts.entities.Employee;

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
  private Instant birthDate;
  private Boolean isActive;
  @Temporal(TemporalType.DATE)
  private Date startDate;
  private Integer experienceYears;
  private UserSystemResponseDto usuario;
  private Set<ProductResponseDto> productsSold;

  public EmployeeResponseDto(Employee employee) {
    setId(employee.getId());
    this.name = employee.getName();
    this.birthDate = employee.getBirthDate();
    this.isActive = employee.getIsActive();
    this.startDate = employee.getStartDate();
    this.experienceYears = employee.getExperienceYears();
  }

  public EmployeeResponseDto(Employee employee, UserSystemResponseDto usuario, Set<ProductResponseDto> productsSold) {
    setId(employee.getId());
    this.name = employee.getName();
    this.birthDate = employee.getBirthDate();
    this.isActive = employee.getIsActive();
    this.startDate = employee.getStartDate();
    this.experienceYears = employee.getExperienceYears();
    this.usuario = usuario;
    this.productsSold = productsSold;
  }

}
