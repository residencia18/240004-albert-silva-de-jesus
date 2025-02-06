package com.swprojects.makrosales.web.controllers;

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

import com.swprojects.makrosales.entities.Product;
import com.swprojects.makrosales.services.ProductService;
import com.swprojects.makrosales.web.dto.CategoryResponseDto;
import com.swprojects.makrosales.web.dto.ProductResponseDto;
import com.swprojects.makrosales.web.dto.form.ProductForm;
import com.swprojects.makrosales.web.dto.mapper.ProductMapper;
import com.swprojects.makrosales.web.exceptions.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Products", description = "Contém todas as operações aos recursos para cadastro, edição e leitura de um produto.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Operation(summary = "Cria um novo produto", description = "Recurso para criar um novo produto no sistema.", responses = {
      @ApiResponse(responseCode = "201", description = "produto criado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class))),
      @ApiResponse(responseCode = "409", description = "produto nome já cadastrado no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "422", description = "Recursos não processados por dados de entrada invalidos.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @PostMapping
  public ResponseEntity<ProductResponseDto> create(@RequestBody ProductForm createDto) {
    Product product = productService.create(ProductMapper.toProduct(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
    return ResponseEntity.created(uri).body(ProductMapper.toDto(product));
  }

  @Operation(summary = "Recuperar um produto pelo id", description = "Recurso para recuperar um product pelo id.", responses = {
      @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/{id}")
  public ResponseEntity<ProductResponseDto> getById(@PathVariable @NonNull Long id) {
    return productService.findById(id)
        .map(product -> ResponseEntity.ok().body(ProductMapper.toDto(product)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Operation(summary = "Listar todos os produtos", description = "Listar todos os produtos cadastrados", responses = {
      @ApiResponse(responseCode = "200", description = "Lista com todos os produtos cadastrados", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductResponseDto.class))))
  })
  @GetMapping("/")
  public ResponseEntity<List<ProductResponseDto>> getAll() {
    List<ProductResponseDto> products = ProductMapper.toListDto(productService.findAll());
    return ResponseEntity.ok().body(products);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponseDto> update(@PathVariable @NonNull Long id, @RequestBody ProductForm createDto) {
    return productService.update(id, createDto)
        .map(product -> ResponseEntity.ok(ProductMapper.toDto(product)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
