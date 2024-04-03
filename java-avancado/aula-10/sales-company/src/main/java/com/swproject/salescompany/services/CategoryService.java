package com.swproject.salescompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.salescompany.entities.Category;
import com.swproject.salescompany.exception.EntityNotFoundException;
import com.swproject.salescompany.repositories.CategoryRepository;


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

  @Transactional(readOnly = true)
  public Category findById(@NonNull Long id) {
    return categoryRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Category id=%s não encontrado", id)));
  }

  @Transactional(readOnly = true)
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }
}
