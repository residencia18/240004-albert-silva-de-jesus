package com.swproject.salescompany.entities;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_employee")
public class Employee extends AbstractEntity {

  @NotEmpty(message = "O campo nome é obrigatório")
  private String name;

  @Column(unique = true)
  private String cpf;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant birthDate;

  @Column(nullable = false)
  private Boolean isActive;

  @Temporal(TemporalType.DATE)
  private Date startDate; // data de início do empregado

  @Column(nullable = false)
  private Integer experienceYears; // anos de experiência

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  @ManyToMany
  @JoinTable(name = "tb_employee_product", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private Set<Product> productsSold = new LinkedHashSet<>();

  public Employee(Long id, String name, String cpf, Instant birthDate, Usuario usuario) {
    super(id);
    this.name = name;
    this.cpf = cpf;
    this.birthDate = birthDate;
    this.usuario = usuario;
  }

  public Employee(String name, String cpf, Instant birthDate, Usuario usuario) {
    this.name = name;
    this.cpf = cpf;
    this.birthDate = birthDate;
    this.usuario = usuario;
  }

}
