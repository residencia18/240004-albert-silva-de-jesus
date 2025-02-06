package com.swproject.tradein.web.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swproject.tradein.entities.Employee;
import com.swproject.tradein.entities.UserSystem;
import com.swproject.tradein.services.EmployeeService;
import com.swproject.tradein.services.UserSystemService;
import com.swproject.tradein.web.dto.EmployeeResponseDto;
import com.swproject.tradein.web.dto.form.EmployeeForm;
import com.swproject.tradein.web.dto.mapper.EmployeeMapper;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private UserSystemService usuarioService;

  @PostMapping
  public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeForm createDto) {

    Long userId = createDto.getUsuarioId();

    if(userId == null) {
      throw new IllegalArgumentException("O parâmetro 'usuarioId' não pode ser nulo.");
    }

    UserSystem usuario = usuarioService.findById(userId);
    Employee employee = employeeService.save(EmployeeMapper.toEmployee(createDto, usuario));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
    return ResponseEntity.created(uri).body(EmployeeMapper.toDto(employee));
  
  }
}
