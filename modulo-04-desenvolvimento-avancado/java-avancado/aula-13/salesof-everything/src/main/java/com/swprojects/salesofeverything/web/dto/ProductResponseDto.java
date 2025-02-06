package com.swprojects.salesofeverything.web.dto;

import java.util.Set;

import com.swprojects.salesofeverything.entities.AbstractEntity;
import com.swprojects.salesofeverything.entities.Category;
import com.swprojects.salesofeverything.entities.Product;

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
public class ProductResponseDto extends AbstractEntity{

  private Long id;
  private String name;
  private String description;
  private Double price;
  private String imgUrl;
  private Set<Category> categories;

  public ProductResponseDto(Product product) {
    setId(product.getId());
    this.name = product.getName();
    this.description = product.getDescription();
    this.price = product.getPrice();
    this.imgUrl = product.getImgUrl();
    this.categories = product.getCategories();
  }

}
