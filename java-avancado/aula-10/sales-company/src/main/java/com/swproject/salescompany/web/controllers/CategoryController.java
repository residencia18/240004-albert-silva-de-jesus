package com.swproject.salescompany.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swproject.salescompany.entities.Category;
import com.swproject.salescompany.services.CategoryService;
import com.swproject.salescompany.web.dto.CategoryResponseDto;
import com.swproject.salescompany.web.dto.form.CategoryForm;
import com.swproject.salescompany.web.dto.mapper.CategoryMapper;
import com.swproject.salescompany.web.exceptions.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Categorys", description = "Contém todas as operações aos recursos para cadastro, edição e leitura de um categoria.")
@RequiredArgsConstructor
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

  @Operation(summary = "Recuperar um category pelo id", description = "Recurso para recuperar um category pelo id.", responses = {
      @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/{id}")
  public ResponseEntity<CategoryResponseDto> getById(@PathVariable @NonNull Long id) {
    Category category = categoryService.findById(id);
    return ResponseEntity.ok(CategoryMapper.toDto(category));
  }

  @GetMapping("/")
  public ResponseEntity<List<CategoryResponseDto>> getAll() {
    List<CategoryResponseDto> categories = CategoryMapper.toListDto(categoryService.findAll());
    return ResponseEntity.ok().body(categories);
  }
}
