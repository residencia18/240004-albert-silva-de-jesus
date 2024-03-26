package com.swproject.shopall.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.swproject.shopall.entities.Category;
import com.swproject.shopall.web.dto.CategoryResponseDto;
import com.swproject.shopall.web.dto.form.CategoryForm;

public class CategoryMapper {

  public static Category toCategory(CategoryForm createDto) {
    return new ModelMapper().map(createDto, Category.class);

  }

  public static CategoryResponseDto toDto(Category category) {
    PropertyMap<Category, CategoryResponseDto> props = new PropertyMap<Category, CategoryResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setName(source.getName());
        map().setProducts(source.getProducts());
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(category, CategoryResponseDto.class);
  }

  public static List<CategoryResponseDto> toListDto(List<Category> categorys) {
    return categorys.stream().map(category -> toDto(category)).collect(Collectors.toList());
  }
}
