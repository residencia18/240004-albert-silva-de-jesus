package com.swprojets.productsales.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swprojets.productsales.entities.Employee;
import com.swprojets.productsales.services.EmployeeServiceV2;
import com.swprojets.productsales.web.dto.EmployeeResponseDto;
import com.swprojets.productsales.web.dto.mapper.EmployeeMapper;
import com.swprojets.productsales.web.exceptions.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Employees", description = "Contém todas as operações aos recursos para cadastro, edição e leitura de um funcionário.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeControllerV2 {

  @Autowired
  @Qualifier("v2")
  private EmployeeServiceV2 employeeService;

  @Operation(summary = "Recuperar um funcionário pelo id", description = "Recurso para recuperar um funcionário pelo id.", responses = {
      @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/{id}")
  public ResponseEntity<EmployeeResponseDto> getById(@PathVariable @NonNull Long id) {
    return employeeService.findById(id)
        .map(employee -> ResponseEntity.ok(EmployeeMapper.toDto(employee)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Operation(summary = "Listar todos os funcionários", description = "Listar os funcionários cadastrados de forma paginada", responses = {
      @ApiResponse(responseCode = "200", description = "Lista com todos os funcionarios cadastrados(Paginado)", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmployeeResponseDto.class))))
  })
  @GetMapping
  public ResponseEntity<Page<EmployeeResponseDto>> findAll(Pageable pageable) {
    Page<EmployeeResponseDto> list = employeeService.findAllPaged(pageable);
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/sortedemployees")
  public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(@RequestParam(defaultValue = "id,desc") String[] sort) {
    try {
      List<EmployeeResponseDto> employees = employeeService.findAllSorted(sort);
      if (employees.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(employees, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
