package com.swprojects.makrosales.web.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swprojects.makrosales.entities.Employee;
import com.swprojects.makrosales.entities.UserSystem;
import com.swprojects.makrosales.services.EmployeeServiceV2;
import com.swprojects.makrosales.services.UserSystemService;
import com.swprojects.makrosales.web.dto.EmployeeResponseDto;
import com.swprojects.makrosales.web.dto.form.EmployeeForm;
import com.swprojects.makrosales.web.dto.mapper.EmployeeMapper;
import com.swprojects.makrosales.web.exceptions.ErrorMessage;

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
  @Qualifier("employeeServiceV2")
  private EmployeeServiceV2 employeeService;

  @Autowired
  private UserSystemService usuarioService;

  @Operation(summary = "Cria um novo funcionário", description = "Recurso para criar um novo funcionário no sistema.", responses = {
      @ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDto.class))),
      @ApiResponse(responseCode = "409", description = "Funcionario cpf já cadastrado no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "422", description = "Recursos não processados por dados de entrada invalidos.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @PostMapping
  public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeForm createDto) {
    UserSystem usuario = usuarioService.findById(createDto.getUsuarioId());
    Employee employee = employeeService.create(EmployeeMapper.toEmployee(createDto, usuario));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
    return ResponseEntity.created(uri).body(EmployeeMapper.toDto(employee));
  }

  @Operation(summary = "Recuperar um funcionário pelo id", description = "Recurso para recuperar um funcionário pelo id.", responses = {
      @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/{id:\\d+}")
  public ResponseEntity<EmployeeResponseDto> getById(@PathVariable @NonNull Long id) {
    return employeeService.findById(id)
        .map(employee -> ResponseEntity.ok(EmployeeMapper.toDto(employee)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Operation(summary = "Listar todos os funcionários", description = "Listar os funcionários cadastrados de forma paginada", responses = {
      @ApiResponse(responseCode = "200", description = "Lista com todos os funcionarios cadastrados(Paginado)", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmployeeResponseDto.class))))
  })
  @GetMapping
  public ResponseEntity<Page<EmployeeResponseDto>> getAll(Pageable pageable) {
    Page<EmployeeResponseDto> employeePage = employeeService.findAllPaged(pageable);
    return ResponseEntity.ok().body(employeePage);
  }

  @Operation(summary = "Obter todos os funcionários ordenados", description = "Obtém todos os funcionários cadastrados ordenados de acordo com os critérios especificados", responses = {
      @ApiResponse(responseCode = "200", description = "Lista de funcionários retornada com sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmployeeResponseDto.class)))),
      @ApiResponse(responseCode = "204", description = "Nenhum funcionário encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/sortedemployees")
  public ResponseEntity<List<EmployeeResponseDto>> sortedemployees(
      @RequestParam(defaultValue = "id,desc") String[] sort) {
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

  @Operation(summary = "Obter todos os funcionários paginados", description = "Obtém todos os funcionários cadastrados de forma paginada", responses = {
      @ApiResponse(responseCode = "200", description = "Lista de funcionários retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))),
      @ApiResponse(responseCode = "204", description = "Nenhum funcionárioencontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/getAllEmployees")
  public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    Page<EmployeeResponseDto> employeePage = employeeService.findAll(PageRequest.of(page, size));
    if (employeePage.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(employeePage, HttpStatus.OK);
  }

  @Operation(summary = "Encontrar funcionários ativos", description = "Encontra os funcionários ativos de acordo com os critérios especificados", responses = {
      @ApiResponse(responseCode = "200", description = "Funcionários ativos encontrados com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @GetMapping("/employees/active") // findActiveEmployees
  public ResponseEntity<Map<String, Object>> findActiveEmployees(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "3") int size) {

    try {
      Map<String, Object> response = employeeService.findActiveEmployees(page, size);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "Atualizar funcionário", description = "Atualiza um funcionário existente pelo seu ID", responses = {
      @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDto.class))),
      @ApiResponse(responseCode = "404", description = "Funcionário não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @PutMapping("/{id}")
  public ResponseEntity<EmployeeResponseDto> update(@PathVariable @NonNull Long id,
      @RequestBody EmployeeForm createDto) {
    return employeeService.update(id, createDto)
        .map(employee -> ResponseEntity.ok(EmployeeMapper.toDto(employee)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Operation(summary = "Excluir funcionário", description = "Exclui um funcionário existente pelo seu ID", responses = {
      @ApiResponse(responseCode = "204", description = "Funcionário excluído com sucesso"),
      @ApiResponse(responseCode = "404", description = "Funcionário não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
    employeeService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
