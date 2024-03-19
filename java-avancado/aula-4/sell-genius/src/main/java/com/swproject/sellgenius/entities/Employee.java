package com.swproject.sellgenius.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

  private String name;
  @Column(unique = true)
  private String cpf;
  // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  // private Instant birthDate;
  private Date birthDate;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private User usuario;

  public Employee(Long id, String name, String cpf, Date birthDate, User usuario) {
    super(id);
    this.name = name;
    this.cpf = cpf;
    this.birthDate = birthDate;
    this.usuario = usuario;
  }

}
