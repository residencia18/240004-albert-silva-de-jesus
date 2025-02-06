package com.swproject.salescompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.salescompany.entities.Category;
import com.swproject.salescompany.exception.EntityNotFoundException;
import com.swproject.salescompany.repositories.CategoryRepository;
import com.swproject.salescompany.web.dto.form.CategoryForm;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category create(@Nullable Category category) {

    if (category == null) {
      throw new IllegalArgumentException("O parâmetro 'category' não pode ser nulo.");
    }

    return categoryRepository.save(category);
  }

  @Transactional(readOnly = true)
  public Optional<Category> findById(@NonNull Long id) {
    return Optional.ofNullable(categoryRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Category id=%s não encontrado", id))));
  }

  public Optional<Category> update(@NonNull Long id, CategoryForm categoryForm) {
    return findById(id).map(category -> {
      category.setName(categoryForm.getName());
      return categoryRepository.save(category);
    });
  }

  @Transactional(readOnly = true)
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public void delete(@NonNull Long id) {
    categoryRepository.deleteById(id);
  }
}
