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

import com.swproject.salescompany.entities.Product;
import com.swproject.salescompany.services.ProductService;
import com.swproject.salescompany.web.dto.CategoryResponseDto;
import com.swproject.salescompany.web.dto.ProductResponseDto;
import com.swproject.salescompany.web.dto.form.ProductForm;
import com.swproject.salescompany.web.dto.mapper.ProductMapper;
import com.swproject.salescompany.web.exceptions.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
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

  @PostMapping
  public ResponseEntity<ProductResponseDto> create(@RequestBody ProductForm createDto) {
    Product product = productService.save(ProductMapper.toProduct(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
    return ResponseEntity.created(uri).body(ProductMapper.toDto(product));
  }

  @Operation(summary = "Recuperar um product pelo id", description = "Recurso para recuperar um product pelo id.", responses = {
      @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/{id}")
  public ResponseEntity<ProductResponseDto> getById(@PathVariable @NonNull Long id) {
    Product product = productService.findById(id);
    return ResponseEntity.ok(ProductMapper.toDto(product));
  }

  @GetMapping("/")
  public ResponseEntity<List<ProductResponseDto>> getAll() {
    List<ProductResponseDto> products = ProductMapper.toListDto(productService.findAll());
    return ResponseEntity.ok().body(products);
  }
}
