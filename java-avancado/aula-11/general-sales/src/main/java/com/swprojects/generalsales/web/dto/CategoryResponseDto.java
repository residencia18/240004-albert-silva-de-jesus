package com.swprojects.generalsales.web.dto;

import com.swprojects.generalsales.entities.AbstractEntity;
import com.swprojects.generalsales.entities.Category;

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
public class CategoryResponseDto extends AbstractEntity{

  private Long id;
  private String name;

  public CategoryResponseDto(String name, Category category) {
    setId(category.getId());
    this.name = category.getName();
  }
}
