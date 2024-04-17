package com.swprojects.generalproducts.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swprojects.generalproducts.entities.Category;
import com.swprojects.generalproducts.services.CategoryService;
import com.swprojects.generalproducts.web.dto.CategoryResponseDto;
import com.swprojects.generalproducts.web.dto.form.CategoryForm;
import com.swprojects.generalproducts.web.dto.mapper.CategoryMapper;
import com.swprojects.generalproducts.web.exceptions.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Categorys", description = "Contém todas as operações aos recursos para cadastro, edição e leitura de um categoria.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categorys")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @Operation(summary = "Cria uma nova categoria", description = "Recurso para criar uma nova categoria no sistema.", responses = {
      @ApiResponse(responseCode = "201", description = "categoria criada com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))),
      @ApiResponse(responseCode = "409", description = "categoria nome já cadastrado no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "422", description = "Recursos não processados por dados de entrada invalidos.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
  })
  @PostMapping
  public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryForm createDto) {
    Category category = categoryService.create(CategoryMapper.toCategory(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
    return ResponseEntity.created(uri).body(CategoryMapper.toDto(category));
  }

  @Operation(summary = "Recuperar uma categoria pelo id", description = "Recurso para recuperar um categoria pelo id.", responses = {
      @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/{id}")
  public ResponseEntity<CategoryResponseDto> getById(@PathVariable @NonNull Long id) {
    return categoryService.findById(id)
        .map(category -> ResponseEntity.ok().body(CategoryMapper.toDto(category)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Operation(summary = "Listar todas as categorias", description = "Listar todas as categorias cadastradas", responses = {
      @ApiResponse(responseCode = "200", description = "Lista com todas as categorias cadastradas", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoryResponseDto.class))))
  })
  @GetMapping("/")
  public ResponseEntity<List<CategoryResponseDto>> getAll() {
    List<CategoryResponseDto> categories = CategoryMapper.toListDto(categoryService.findAll());
    return ResponseEntity.ok().body(categories);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoryResponseDto> update(@PathVariable @NonNull Long id,
      @RequestBody CategoryForm createDto) {
    return categoryService.update(id, createDto)
        .map(category -> ResponseEntity.ok(CategoryMapper.toDto(category)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
    categoryService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
