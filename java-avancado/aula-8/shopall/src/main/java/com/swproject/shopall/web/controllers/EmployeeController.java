package com.swproject.shopall.web.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swproject.shopall.entities.Employee;
import com.swproject.shopall.entities.Usuario;
import com.swproject.shopall.services.EmployeeService;
import com.swproject.shopall.services.UsuarioService;
import com.swproject.shopall.web.dto.EmployeeResponseDto;
import com.swproject.shopall.web.dto.form.EmployeeForm;
import com.swproject.shopall.web.dto.mapper.EmployeeMapper;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private UsuarioService usuarioService;

  @PostMapping
  public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeForm createDto) {

    Long userId = createDto.getUsuarioId();

    if(userId == null) {
      throw new IllegalArgumentException("O parâmetro 'usuarioId' não pode ser nulo.");
    }

    Usuario usuario = usuarioService.findById(userId);
    Employee employee = employeeService.save(EmployeeMapper.toEmployee(createDto, usuario));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
    return ResponseEntity.created(uri).body(EmployeeMapper.toDto(employee));
  
  }
}
