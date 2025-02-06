package com.swprojects.generalsales.entities;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "tb_product")
public class Product extends AbstractEntity {

  @Column(unique = true)
  private String name;
  private String description;
  private Double price;
  private String imgUrl;

  // Utilizada para a JPA não mapear a entidade!
  // @Transient

  @ManyToMany
  @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<Category> categories = new HashSet<>();

  @JsonIgnore
  @ManyToMany(mappedBy = "productsSold")
  private Set<Employee> employeesSoldBy = new LinkedHashSet<>();

  public Product(Long id, String name, String description, Double price, String imgUrl) {
    super(id);
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
  }
}