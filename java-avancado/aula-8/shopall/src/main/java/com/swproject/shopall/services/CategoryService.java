package com.swproject.shopall.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.swproject.shopall.entities.Category;
import com.swproject.shopall.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category save(@Nullable Category category) {

    if (category == null) {
      throw new IllegalArgumentException("O parâmetro 'category' não pode ser nulo.");
    }

    return categoryRepository.save(category);
  }
}
