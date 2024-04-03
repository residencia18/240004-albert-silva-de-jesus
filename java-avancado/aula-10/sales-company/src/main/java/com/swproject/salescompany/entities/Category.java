package com.swproject.salescompany.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tb_category")  
public class Category extends AbstractEntity{
  
  private String name;

  // Utilizada para a JPA não mapear a entidade!
  // @Transient

  @JsonIgnore
  @ManyToMany(mappedBy = "categories")
  private Set<Product> products = new HashSet<>();

  public Category(Long id, String name) {
    super(id);
    this.name = name;
  }
}
