package com.swproject.sellgenius.web.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swproject.sellgenius.entities.Employee;
import com.swproject.sellgenius.services.EmployeeService;
import com.swproject.sellgenius.web.dto.EmployeeResponseDto;
import com.swproject.sellgenius.web.dto.form.EmployeeForm;
import com.swproject.sellgenius.web.dto.mapper.EmployeeMapper;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeForm createDto) {
    Employee employee = employeeService.save(EmployeeMapper.toEmployee(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
    return ResponseEntity.created(uri).body(EmployeeMapper.toDto(employee));
  }
}
