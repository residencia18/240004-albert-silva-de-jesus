package com.swproject.tradein.web.dto.form;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swproject.tradein.entities.Product;

import jakarta.persistence.ManyToMany;
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
public class CategoryForm {
    
  private String name;
  private Set<Product> products;

  public CategoryForm(String name) {
    this.name = name;
    this.products = new HashSet<>();
  }

}
