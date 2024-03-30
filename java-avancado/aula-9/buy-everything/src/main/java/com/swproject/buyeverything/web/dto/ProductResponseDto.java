package com.swproject.buyeverything.web.dto;

import java.util.Set;

import com.swproject.buyeverything.entities.Category;
import com.swproject.buyeverything.entities.Product;

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
public class ProductResponseDto {

  private Long id;
  private String name;
  private String description;
  private Double price;
  private String imgUrl;
  private Set<Category> categories;

  public ProductResponseDto(Product product, String name, String description, Double price, String imgUrl,
      Set<Category> categories) {
    setId(product.getId());
    this.name = product.getName();
    this.description = product.getDescription();
    this.price = product.getPrice();
    this.imgUrl = product.getImgUrl();
    this.categories = product.getCategories();
  }

}
