package com.swproject.tradein.web.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swproject.tradein.entities.Category;
import com.swproject.tradein.services.CategoryService;
import com.swproject.tradein.web.dto.CategoryResponseDto;
import com.swproject.tradein.web.dto.form.CategoryForm;
import com.swproject.tradein.web.dto.mapper.CategoryMapper;

@RestController
@RequestMapping("api/v1/categorys")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping
  public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryForm createDto) {
    Category category = categoryService.save(CategoryMapper.toCategory(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
    return ResponseEntity.created(uri).body(CategoryMapper.toDto(category));
  }
}
