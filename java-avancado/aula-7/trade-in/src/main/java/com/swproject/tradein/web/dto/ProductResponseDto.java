package com.swproject.tradein.web.dto;

import com.swproject.tradein.entities.AbstractEntity;

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
public class ProductResponseDto extends AbstractEntity {

  private String name;
  private String description;
  private Double price;
  private String imgUrl;

  public ProductResponseDto(Long id, String name, String description, Double price, String imgUrl) {
    super(id);
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
  }
}
