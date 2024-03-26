package com.swproject.sellgenius.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.swproject.sellgenius.entities.Category;
import com.swproject.sellgenius.repositories.CategoryRepository;

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
